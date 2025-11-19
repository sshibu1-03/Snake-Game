package model.strategyPatten;

import controller.App;

public class BombStrategy implements GameStrategy {

    private int bombCount = 1; // start with 1 bomb

    @Override
    public void animate() {

        App.model.snake.move();

        if (App.model.SnakeGotFood()) {

            App.model.snake.notifyObservers(model.observerPatten.SnakeEvent.HIT_FOOD);
            App.model.food = App.model.createFood();

            bombCount++;

            App.model.bombs.clear();
            for (int i = 0; i < bombCount; i++) {
                App.model.bombs.add(App.model.createBomb());
            }
        }

        if (App.model.bombs.size() == 0) {
            for (int i = 0; i < bombCount; i++) {
                App.model.bombs.add(App.model.createBomb());
            }
        }
    }

    @Override
    public String getName() {
        return "Bombs";
    }
}
