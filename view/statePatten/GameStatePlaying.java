package view.statePatten;

import controller.App;
import model.strategyPatten.GameStrategy;
import view.AppWindow;

public class GameStatePlaying implements GameState {

    public GameStatePlaying() {
        App.win.startPauseButton.setText(AppWindow.PAUSE_ACTION);
        App.win.restartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
        App.win.modeButton.setEnabled(false); // lock mode while playing
    }

    @Override
    public void goNext(AppWindow context) {
        if (App.model.snakeHitsItsBody() || App.model.snakeLeftScene())
            context.setGameState(new GameStateOver());
        else
            context.setGameState(new GameStatePaused());
    }

    @Override
    public void animate() {
        // Use current strategy (Normal, Fast, Bombs)
        GameStrategy strategy = App.model.getGameStrategy();
        if (strategy != null)
            strategy.animate();
        else
            App.model.snake.move();
    }
}
