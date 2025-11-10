package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.observerPatten.SnakeEvent;
import view.statePatten.GameState;
import view.statePatten.GameStatePlaying;

public class TimerListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        GameState state = App.win.getGameState();
        state.animate();

        if (state instanceof GameStatePlaying) {
            detectCollision();
        }

        App.win.getCanvas().repaint();
    }

    private void detectCollision() {
        // Snake vs. Food
        if (App.model.SnakeGotFood()) {
            App.model.snake.notifyObservers(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }

        // Snake vs. Wall
        if (App.model.snakeLeftScene()) {
            App.model.snake.notifyObservers(SnakeEvent.HIT_WALL);
        }

        // Snake vs. Self
        if (App.model.snakeHitsItsBody()) {
            App.model.snake.notifyObservers(SnakeEvent.HIT_SELF);
        }
    }
}