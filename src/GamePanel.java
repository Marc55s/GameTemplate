import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel implements Runnable {

    private Thread thread;
    final int originalTileSize = 16;
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public GamePanel() {
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void update(double delta) {

    }

    public void startGameThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double FPS = 60;
        double frames = 0;
        double timer = 0;
        double drawInterval = 1_000_000_000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (thread.isAlive()) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime -lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update(delta);
                paintImmediately(getBounds());
                frames++;
                delta--;
            }
            if(timer >= 1_000_000_000){
                System.out.println("FPS : "+frames);
                timer = 0;
                frames = 0;
            }
        }
    }
}