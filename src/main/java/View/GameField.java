package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener{
    private final int   SIZE_PIXEL = 320;
    private final int   DOT_SIZE = 16;
    private final int   ALL_DOTS = 400;
    private Image       dot;
    private Image       apple;
    private int         appleX;
    private int         appleY;
    private int[]       x = new int[ALL_DOTS];
    private int[]       y = new int[ALL_DOTS];
    private int         snakeSize;
    private Timer       timer;
    private boolean     left = false;
    private boolean     right = true;
    private boolean     up = false;
    private boolean     down = false;
    private boolean     inGame = true;

    public GameField() {
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void     initGame() {
        this.snakeSize = 3;
        for (int i = 0; i < this.snakeSize; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void     createApple() {
        this.appleX = new Random().nextInt(20) * DOT_SIZE;
        this.appleY = new Random().nextInt(20) * DOT_SIZE;
    }

    public void     loadImages() {
        ImageIcon   iia = new ImageIcon("src/main/resources/apple.jpg");
        this.apple = iia.getImage();
        ImageIcon   iid = new ImageIcon("src/main/resources/field.jpg");
        this.dot = iid.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < this.snakeSize; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        }
    }

    public void     move() {
        for (int i = this.snakeSize; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left)
            x[0] -= DOT_SIZE;
        if (right)
            x[0] += DOT_SIZE;
        if (up)
            y[0] -= DOT_SIZE;
        if (down)
            y[0] += DOT_SIZE;
    }

    public void     checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            this.snakeSize++;
            createApple();
        }
    }

    public void     checkCollisions() {
        for (int i = this.snakeSize; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
                break;
            }
        }

        if (x[0] > SIZE_PIXEL)
            inGame = false;
        if (y[0] > SIZE_PIXEL)
            inGame = false;
        if (x[0] < 0)
            inGame = false;
        if (y[0] < 0)
            inGame = false;
    }

    @Override
    public void     actionPerformed(ActionEvent e) {
        if (this.inGame) {
            checkApple();
            checkCollisions();
            move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down) {
                left = false;
                up = true;
                right = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                left = false;
                down = true;
                right = false;
            }
        }
    }
}
