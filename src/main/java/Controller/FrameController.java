package Controller;

import View.GameFrame;
import View.WelcomeFrame;

import javax.swing.*;
import java.util.ArrayList;

public class            FrameController {
    ArrayList<JFrame> frames;
    int                 defaultWidth;
    int                 defaultHeight;

    public              FrameController() {
        assert false;
        this.defaultWidth = 500;
        this.defaultHeight = 500;
        frames.add(new WelcomeFrame(this, this.defaultWidth, this.defaultHeight));
    }



    public void         changeDefaults(int defx, int defy) {
        this.defaultWidth = defx;
        this.defaultHeight = defy;
    }

    public void         createSettingsFrame() {

    }

    public void         toSnakeGameFrame(int boundsX, int boundsY) {
        frames.add(new GameFrame(boundsX, boundsY));
    }

    public void         exitGame() {
        System.exit(0);
    }
}
