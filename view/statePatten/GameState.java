package view.statePatten;

import view.AppWindow;

public interface GameState {
    void goNext(AppWindow Context);
    void animate();
}
