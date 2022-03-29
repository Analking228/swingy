package View;

import View.SubClasses.MovingDir;

import javax.swing.*;
import java.awt.*;

public class        MainWindow extends JFrame {

    public          MainWindow() {
        super("CockTail");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int wSX = 500;
        int wSY = wSX + 25;
        this.setSize(wSX, wSY);
        this.setLocation(dimension.width/2 - (wSX)/2, dimension.height/2 - (wSY)/2);
        this.add(new GameField(wSX, new MovingDir()));
        this.setVisible(true);
    }
}
