package model.strategyPatten;

import controller.App;

public class NormalStrategy implements GameStrategy {

    @Override
    public void animate() {
        App.model.snake.move();
    }

    @Override
    public String getName() {
        return "Normal";
    }
}
