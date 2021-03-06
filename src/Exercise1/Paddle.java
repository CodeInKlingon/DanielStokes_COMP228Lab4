package Exercise1;

import javax.swing.*;
import java.awt.*;

public class Paddle extends JPanel implements GameObject {

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
        setBounds(xPosition - 40, yPosition,40,100);
        setBackground(Color.white);
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


        setBounds(xPosition, yPosition,40,100);

     }


}


