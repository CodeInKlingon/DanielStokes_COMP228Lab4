package Exercise1;

import java.awt.event.*;


public class InputManager implements KeyListener {

    static boolean Space = false;
    static  boolean W = false;
    static boolean S = false;
    static  boolean Up = false;
    static boolean Down = false;

    public InputManager(){
        System.out.println("create input manager");
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
        UpdateInputs(e, true);
    }
    @Override
    public void keyReleased(KeyEvent e){
        UpdateInputs(e, false);
    }

    private void UpdateInputs(KeyEvent e, boolean b) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            W = b;

        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            S = b;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Up = b;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Down = b;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Space = b;
        }
    }

}
