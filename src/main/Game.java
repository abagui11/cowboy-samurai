package main;

import gameStates.*;
import gameStates.Menu;


import java.awt.*;

public class Game implements Runnable{

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameLoop;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    private Playing playing;
    private Menu menu;
    private Rules rules;

    private End end;


    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE*SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    public Game() {
        initializeClasses();
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();


    }

    private void initializeClasses(){
        menu = new Menu(this);
        playing = new Playing(this);
        rules = new Rules(this);
        end = new End(this);
    }

    private void startGameLoop(){
        gameLoop = new Thread(this);
        gameLoop.start();
    }

    public void update(){
        switch(Gamestate.state){
            case MENU:
                menu.update();
                break;
            case PLAYING:
                playing.update();
                break;
            case RULES:
                rules.update();
                break;
            case END:
                end.update();
                break;
            case QUIT:
            default:
                System.exit(0);
                break;
        }
    }

    public void render(Graphics g){
        switch(Gamestate.state){
            case MENU:
            menu.draw(g);
                break;
            case PLAYING:
            playing.draw(g);
                break;
            case RULES:
                rules.draw(g);
                break;
            case END:
                end.draw(g);
                break;
            default:
                break;
        }

    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while(true){
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;


            if(deltaU >= 1){
                update();
                updates++;
                deltaU--;
            }
            if(deltaF >= 1){
                gamePanel.repaint();
                frames++;
                deltaF--;
            }


        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS" + frames + " | UPS: " + updates);
            frames = 0;
            updates = 0;
        }

        
        }

    }

    public void windowFocusLost(){
        if(Gamestate.state == Gamestate.PLAYING){
            playing.getPlayer().resetDirBooleans();
        }
    }

    public Menu getMenu(){
        return menu;
    }

    public Playing getPlaying(){
        return playing;
    }

    public Rules getRules(){
        return rules;
    }

    public End getEnd(){
        return end;
    }

}
