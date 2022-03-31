package View;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

    WelcomeFrame    headFrame;
    int             wSX;
    int             wSY;

    public WelcomePanel(WelcomeFrame headFrame, int wsx, int wsy) {
        this.headFrame = headFrame;
        this.wSX = wsx;
        this.wSY = wsy;
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        JButton startGameBtn = new JButton("Play");
        startGameBtn.setBounds(wSX/2 - wSY/6, wSY/4 - wSY/12, wSX/3, wSY/6);
        startGameBtn.addActionListener(e -> headFrame.startGame(wSX, wSY));
        this.add(startGameBtn);
        JButton exitGameBtn = new JButton("Exit");
        exitGameBtn.setBounds(wSX/2 - wSY/6, (wSY/4 * 3) - wSY/12, wSX/3, wSY/6);
        exitGameBtn.addActionListener(e -> headFrame.exitGame());
        this.add(exitGameBtn);
        setFocusable(true);
        requestFocusInWindow();
        requestFocus();
    }
    @Override
    protected void  paintComponent(Graphics g) {
    }
}
