package View;

import javax.swing.*;
import java.awt.*;

public class SettingsFrame extends JFrame {

    public                  SettingsFrame() {
        super("Settings");
        this.setLayout(null);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        Dimension   dimension = toolkit.getScreenSize();
        this.setSize(300, 300);
        this.setLocation(dimension.width/2 - 300/2, dimension.height/2 - 300/2);
        this.setVisible(true);
    }

}
