package View;

import javax.swing.*;
import java.awt.*;

public class        WelcomePanel extends JPanel {

    WelcomeFrame    headFrame;
    int             pX;
    int             pY;

    public          WelcomePanel(WelcomeFrame headFrame, int px, int py) {
        this.headFrame = headFrame;
        this.pX = px;
        this.pY = py;
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        JButton startGameBtn = new JButton("Play");
        startGameBtn.setBounds(pX/2 - pX/6, pY/4 - pY/12, pX/3, pY/6);
        startGameBtn.addActionListener(e -> headFrame.startGame());
        this.add(startGameBtn);
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.setBounds(pX/2 - pX/6, pY/2 - pY/12, pX/3, pY/6 );
        settingsBtn.addActionListener(e -> headFrame.createSettingsFrame());
        this.add(settingsBtn);
        JButton exitGameBtn = new JButton("Exit");
        exitGameBtn.setBounds(pX/2 - pX/6, (pY/4 * 3) - pY/12, pX/3, pY/6);
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
