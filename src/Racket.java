import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Racket extends Sprite {
    private final Pong game;

    public Racket(Pong game, int y) {
        super((game.getWidth() - 60) / 2, y, 0, 0, 60, 10);
        this.game = game;
    }

    public void pressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT)
            setXA(-1);
        else if (key == KeyEvent.VK_RIGHT)
            setXA(1);
    }

    public void released(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
            setXA(0);
    }

    public void updatePosition() {
        if (getX() + getXA() >= 0 && getX() + getXA() < game.getWidth() - getWidth())
            setX(getX() + getXA());
    }

    public void paint(Graphics g) {
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}