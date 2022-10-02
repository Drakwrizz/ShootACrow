package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, attackKey, shiftKey, EPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();
        if (gp.GameState == gp.TitleState || gp.GameState == gp.difSeclctState ||gp.GameState == gp.GameOverState){
            if (Key == KeyEvent.VK_UP) {
                gp.titleSelection--;
            }
            if (Key == KeyEvent.VK_DOWN){
                gp.titleSelection++;
            }
            if (Key == KeyEvent.VK_K){
                EPressed = true;
            }
        }

        if (Key == KeyEvent.VK_RIGHT){
            if (gp.GameState == gp.playState){rightPressed = true;}
        }
        if (Key == KeyEvent.VK_LEFT){
            if (gp.GameState == gp.playState){leftPressed = true;}
        }
        if (Key == KeyEvent.VK_UP){
            if (gp.GameState == gp.playState){upPressed = true;}
        }
        if (Key == KeyEvent.VK_DOWN){
            if (gp.GameState == gp.playState){downPressed = true;}
        }

        if (Key == KeyEvent.VK_K){
            if (gp.GameState == gp.playState){attackKey = true;
            }
        }
        if (Key == KeyEvent.VK_SHIFT){
            if (gp.GameState == gp.playState){shiftKey = true;}
        }
        if (Key == KeyEvent.VK_L){
            if (gp.GameState == gp.playState){
                gp.GameState = gp.pauseState;
            }
            else if (gp.GameState == gp.pauseState){
                gp.GameState = gp.playState;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int Key = e.getKeyCode();

        if (Key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if (Key == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if (Key == KeyEvent.VK_UP){
            upPressed = false;
        }
        if (Key == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if (Key == KeyEvent.VK_K){
            attackKey = false;
        }
        if (Key == KeyEvent.VK_SHIFT){
            shiftKey = false;
        }
    }
}
