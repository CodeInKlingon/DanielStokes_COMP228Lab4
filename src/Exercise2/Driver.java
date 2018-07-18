package Exercise2;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Driver extends Application {

    static boolean start = false;
    static Game game;

    public static void main(String[] args) throws InterruptedException {

        launch(args);

//
//        MainMenu menu = new MainMenu();
//        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        menu.setSize(260, 180);
//        menu.setVisible(true);





//        while(true){
//
//            if(start){
//
//                game.show();
//                menu.setVisible(false);
//                break;
//            }
//
//            Thread.sleep(16);
//        }
//
//        while(start){
//
//            //update on all objects
//            game.Update();
//
//            Thread.sleep(16);
//
//        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        game = new Game(root);
        primaryStage.setScene(game);
        primaryStage.show();

        start = true;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                game.Update();
            }
        };
        timer.start();

    }
}
