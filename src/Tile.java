import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by ACER on 10/30/2016.
 */
public class Tile {

    public BufferedImage texture;
    public static Tile[] tiles = new Tile[1000];

    public static Tile Grass1Tile = new Grass1Tile(0);
    public static Tile Grass2Tile = new Grass2Tile(1);
    public static Tile Soil1Tile = new Soil1Tile(2);
    public static Tile Soil2Tile = new Soil2Tile(3);
    public static Tile Soil3Tile = new Soil3Tile(4);
    public static Tile Soil4Tile = new Soil4Tile(5);
    public static Tile ForestTile = new ForestTile(6);

    public static Tile Road1Tile = new Road1Tile(7);
    public static Tile Road2Tile =new Road2Tile(8);
    public static Tile Road3Tile = new Road3Tile(9);
    public static Tile Road4Tile = new Road4Tile(10);

    public static final int  tileWidth = 80,tileHeight = 80;

    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        tiles[id] = this;
    }

    public void render(Graphics graphic, int x, int y)
    {
        graphic.drawImage(texture,x,y,null);
    }
}
