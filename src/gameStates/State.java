package gameStates;

import main.Game;

import java.awt.event.MouseEvent;
import ui.MenuButton;

public class State {

    protected Game game;
    public boolean isIn(MouseEvent e, MenuButton mb) {
        return mb.getBounds().contains(e.getX(), e.getY());
    }
    public State(Game game){
        this.game = game;
    }
    public Game getGame(){
        return game;
    }
}
