package view;

import javax.swing.JPanel;

import controller.App;
import model.Food;
import model.Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class AppCanvas extends JPanel {

    public static final int CANVAS_WIDTH = 600;
    public static final int CANVAS_HEIGHT = 400;

    public AppCanvas() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawScore(g2, App.model.score);
        drawSnake(g2, App.model.snake);
        if (App.model.food != null)
            drawFood(g2, App.model.food);
        if (App.model.messages != null)
            drawMessages(g2, App.model.messages);

    }

    void drawScore(Graphics2D g2, int score) {
        g2.setColor(Color.white);
        g2.setFont(new Font("Courier new", Font.BOLD, 24));
        g2.drawString("Score: " + score, AppCanvas.WIDTH - 180, 30);
    }

    void drawSnake(Graphics2D g2, Snake snake) {
    }

    void drawFood(Graphics2D g2, Food food) {
    }

    void drawMessages(Graphics2D g2, String messages) {
    }
}
