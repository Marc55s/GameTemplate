import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    int x, y;
    int width, height;
    double speed;
    BufferedImage img;

    public GameObject(int x, int y, int width, int height, double speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public GameObject(int x, int y, int width, int height, double speed, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.img = img;
    }

    public abstract void update(double delta);

    public abstract void render(Graphics g);

}
