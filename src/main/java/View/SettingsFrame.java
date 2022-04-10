package View;

import Controller.FrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener {

    FrameController         observer;
    JTextField              sizeTF;
    JButton                 enterBtn;
    int                     snakeGameSize;

    public                  SettingsFrame(FrameController observer) {
        super("Set game field size");
        this.observer = observer;
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        Toolkit     toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        this.enterBtn = new JButton("Enter");
        this.enterBtn.addActionListener(this);
        this.add(enterBtn);
        this.sizeTF = new JTextField();
        this.sizeTF.setPreferredSize(new Dimension(250, 40));
        this.add(sizeTF);
        this.pack(); // размер подстраивается под компоненты внутри фрейма
        this.setLocation(dimension.width/2 - this.getWidth()/2, dimension.height/2 - this.getHeight()/2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.enterBtn) {
            this.observer.setDefaults(this.snakeGameSize = Integer.parseInt(this.sizeTF.getText()));
            this.dispose();
        }
    }
}
