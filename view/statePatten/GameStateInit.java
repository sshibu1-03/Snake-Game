package view.statePatten;

import controller.App;
import view.AppWindow;

public class GameStateInit implements GameState {

    public GameStateInit() {
        App.win.startPauseButton.setText(AppWindow.START_ACTION);
        App.win.restartButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
    }

    @Override
    public void goNext(AppWindow Context) {
        Context.setGameState(new GameStatePlaying());
    }

    @Override
    public void animate() {
        // No animation in Init state
    }

    
    
}
