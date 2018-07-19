package Exercise2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Driver extends Application {

    static boolean start = false;
    static Game game;

    public static void main(String[] args) throws InterruptedException {

        launch(args);

    }


    //show main menu
    @Override
    public void start(Stage primaryStage) {

        VBox sp = new VBox();
        sp.setAlignment(Pos.CENTER);
        MainMenu menu = new MainMenu(sp,this,primaryStage);
        primaryStage.setScene(menu);
        primaryStage.show();

    }


    //change scene to game
    public void play(Stage primaryStage){
        Pane root = new Pane();
        game = new Game(root);
        primaryStage.setScene(game);
        start = true;


        //update game scene every frame
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                game.Update();
            }
        };
        timer.start();
    }
}
