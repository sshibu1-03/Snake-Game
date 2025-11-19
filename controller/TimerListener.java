package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.observerPatten.SnakeEvent;
import view.statePatten.GameState;
import view.statePatten.GameStateOver;
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

        // Snake vs. Bombs
        for (var b : App.model.bombs) {
            var head = App.model.snake.nodes.get(0);
            if (head.x == b.x && head.y == b.y) {

                // Set message
                App.model.messages = "Hit a bomb - Press <Restart>";

                // Move to Game Over state directly
                App.win.setGameState(new GameStateOver());

                return;
            }
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
