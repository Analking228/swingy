package View;

import javax.swing.*;
import java.awt.*;

public class        MyComponent extends JComponent {

    @Override
    protected void  paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g;
        Font        font = new Font("Arial", Font.PLAIN, 30);
        graphics2D.setFont(font);
        graphics2D.drawString("Hello World, bitches", 50, 50);
        Image image = new ImageIcon("src/main/resources/5827_boobz.png").getImage();
        graphics2D.drawImage(image, 70, 70, null);
    }
}
