package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener{
    private final int   FIELD_SIZE = 320;
    private final int   CELL_SIZE = 16;
    private Image       dot;
    private Image       apple;
    private int         appleX;
    private int         appleY;
    private int[]       fieldCellX = new int[(FIELD_SIZE / CELL_SIZE) * (FIELD_SIZE / CELL_SIZE)];
    private int[]       fieldCellY = new int[(FIELD_SIZE / CELL_SIZE) * (FIELD_SIZE / CELL_SIZE)];
    private int         snakeSize;
    private Timer       timer;
    private boolean     left;
    private boolean     right;
    private boolean     up;
    private boolean     down;
    Action              upAction;
    Action              downAction;
    Action              leftAction;
    Action              rightAction;
    private boolean     inGame = true;

    public GameField() {
        this.upAction = new UpAction();
        this.downAction = new DownAction();
        this.leftAction = new LeftAction();
        this.rightAction = new RightAction();
        this.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        this.getActionMap().put("upAction", upAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        this.getActionMap().put("downAction", downAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        this.getActionMap().put("leftAction", leftAction);
        this.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        this.getActionMap().put("rightAction", rightAction);
        setBackground(Color.black);
        loadImages();
        initGame();
        //this.addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void     initGame() {
        setMovingRight();
        this.snakeSize = 3;
        for (int i = 0; i < this.snakeSize; i++) {
            fieldCellX[i] = 48 - i * CELL_SIZE;
            fieldCellY[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        createApple();
    }

    public void     createApple() {
        this.appleX = new Random().nextInt(20) * CELL_SIZE;
        this.appleY = new Random().nextInt(20) * CELL_SIZE;
    }

    public void     loadImages() {
        ImageIcon   iia = new ImageIcon("src/main/resources/apple.jpg");
        this.apple = iia.getImage();
        ImageIcon   iid = new ImageIcon("src/main/resources/field.jpg");
        this.dot = iid.getImage();
    }

    public void     restartGame() {
        Component[] componentList = this.getComponents();
        for(Component c : componentList) {
            if (c instanceof JButton)
                this.remove(c);
        }
        this.revalidate();
        this.repaint();
        setMovingRight();
        this.inGame = true;
        initGame();
        setFocusable(true);
    }

    public void     setMovingRight() {
        if (!this.left) {
            this.right = true;
            this.up = false;
            this.down = false;
        }
    }

    public void     setMovingLeft() {
        if (!this.right) {
            this.left = true;
            this.up = false;
            this.down = false;
        }
    }

    public void     setMovingUp() {
        if (!this.down) {
            this.left = false;
            this.right = false;
            this.up = true;
        }
    }

    public void     setMovingDown() {
        if (!this.up) {
            this.left = false;
            this.right = false;
            this.down = true;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < this.snakeSize; i++) {
                g.drawImage(dot, fieldCellX[i], fieldCellY[i], this);
            }
        } else {
            JButton gameOverBtn = new JButton("Try again");
            gameOverBtn.setBounds(FIELD_SIZE/2 - 45, FIELD_SIZE/2 + 15,90, 30);
            gameOverBtn.addActionListener(e -> restartGame());
            this.add(gameOverBtn);
            String gameOver = "Game Over";
            Font font =  new Font("Arial", Font.BOLD, 16);
            g.setColor(Color.white);
            g.setFont(font);
            g.drawString(gameOver, 118, FIELD_SIZE/2 - 8);
            timer.stop();
        }
    }

    public void     move() {
        for (int i = this.snakeSize; i > 0; i--) {
            fieldCellX[i] = fieldCellX[i - 1];
            fieldCellY[i] = fieldCellY[i - 1];
        }
        if (left)
            fieldCellX[0] -= CELL_SIZE;
        if (right)
            fieldCellX[0] += CELL_SIZE;
        if (up)
            fieldCellY[0] -= CELL_SIZE;
        if (down)
            fieldCellY[0] += CELL_SIZE;
    }

    public void     checkApple() {
        if (fieldCellX[0] == appleX && fieldCellY[0] == appleY) {
            this.snakeSize++;
            createApple();
        }
    }

    public void     checkCollisions() {
        for (int i = this.snakeSize; i > 0; i--) {
            if (i > 4 && fieldCellX[0] == fieldCellX[i] && fieldCellY[0] == fieldCellY[i]) {
                inGame = false;
                break;
            }
        }

        if (fieldCellX[0] > FIELD_SIZE)
            inGame = false;
        if (fieldCellY[0] > FIELD_SIZE)
            inGame = false;
        if (fieldCellX[0] < 0)
            inGame = false;
        if (fieldCellY[0] < 0)
            inGame = false;
    }

    @Override
    public void     actionPerformed(ActionEvent e) {
        if (this.inGame) {
            checkApple();
            checkCollisions();
            move();
        }
        this.repaint();
    }

    class UpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMovingUp();
        }
    }

    class DownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMovingDown();
        }
    }

    class LeftAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMovingLeft();
        }
    }

    class RightAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            setMovingRight();
        }
    }
}
