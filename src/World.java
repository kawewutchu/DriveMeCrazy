import java.awt.*;
import java.awt.List;
import java.io.*;
import java.util.*;

/**
 * Created by ACER on 10/30/2016.
 */
public class World {

    private int width, height;
    private int map[][];

    private PlayerCar playerCar;


    public World(PlayerCar playercar) {
        loadWorld();
        this.playerCar = playercar;
    }

   public void render(Graphics graphic) {

       int start = Math.max(0, (playerCar.getOfset() - (4 * Tile.tileHeight)) / Tile.tileHeight);
       int end = Math.min(height, (playerCar.getOfset() + Display.height + 80) / Tile.tileHeight);

       int i;
       int j;
       for (i = 0; i < width; i++) {
           for (j = start; j < end; j++) {
               Tile t = Tile.tiles[map[i][j]];
               t.render(graphic, i * Tile.tileWidth, (j * Tile.tileHeight) - playerCar.getOfset());
           }

       }
   }


    public void loadWorld() {
        File file = new File("resource/world.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        width = sc.nextInt();
        height = sc.nextInt();
        map = new int[width][height];

        for (int j = 0; j < height; j++)
        {
            for (int i = 0; i < width; i++)
            {
                map[i][j] = sc.nextInt();
            }
        }
    }
}