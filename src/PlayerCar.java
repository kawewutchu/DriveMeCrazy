import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ACER on 10/30/2016.
 */
public class PlayerCar implements KeyListener{

    private boolean left,right;

    private int x,y;
    private double speed;
    private int offset;

    public PlayerCar()
    {
        x = Display.width/2 ;
        y = Tile.tileHeight * 13;              //temporary

        offset = 0;
        speed = 0.5f;

    }

    public void initial()
    {
        Display.frame.addKeyListener(this);
    }

    public void update()
    {
        offset = y - (Display.height - 100);

        if(right)
        {
            x += 1;
        }
        if(left)
        {
            x -= 1;
        }
        y -= speed;
    }

    public void render(Graphics graphic)
    {
        graphic.drawImage(LoadImage.car,x,y - offset,60,80,null);

        speed += 0.003f;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
        if(source == KeyEvent.VK_LEFT)
        {
            left = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        if(source == KeyEvent.VK_LEFT)
        {
            left = false;
        }
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getOfset()
    {
        return offset;
    }

}
