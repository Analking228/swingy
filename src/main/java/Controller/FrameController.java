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
        this.defaultWidth = 500;
        this.defaultHeight = 500;
        assert (mainFrames != null);
        mainFrames.add(new WelcomeFrame(this, this.defaultWidth, this.defaultHeight));
    }



    public void         changeDefaults(int defx, int defy) {
        this.defaultWidth = defx;
        this.defaultHeight = defy;
    }

    public void         createSettingsFrame() {
        this.secondaryFrames.add(new SettingsFrame(this));
    }

    public void         toSnakeGameFrame(int boundsX, int boundsY) {
        this.mainFrames.add(new GameFrame(defaultWidth + boundsX, defaultHeight + boundsY));
    }

    public void         exitGame() {
        System.exit(0);
    }

    public void         setDefaults(int defaults) {
        if (defaults < 0)
        defaults = -defaults;
        if (defaults > 1080)
        defaults = 1080;
        defaultWidth = defaultHeight = defaults;
    }
}
