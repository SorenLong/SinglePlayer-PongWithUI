import java.awt.Graphics;

public class Ball extends Sprite {

    public Ball() {
        super(0, 0, 1, 1, 30, 30);
    }

    public void updatePosition() {
        setX(getX() + getXA());
        setY(getY() + getYA());
    }

    public void paint(Graphics g) {
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}