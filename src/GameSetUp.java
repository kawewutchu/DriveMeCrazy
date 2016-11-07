import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by ACER on 10/29/2016.
 */
public class GameSetUp implements Runnable{

    private Thread thread;
    private int width,height;
    private String title;
    private Display display;

    private BufferStrategy buffer;
    private Graphics graphic;

    private GameManager manager;

    public GameSetUp(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public void initial()
    {
        display = new Display(title,width,height);
        manager = new GameManager();
        manager.initial();
    }

    public void update()
    {
        manager.update();
    }

    public void render()
    {
        buffer = display.canvas.getBufferStrategy();
        if(buffer == null)
        {
            display.canvas.createBufferStrategy(3);
            return;
        }
        graphic = buffer.getDrawGraphics();
        graphic.clearRect(0,0,width,height);

        manager.render(graphic);

        buffer.show();
        graphic.dispose();
    }

    public synchronized void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop()
    {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run()
    {
        int fps = 80;                     //Speed depends on fps
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();

        initial();

        while(true)
        {
            delta = delta + (System.nanoTime() - current)/timePerTick;
            current = System.nanoTime();
            if(delta >= 1)
            {
                update();
                render();
                delta--;
            }
        }
    }

}
