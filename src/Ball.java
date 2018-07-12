import javax.swing.*;
import java.awt.*;

public class Ball extends JPanel implements GameObject {

    int width = 26;
    double speed;

    boolean launched;

    int xPosition;
    int yPosition;

    int xMovement = 0;
    int yMovement = 0;
    Game game;


    public Ball(Game game){
        super();
        this.game = game;
        launched = false;

        xPosition = (1200 / 2) - (width/2);
        yPosition = (720 / 2) - (width/2) ;
        setBounds(xPosition, yPosition,width,width);
        setBackground(Color.white);
    }

    @Override
    public void Update() {

        if(!launched){

            if(InputManager.Space){
                launched = true;
                xMovement = 3;
                yMovement = 0;
            }

        }

        if(launched){
            //launch logic

            //check for walls hit
            if(yPosition <=0){
                yMovement = yMovement * -1;
            }else if( yPosition >= (720 - width * 2)){
                yMovement = yMovement * -1;
            }

            //check for paddle hit
            if( xPosition <= 80){
                System.out.println("check left paddle");
                //left paddle check
                int yPaddlePosition = game.lPaddle.yPosition + 50;
                int yBallPOsition = yPosition + 13;
                //calculate y distance for hit
                int yDistance = Math.abs(yPaddlePosition - yBallPOsition);
                int yAmount = yPaddlePosition - yBallPOsition;
                System.out.println(yDistance);
                if(yDistance <= 63){
                    //hit and reflect
                    if(yDistance < 2){
                        yMovement = 0;
                        xMovement = 5;
                    }else if(yDistance < 20){
                        yMovement = 2;
                        xMovement = 3;
                    }else{
                        yMovement = 3;
                        xMovement = 2;
                    }

                    if(yBallPOsition < yPaddlePosition){
                        yMovement = yMovement * -1;
                    }
                }

            }else if(xPosition >= 1100 ){
                System.out.println("check right paddle");

                //right paddle check
                int yPaddlePosition = game.rPaddle.yPosition + 50;
                int yBallPOsition = yPosition + 13;

                int yDistance = Math.abs(yPaddlePosition - yBallPOsition);
                int yAmount = yPaddlePosition - yBallPOsition;

                System.out.println(yDistance);
                if(yDistance <= 63){
                    //hit and reflect
                    if(yDistance < 2){
                        yMovement = 0;
                        xMovement = -5;
                    }else if(yDistance < 20){
                        yMovement = 2;
                        xMovement = -3;
                    }else{
                        yMovement = 3;
                        xMovement = -2;
                    }

                    if(yBallPOsition < yPaddlePosition){
                        yMovement = yMovement * -1;
                    }

                }

            }

            //check for goal boundaries hit

            xPosition = xPosition + xMovement;
            yPosition = yPosition + yMovement;
            setBounds(xPosition, yPosition,width,width);
        }


    }
}

