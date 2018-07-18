package Exercise1;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {


    boolean playing;

    JLabel p1ScoreLabel;
    JLabel p2ScoreLabel;
    JLabel winnerLabel;

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
        p1ScoreLabel.setForeground(Color.white);
        p1ScoreLabel.setFont(new Font(p1ScoreLabel.getFont().getName(),p1ScoreLabel.getFont().getStyle(), 70));
        add(p1ScoreLabel);

        p2ScoreLabel = new JLabel("0");
        p2ScoreLabel.setBounds(600,0, 150,150);
        p2ScoreLabel.setForeground(Color.white);
        p2ScoreLabel.setFont(new Font(p1ScoreLabel.getFont().getName(),p1ScoreLabel.getFont().getStyle(), 70));
        p2ScoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(p2ScoreLabel);

        //create player win label
        winnerLabel = new JLabel("Player is a winner");
        winnerLabel.setBounds(0,100, 1200,720);
        winnerLabel.setForeground(Color.white);
        winnerLabel.setFont(new Font(winnerLabel.getFont().getName(),winnerLabel.getFont().getStyle(), 70));
        winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        winnerLabel.setVisible(false);
        add(winnerLabel);

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
        bg.setLayout(null);
        add(bg);

        JPanel net = new JPanel();
        net.setBounds(-11,-11,616,740);
        net.setBackground(Color.BLACK);
        net.setForeground(Color.white);
        net.setBorder(BorderFactory.createDashedBorder(null,10,5,5,false));
        bg.add(net);

        InputManager im = new InputManager();
        addKeyListener(im);

    }

    public void Update() {

        ball.Update();
        lPaddle.Update();
        rPaddle.Update();

    }

    public void AddScore(PlayerPaddle player){

        switch (player){
            case Left:
                p1Score++;
                p1ScoreLabel.setText(Integer.toString(p1Score));
                if(p1Score >=11){
                    EndGame(PlayerPaddle.Left);
                }
                break;
            case Right:
                p2Score++;
                p2ScoreLabel.setText(Integer.toString(p2Score));
                if(p2Score >=11){
                    EndGame(PlayerPaddle.Right);
                }
                break;
        }

        ball.Reset();

    }

    public void EndGame(PlayerPaddle winner){

        p1Score = 0;
        p1ScoreLabel.setText(Integer.toString(p1Score));

        p2Score = 0;
        p2ScoreLabel.setText(Integer.toString(p2Score));

        playing = false;

        String winnerText = "";
        switch(winner){
            case Left:
                winnerText = "1";
                break;
            case Right:
                winnerText = "2";
                break;
        }

        winnerLabel.setText("Player " + winnerText + " is the winner");
        winnerLabel.setVisible(true);

    }

    public void Reset(){

    }

}
