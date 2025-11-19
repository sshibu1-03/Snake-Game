package model.strategyPatten;

import controller.App;
import model.observerPatten.SnakeEvent;

public class FastStrategy implements GameStrategy {

    private int tickCount = 0;

    @Override
    public void animate() {

        tickCount++;

        // Always move once per frame
        App.model.snake.move();

        // Check food after first move
        if (App.model.SnakeGotFood()) {
            App.model.snake.notifyObservers(SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();
        }

        // Every 3 frames, move again — slightly faster, not crazy
        if (tickCount % 3 == 0) {
            App.model.snake.move();

            if (App.model.SnakeGotFood()) {
                App.model.snake.notifyObservers(SnakeEvent.HIT_FOOD);
                App.model.food = App.model.createFood();
            }
        }
    }

    @Override
    public String getName() {
        return "Fast";
    }
}
