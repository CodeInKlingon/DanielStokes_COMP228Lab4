package Exercise2;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;

public class Paddle extends Pane implements GameObject {

    int moveSpeed = 3;
    PlayerPaddle player;
    int xPosition;
    int yPosition = 360-50;

    public Paddle(PlayerPaddle player){
        super();
        switch (player){
            case Right:
                xPosition = 1200 - 80;
                break;
            case Left:
                xPosition = 40;
                break;
        }

        setPrefSize(40,100);
        relocate(xPosition - 40, yPosition);
        setStyle("-fx-background-color: white");
        this.player = player;
    }
     @Override
    public void Update(){

         switch (player){
             case Right:
                 if(InputManager.Down){

                     if(yPosition + moveSpeed <= 620 ){
                         yPosition = yPosition + moveSpeed;
                     }
                     //if can move up
                     //move up
                 }else if(InputManager.Up){
                     if(yPosition - moveSpeed >= 0 ){
                         yPosition = yPosition - moveSpeed;
                     }
                 }
                 break;
             case Left:
                 if(InputManager.S){

                     if(yPosition + moveSpeed <= 620 ){
                         yPosition = yPosition + moveSpeed;
                     }
                     //if can move up
                     //move up
                 }else if(InputManager.W){
                     if(yPosition - moveSpeed >= 0 ){
                         yPosition = yPosition - moveSpeed;
                     }
                 }
                 break;
         }


         relocate(xPosition, yPosition);

     }


}


