package View;

import Controller.FrameController;

import javax.swing.*;
import java.awt.*;

public class        WelcomeFrame extends JFrame {

    FrameController observer;

    public          WelcomeFrame(FrameController frameController, int gameFiledX, int gameFiledY) {
        super("Welcome to SnakeApple game");
        this.observer = frameController;
        int     wSX = gameFiledX + this.getInsets().left + this.getInsets().right;
        int     wSY = gameFiledY + this.getInsets().bottom + this.getInsets().top;
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        Dimension   dimension = toolkit.getScreenSize();
        this.setSize(wSX, wSY);
        this.setLocation(dimension.width/2 - (wSX)/2, dimension.height/2 - (wSY)/2);
        this.add(new WelcomePanel(this, gameFiledX, gameFiledY));
        this.setVisible(true);
    }

    void    createSettingsFrame() {
        this.observer.createSettingsFrame();
    }

    void    startGame() {
        this.dispose();
        this.observer.toSnakeGameFrame(this.getInsets().left + this.getInsets().right, this.getInsets().bottom + this.getInsets().top);  // костыль с 25 +- рамкой
    }

    void    exitGame() {
        this.dispose();
        this.observer.exitGame();
    }
}
