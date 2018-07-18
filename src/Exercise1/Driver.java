package Exercise1;

import javax.swing.*;


public class Driver  {

    static boolean start = false;
    static Game game;

    public static void main(String[] args) throws InterruptedException {
//
        MainMenu menu = new MainMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(260, 180);
        menu.setVisible(true);





        while(true){

            if(start){
                game = new Game();
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                game.setSize(1200, 720);
                game.setVisible(true);
                menu.setVisible(false);
                break;
            }

            Thread.sleep(16);
        }

        while(true){

            //update on all objects
            game.Update();

            Thread.sleep(16);

        }

    }
}
