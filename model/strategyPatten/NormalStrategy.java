package model.strategyPatten;

import controller.App;

public class NormalStrategy implements GameStrategy {

    @Override
    public void animate() {
        // Original behavior: move snake once per frame
        App.model.snake.move();
    }

    @Override
    public String getName() {
        return "Normal";
    }
}
