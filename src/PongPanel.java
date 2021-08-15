import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel {
private Racket racket;
private Ball ball;
private JLabel scoreLabel;
private int score = 0;




public PongPanel(Pong game) {
    racket = new Racket(game, game.getHeight() - 100);
    ball = new Ball();

    scoreLabel = new JLabel(Integer.toString(score));
    scoreLabel.setFont(new Font("sansserif", Font.PLAIN, 30));
    add(scoreLabel);

    Timer timer = new Timer(5, new TimerHandler());
    timer.start();

    addKeyListener(new KeyHandler());
    setFocusable(true);
}

private void update() {
    racket.updatePosition();
    ball.updatePosition();
    checkCollisionBallSides();
    checkCollisionBallRacket();
    repaint();
}

private void checkCollisionBallSides() {
    if (ball.getX() < 0 || ball.getX() > getWidth() - ball.getWidth() - (getInsets().left + getInsets().right))
        ball.setXA(-ball.getXA());
    else if (ball.getY() < 0)
        ball.setYA(-ball.getYA());
    else if (ball.getY() > getHeight() - ball.getHeight()) {
        JOptionPane.showMessageDialog(null, "Game Over. You scored " + score + ".", "Pong", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

private void checkCollisionBallRacket() {
    if (ball.getBounds().y + ball.getHeight() == racket.getBounds().y &&
        ball.getBounds().x + ball.getWidth() > racket.getBounds().x &&
        racket.getBounds().x + racket.getWidth() > ball.getBounds().x) {
        ball.setYA(-ball.getYA());
        score++;
        scoreLabel.setText(Integer.toString(score));
    }
}

@Override
public void paint(Graphics g) {
    super.paint(g);
    racket.paint(g);
    ball.paint(g);
}

private class KeyHandler implements KeyListener {
    @Override
    public void keyPressed(KeyEvent e) {
        racket.pressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        racket.released(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {          
    }   
}

private class TimerHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
    }
}
}