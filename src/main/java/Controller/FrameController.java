package Controller;

import View.GameFrame;
import View.WelcomeFrame;

import javax.swing.*;
import java.util.ArrayList;

public class            FrameController {
    ArrayList<JFrame> frames;

    public              FrameController() {
        frames.add(new WelcomeFrame(this, 500, 525));
    }

    public void         toSnakeGameFrame(int boundsX, int boundsY) {
        frames.add(new GameFrame(boundsX, boundsY));
    }

    public void         exitGame() {
        System.exit(0);
    }
}
