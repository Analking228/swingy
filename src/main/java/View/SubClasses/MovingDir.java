package View.SubClasses;

public class            MovingDir {

    private int         previousDir;
    private int         currentDir;
    private final int   RIGHT = 1;
    private final int   DOWN = 2;
    private final int   LEFT = 3;
    private final int   UP = 4;

    public          MovingDir() {
        this.setPreviousDir(RIGHT);
        this.setMovingRight();
    }


    public void     setMovingRight() {
        this.currentDir = RIGHT;
    }

    public void     setMovingLeft() {
        this.currentDir = LEFT;
    }

    public void     setMovingUp() {
        this.currentDir = UP;
    }

    public void     setMovingDown() {
        this.currentDir = DOWN;
    }

    public void     setPreviousDir(int dir) {
        this.previousDir = dir;
    }
    public int      getPreviousDir() {
        return this.previousDir;
    }

    public int      getMovingDir() {
        return this.currentDir;
    }
}
