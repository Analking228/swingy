package View;

import javax.swing.*;
import java.awt.*;

public class    SettingsPanel extends JPanel {

    JFrame      headFrame;

    public      SettingsPanel(JFrame observer) {
        this.headFrame = observer;
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        JTextField sizeTf = new JTextField("500");
        this.add(sizeTf);
        setFocusable(true);
        requestFocusInWindow();
        requestFocus();
    }
}
