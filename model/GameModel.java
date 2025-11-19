package model;

import java.util.ArrayList;
import java.util.Random;

import controller.App;
import view.AppCanvas;
import view.AppWindow;
import model.strategyPatten.GameStrategy;
import model.strategyPatten.NormalStrategy;

public class GameModel {

    public Snake snake;
    public Food food;
    public String messages;
    public int score;

    // Bombs on the scene
    public ArrayList<Bomb> bombs;

    // Strategy Pattern: current game strategy
    private GameStrategy gameStrategy;

    public GameModel() {
        snake = new Snake();
        bombs = new ArrayList<>();
        gameStrategy = new NormalStrategy(); // default
        init();
    }

    public void init() {
        snake.init();
        score = 0;
        messages = "Click <Start> to Play";
        food = createFood();
        bombs.clear();
    }

    public Food createFood() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
            y = random.nextInt(AppCanvas.HEIGHT / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        } while (isInsideSnake(x, y) || isBombAt(x, y));
        return new Food(x, y);
    }

    public Bomb createBomb() {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(AppCanvas.WIDTH / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
            y = random.nextInt(AppCanvas.HEIGHT / AppWindow.GRID_SIZE) * AppWindow.GRID_SIZE;
        } while (isInsideSnake(x, y) || (food != null && food.x == x && food.y == y) || isBombAt(x, y));
        return new Bomb(x, y);
    }

    private boolean isInsideSnake(int x, int y) {
        for (var node : snake.nodes) {
            if (node.x == x && node.y == y)
                return true;
        }
        return false;
    }

    private boolean isBombAt(int x, int y) {
        for (var b : bombs) {
            if (b.x == x && b.y == y)
                return true;
        }
        return false;
    }

    public boolean SnakeGotFood() {
        var food = App.model.food;
        var head = App.model.snake.nodes.get(0);
        return food.x == head.x && food.y == head.y;
    }

    public boolean snakeLeftScene() {
        var head = App.model.snake.nodes.get(0);
        return head.x <= 0 || head.x >= AppCanvas.WIDTH
                || head.y <= 0 || head.y >= AppCanvas.HEIGHT;
    }

    public boolean snakeHitsItsBody() {
        var nodes = App.model.snake.nodes;
        var head = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            var n = nodes.get(i);
            if (head.x == n.x && head.y == n.y)
                return true;
        }
        return false;
    }

    // ===== Strategy Pattern: getter/setter =====

    public void setGameStrategy(GameStrategy strategy) {
        this.gameStrategy = strategy;
    }

    public GameStrategy getGameStrategy() {
        return gameStrategy;
    }
}
