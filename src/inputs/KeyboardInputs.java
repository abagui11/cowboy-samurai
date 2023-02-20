package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import gameStates.Gamestate;
import main.Game;
import main.GamePanel;
import static utils.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().keyPressed(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyPressed(e);
                break;
            case RULES:
                gamePanel.getGame().getRules().keyPressed(e);
                break;
            case END:
                gamePanel.getGame().getEnd().keyPressed(e);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(Gamestate.state){
            case MENU:
                gamePanel.getGame().getMenu().keyReleased(e);
                break;
            case PLAYING:
                gamePanel.getGame().getPlaying().keyReleased(e);
                break;
            case RULES:
                gamePanel.getGame().getRules().keyPressed(e);
                break;
            case END:
                gamePanel.getGame().getEnd().keyPressed(e);
                break;
        }
    }
}
