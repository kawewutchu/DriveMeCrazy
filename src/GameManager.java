import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm;

import java.awt.*;

/**
 * Created by ACER on 10/30/2016.
 */
public class GameManager {

    private PlayerCar playerCar;
    private World world;

    public GameManager()
    {
        playerCar = new PlayerCar();
        world = new World(playerCar); // Temporary
    }

    public void initial()
    {
        LoadImage.initial();
        playerCar.initial();
    }

    public void update()
    {
        playerCar.update();
    }

    public void render(Graphics graphic)
    {
        world.render(graphic);
        playerCar.render(graphic);
    }
}
