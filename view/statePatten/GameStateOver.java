package view.statePatten;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState {

    public GameStateOver() {
        // Restart MUST be enabled so user can recover from game over.
        App.win.restartButton.setEnabled(true);

        // Pause/Start should be disabled
        App.win.startPauseButton.setEnabled(false);

        // Mode button stays disabled until restart
        App.win.modeButton.setEnabled(false);
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateInit());
    }

    @Override
    public void animate() {
        // Fall animation
        App.model.snake.falling();
    }
}
