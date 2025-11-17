package model.strategyPatten;

import controller.App;

public class FastStrategy implements GameStrategy {

    @Override
    public void animate() {

        // First move
        App.model.snake.move();
        if (App.model.SnakeGotFood()) {
            App.model.snake.notifyObservers(model.observerPatten.SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }

        // Second move
        App.model.snake.move();
        if (App.model.SnakeGotFood()) {
            App.model.snake.notifyObservers(model.observerPatten.SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }
    }

    @Override
    public String getName() {
        return "Fast";
    }
}

