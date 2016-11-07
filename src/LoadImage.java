import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Created by ACER on 10/30/2016.
 */
public class LoadImage {

    public static BufferedImage carFullImage,gridFullImage,roadFullImage;
    public static BufferedImage grass1,grass2,soil1,soil2,soil3,soil4,forest;
    public static BufferedImage road1,road2,road3,road4;
    public static BufferedImage car;

    public static void initial()
    {
        gridFullImage = imageLoader("/grid.png");
        carFullImage = imageLoader("/Car_Common1.png");
        roadFullImage = imageLoader("/roadGrid.png");
        crop();
    }

    public static BufferedImage imageLoader(String path)
    {
        try {
            return ImageIO.read(LoadImage.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return  null;
    }

    public static void crop()
    {
        grass1 = gridFullImage.getSubimage(0,0,80,80);
        grass2 = gridFullImage.getSubimage(80,0,80,80);
        soil1 = gridFullImage.getSubimage(80*2,0,80,80);
        soil2 = gridFullImage.getSubimage(80*3,0,80,80);
        soil3 = gridFullImage.getSubimage(80*4,0,80,80);
        soil4 = gridFullImage.getSubimage(0,80,80,80);
        forest = gridFullImage.getSubimage(80,80,80,80);

        road1 = roadFullImage.getSubimage(0,0,80,80);
        road2 = roadFullImage.getSubimage(80,0,80,80);
        road3 = roadFullImage.getSubimage(80*2,0,80,80);
        road4 =roadFullImage.getSubimage(80*3,0,80,80);

        car = carFullImage.getSubimage(31,0,161,256);
    }
}
