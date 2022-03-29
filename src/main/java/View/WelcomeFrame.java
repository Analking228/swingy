package View;

import Controller.FrameController;

import javax.swing.*;
import java.awt.*;

public class        WelcomeFrame extends JFrame {

    FrameController observer;
    int             wSX;
    int             wSY;

    public          WelcomeFrame(FrameController frameController, int boundsX, int boundsY) {
        super("Welcome to SnakeApple game");
        this.observer = frameController;
        wSX = boundsX;
        wSY = boundsY;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        Dimension   dimension = toolkit.getScreenSize();
        this.setSize(wSX, wSY);
        this.setLocation(dimension.width/2 - (wSX)/2, dimension.height/2 - (wSY)/2);
        this.add(new WelcomePanel(this, wSX, wSY));
        this.setVisible(true);
    }

    void    startGame(int boundsX, int boundsY) {
        this.observer.toSnakeGameFrame(boundsX, boundsY);
    }

    void    exitGame() {
        this.observer.exitGame();
    }
}
