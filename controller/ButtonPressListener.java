package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.strategyPatten.BombStrategy;
import model.strategyPatten.FastStrategy;
import model.strategyPatten.NormalStrategy;
import view.AppWindow;

public class ButtonPressListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        JButton button = (JButton) e.getSource();

        switch (action) {
            case AppWindow.START_ACTION:
                App.model.messages = null;
                App.win.goNextState();
                App.win.modeButton.setEnabled(false); // lock mode after start
                button.setText(AppWindow.PAUSE_ACTION);
                App.timer.start();
                break;

            case AppWindow.PAUSE_ACTION:
                App.win.goNextState();
                App.model.messages = "Paused - Press <Resume>";
                App.timer.stop();
                App.win.getCanvas().repaint();
                break;

            case AppWindow.RESTART_ACTION:
                App.timer.stop();
                App.model.init();
                App.model.setGameStrategy(new NormalStrategy());
                App.model.bombs.clear();
                App.win.modeButton.setEnabled(true);
                App.win.modeButton.setText(AppWindow.MODE_NORMAL);
                App.win.goNextState();
                App.win.getCanvas().repaint();
                break;

            case AppWindow.EXIT_ACTION:
                System.exit(0);
                break;

            case AppWindow.MODE_NORMAL:
                App.model.setGameStrategy(new FastStrategy());
                App.model.bombs.clear();
                App.model.messages = "Fast Mode";
                button.setText(AppWindow.MODE_FAST);
                App.win.getCanvas().repaint();
                break;

            case AppWindow.MODE_FAST:
                App.model.setGameStrategy(new BombStrategy());
                App.model.bombs.clear();
                App.model.messages = "Bomb Mode - Avoid the bombs!";
                button.setText(AppWindow.MODE_BOMBS);
                App.win.getCanvas().repaint();
                break;

            case AppWindow.MODE_BOMBS:
                App.model.setGameStrategy(new NormalStrategy());
                App.model.bombs.clear();
                App.model.messages = "Normal Mode";
                button.setText(AppWindow.MODE_NORMAL);
                App.win.getCanvas().repaint();
                break;
        }
    }
}
