import javax.swing.JFrame;

public class Pong extends JFrame {
    private static final int HEIGHT = 500, WIDTH = 900;

    public Pong() {
        super("Pong");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new PongPanel(this));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Pong();
    }
}