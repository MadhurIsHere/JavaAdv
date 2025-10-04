package My2DGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// used to handle the keyboard inputs
public class KeyHandler implements KeyListener{
    public boolean upPressed,downPressed,rightPressed,leftPressed;
    // Game example GTA vice city
    // Cheat codes we typed (always 'A' to 'Z' ,'a' to 'z' and  '0' to '9')
    @Override
    public void keyTyped(KeyEvent e) {

    }
    // Space bar to jump
    @Override
    public void keyPressed(KeyEvent e) { // input as e
        int code=e.getKeyCode(); //convert the key to the code (ASCII)

        // as per now we just wanna use left,right,forward and backward
        if(code==KeyEvent.VK_W) // for 'W'
        {
            upPressed=true;
        }
        if(code==KeyEvent.VK_A) // for 'A'
        {
            leftPressed=true;
        }
        if(code==KeyEvent.VK_S) // for 'S'
        {
            downPressed=true;
        }
        if(code==KeyEvent.VK_D) // for 'D'
        {
            rightPressed=true;
        }

    }
    // After pressing 'w' when we release the character stops
    @Override
    public void keyReleased(KeyEvent e) {
        int code =e.getKeyCode();

        if(code==KeyEvent.VK_W) // for 'W'
        {
            upPressed=false;
        }
        if(code==KeyEvent.VK_A) // for 'A'
        {
            leftPressed=false;
        }
        if(code==KeyEvent.VK_S) // for 'S'
        {
            downPressed=false;
        }
        if(code==KeyEvent.VK_D) // for 'D'
        {
            rightPressed=false;
        }
    }
}
