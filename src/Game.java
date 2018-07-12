import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.UnresolvedPermission;

public class Game extends JFrame implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        p1ScoreLabel.setText("holy crawp");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    boolean playing;

    JLabel p1ScoreLabel;
    JLabel p2ScoreLabel;
    Ball ball;
    Paddle lPaddle;
    Paddle rPaddle;


    int p1Score;
    int p2Score;

    public Game() {
        super("Pong - game");

        playing = true;
        setLayout(null);

        //create score
        p1ScoreLabel = new JLabel("0");
        p1ScoreLabel.setBounds(450,0, 150,150);
        p1ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.white));
        p1ScoreLabel.setForeground(Color.white);
        p1ScoreLabel.setFont(new Font(p1ScoreLabel.getFont().getName(),p1ScoreLabel.getFont().getStyle(), 70));
        add(p1ScoreLabel);

        p2ScoreLabel = new JLabel("0");
        p2ScoreLabel.setBounds(600,0, 150,150);
        p2ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.white));
        p2ScoreLabel.setForeground(Color.white);
        p2ScoreLabel.setFont(new Font(p1ScoreLabel.getFont().getName(),p1ScoreLabel.getFont().getStyle(), 70));
        p2ScoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(p2ScoreLabel);


        //create paddles
        lPaddle = new Paddle(PlayerPaddle.Left);
        rPaddle = new Paddle(PlayerPaddle.Right);
        add(lPaddle);
        add(rPaddle);

        //create ball
        ball = new Ball(this);
        add(ball);

        //create background
        JPanel bg = new JPanel();
        bg.setBounds(0,0,1200,720);
        bg.setBackground(Color.black);
        add(bg);

        InputManager im = new InputManager();
        addKeyListener(im);

    }

    public void Update() {

        ball.Update();
        lPaddle.Update();
        rPaddle.Update();


    }

}
