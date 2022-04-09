package Controller;

import View.GameFrame;
import View.SettingsFrame;
import View.WelcomeFrame;

import javax.swing.*;
import java.util.ArrayList;

public class            FrameController {
    ArrayList<JFrame>   mainFrames;
    ArrayList<JFrame>   secondaryFrames;
    int                 defaultWidth;
    int                 defaultHeight;

    public              FrameController() {
        assert false;
        this.defaultWidth = 500;
        this.defaultHeight = 500;
        mainFrames.add(new WelcomeFrame(this, this.defaultWidth, this.defaultHeight));
    }



    public void         changeDefaults(int defx, int defy) {
        this.defaultWidth = defx;
        this.defaultHeight = defy;
    }

    public void         createSettingsFrame() {
        this.secondaryFrames.add(new SettingsFrame());
    }

    public void         toSnakeGameFrame(int boundsX, int boundsY) {
        mainFrames.add(new GameFrame(boundsX, boundsY));
    }

    public void         exitGame() {
        System.exit(0);
    }
}
