package Exercise2;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Game extends Scene {


    boolean playing;

    Label p1ScoreLabel;
    Label p2ScoreLabel;
    Label winnerLabel;

    Ball ball;
    Paddle lPaddle;
    Paddle rPaddle;

    int p1Score;
    int p2Score;
    Pane root;

    public Game(Pane root) {

        super(root, 1200, 720, Color.BLACK);
        playing = true;
        this.root = root;

        //create score
        p1ScoreLabel = new Label("0");
        p1ScoreLabel.resizeRelocate(450,0, 150,150);
        p1ScoreLabel.setTextFill(Color.web("#FFFFFF"));
        p1ScoreLabel.setFont(new Font(70));


        p2ScoreLabel = new Label("0");
        p2ScoreLabel.resizeRelocate(700,0, 150,150);
        p2ScoreLabel.setStyle("-fx-foreground-color: white");
        p2ScoreLabel.setTextFill(Color.web("#FFFFFF"));
        p2ScoreLabel.setFont(new Font(70));
        p2ScoreLabel.setTextAlignment(TextAlignment.RIGHT);



        //create player win label
        winnerLabel = new Label("Player is a winner");
        winnerLabel.resizeRelocate(250,100, 1200,720);
        winnerLabel.setTextFill(Color.web("#FFFFFF"));
        winnerLabel.setFont(new Font(70));

        winnerLabel.setVisible(false);


        //create paddles
        lPaddle = new Paddle(PlayerPaddle.Left);
        rPaddle = new Paddle(PlayerPaddle.Right);


        //create ball
        ball = new Ball(this);


        //create background
        Pane bg = new Pane();
        bg.setPrefSize(1200,720);
        bg.setStyle("-fx-background-color: #000000");


        Pane net = new Pane();
        net.setPrefSize(616,740);
        net.relocate(-15,-11 );
        net.setStyle("-fx-background-color: white;");
                  net.setStyle(" -fx-border-color: white ;");

        root.getChildren().add(bg);
        root.getChildren().add(net);
        root.getChildren().add(ball);
        root.getChildren().add(lPaddle);
        root.getChildren().add(rPaddle);
        root.getChildren().add(winnerLabel);
        root.getChildren().add(p2ScoreLabel);
        root.getChildren().add(p1ScoreLabel);

        InputManager im = new InputManager();



        //input manger staic boolean set here
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    InputManager.Up = true;  break;
                    case DOWN:   InputManager.Down = true; break;
                    case W:   InputManager.W  = true; break;
                    case S:  InputManager.S  = true; break;
                    case SPACE:  InputManager.Space = true; break;
                }
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    InputManager.Up = false;  break;
                    case DOWN:   InputManager.Down = false; break;
                    case W:   InputManager.W  = false; break;
                    case S:  InputManager.S  = false; break;
                    case SPACE:  InputManager.Space = false; break;
                }
            }
        });
    }


    //update function to calll update on all other objects
    public void Update() {

        ball.Update();
        lPaddle.Update();
        rPaddle.Update();

    }


    //score logic
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


    //reset score
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
