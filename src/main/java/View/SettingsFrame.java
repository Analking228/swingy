package View;

import Controller.FrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener {

    FrameController         observer;
    JTextField              textField;
    JButton                 button;
    int                     snakeGameSize;

    public                  SettingsFrame(FrameController observer) {
        super("Settings");
        this.observer = observer;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        //this.setSize(300, 300);
        this.setResizable(false);

        button = new JButton("Submit");
        button.addActionListener(this);
        this.add(button);
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        this.add(textField);
        this.pack(); // размер подстраивается под компоненты внутри фрейма
        this.setLocation(dimension.width/2 - this.getWidth()/2, dimension.height/2 - this.getHeight()/2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.observer.setDefaults(snakeGameSize = Integer.parseInt(textField.getText()));
            this.dispose();
        }
    }
}
