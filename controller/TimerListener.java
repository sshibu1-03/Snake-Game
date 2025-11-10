package controller;

import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        App.model.snake.move();
        App.win.getCanvas().repaint();
    }

}
