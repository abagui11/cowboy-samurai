package utils;

import gameStates.Gamestate;
import gameStates.Playing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static gameStates.Gamestate.*;

public class Stopwatch implements ActionListener {

    public int countdown_time = 100000;
    int seconds = (countdown_time/60000) % 60;
    int minutes = (countdown_time/1000) % 60;
    boolean started = false;
    public String seconds_string = String.format("%02d", seconds);
    public String minutes_string = String.format("%02d", minutes);

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {

            if(countdown_time < 1){
                timer.stop();
            }
            countdown_time = countdown_time-1000;
            minutes = (countdown_time/60000) % 60;
            seconds = (countdown_time/1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);

        }

    });

    public Stopwatch(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Gamestate.state == PLAYING){
            start();
        }
    }

    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }
    public void reset(){
        countdown_time = 100000;
    }
}
