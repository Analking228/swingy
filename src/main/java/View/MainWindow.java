package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class        MainWindow extends JFrame {

    public          MainWindow() {
        super("CockTail");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int wSX = 320;
        int wSY = 345;
        this.setSize(wSX, wSY);
        this.setLocation(dimension.width/2 - (wSX)/2, dimension.height/2 - (wSY)/2);
        //this.setLayout(null);
        this.add(new GameField());
        this.setVisible(true);
        //setFocusable(true);
    }
}
