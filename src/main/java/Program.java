import View.GameField;
import View.MainWindow;
import View.MyComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.add(new GameField());
        mainWindow.setVisible(true);
    }
}
