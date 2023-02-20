package gameStates;

import main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Rules extends State implements Statemethods{
    public Rules(Game game) {
        super(game);

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        Color bg_color = new Color (25,7,3);
        g.setColor(bg_color);
        g.fillRect(0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT);
        g.setColor(Color.white);
        g.setFont(new Font("Sans Serif",Font.BOLD,18));
        g.drawString("The crabs have taken over!", Game.GAME_WIDTH / 3, 150);
        g.setColor(Color.red);
        g.drawString("Only the Cowboy Samurai can save us now...", Game.GAME_WIDTH / 3, 200);
        g.setColor(Color.white);
        g.setFont(new Font("Sans Serif",Font.PLAIN,15));
        g.drawString("Press W to jump, A to go left, D to go right, and Space to attack.", Game.GAME_WIDTH / 3, 250);
        g.drawString("Kill as many crabs as you can to save the desert.", Game.GAME_WIDTH / 3, 300);
        g.drawString("<- Press backspace to go back to the menu", Game.GAME_WIDTH / 5, 425);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
            Gamestate.state = Gamestate.MENU;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
