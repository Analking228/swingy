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
        startGameBtn.setBounds(this.pX/2 - this.pX/6, this.pY/4 - this.pY/12, this.pX/3, this.pY/6);
        startGameBtn.addActionListener(e -> this.headFrame.startGame());
        this.add(startGameBtn);
        JButton settingsBtn = new JButton("Settings");
        settingsBtn.setBounds(this.pX/2 - this.pX/6, this.pY/2 - this.pY/12, this.pX/3, this.pY/6 );
        settingsBtn.addActionListener(e -> this.headFrame.createSettingsFrame());
        this.add(settingsBtn);
        JButton exitGameBtn = new JButton("Exit");
        exitGameBtn.setBounds(this.pX/2 - this.pX/6, (this.pY/4 * 3) - this.pY/12, this.pX/3, this.pY/6);
        exitGameBtn.addActionListener(e -> this.headFrame.exitGame());
        this.add(exitGameBtn);
        setFocusable(true);
        requestFocusInWindow();
        requestFocus();
    }

    @Override
    protected void  paintComponent(Graphics g) {
    }
}
