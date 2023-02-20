package gameStates;

import entities.Enemy;
import entities.EnemyManager;
import main.Game;
import utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class End extends State implements Statemethods {

    private BufferedImage backgroundImgDesert;


    public End(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        backgroundImgDesert = LoadSave.GetSpriteAtlas(LoadSave.MENU_BACKGROUND_IMG);
        g.drawImage(backgroundImgDesert, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);

        g.setColor(Color.white);
        g.setFont(new Font("Sans Serif",Font.BOLD,15));
        g.drawString("Game Over", (Game.GAME_WIDTH / 3), 100);
        g.drawString("Crabs Killed: " + EnemyManager.score, (Game.GAME_WIDTH / 3), 150);
        g.setFont(new Font("Sans Serif",Font.PLAIN,15));
        g.drawString("<- Press Backspace to Play Again ", Game.GAME_WIDTH / 4, 400);
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
