import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private final JLabel gameLabel;
    private final JButton btnPlay;
    private final JButton btnExit;

    public MainMenu(){
        super("Pong - Main Menu");
        setLayout(new GridLayout(3,1));

        gameLabel = new JLabel("Pong");
        gameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameLabel.setToolTipText("Pong Java Game");
        add(gameLabel);


        btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StartGame();
            }
        } );
        add(btnPlay);

        btnExit = new JButton("Exit");
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExitGame();
            }
        } );
        add(btnExit);

    }


    public void StartGame(){
        Driver.start = true;
    }

    public void ExitGame(){


    }

}
