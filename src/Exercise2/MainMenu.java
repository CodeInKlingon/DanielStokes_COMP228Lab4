package Exercise2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class MainMenu extends Scene {

    private final Label gameLabel;
    private final Button btnPlay;
    private final Button btnExit;
    VBox root;

    Driver driver;

    public MainMenu(VBox root, Driver driver, Stage stage){
        super(root, 200, 200);
        this.root = root;
        this.driver = driver;

        gameLabel = new Label("Pong");
        gameLabel.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().add(gameLabel);


        btnPlay = new Button("Play");
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                driver.play(stage);
            }
        });
        root.getChildren(). add(btnPlay);

        btnExit = new Button("Exit");
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                stage.close();
            }
        });
        root.getChildren(). add(btnExit);

    }


    public void StartGame(){
        Driver.start = true;
    }

    public void ExitGame(){


    }

}
