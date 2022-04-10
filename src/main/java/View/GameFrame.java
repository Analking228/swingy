package View;

import View.SubClasses.MovingDir;

import javax.swing.*;
import java.awt.*;

public class                GameFrame extends JFrame {

    int                     wSX;
    int                     wSY;

    public                  GameFrame(int boundsX, int boundsY) {
        super("CockTail");
        this.wSX = boundsX;
        this.wSY = boundsY;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit =   Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setSize(this.wSX, this.wSY);
        this.setLocation(dimension.width/2 - (this.wSX)/2, dimension.height/2 - (this.wSY)/2);
        this.setResizable(false);
        this.add(new GamePanel(this.wSX - this.getInsets().left - this.getInsets().right, new MovingDir()));
        this.setVisible(true);
    }
}
