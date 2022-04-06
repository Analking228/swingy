package View;

import View.SubClasses.MovingDir;

import javax.swing.*;
import java.awt.*;

public class                GameFrame extends JFrame {

    int                     wSX;
    int                     wSY;

    public                  GameFrame(int boundsX, int boundsY) {
        super("CockTail");
        wSX = boundsX;
        wSY = boundsY;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit =   Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setSize(wSX, wSY);
        this.setLocation(dimension.width/2 - (wSX)/2, dimension.height/2 - (wSY)/2);
        this.setResizable(false);
        this.add(new GamePanel(wSX, new MovingDir()));
        this.setVisible(true);
    }
}
