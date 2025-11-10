package view.statePatten;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState {

    public GameStateOver() {
        App.win.restartButton.setEnabled(true);
        App.win.startPauseButton.setEnabled(false);
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateInit());
    }

    @Override
    public void animate() {
        // Snake falls to the ground or game-over animation could go here
    }
}