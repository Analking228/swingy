package View.SubClasses;

public class        MovingDir {

    private boolean  up;
    private boolean  down;
    private boolean  left;
    private boolean  right;

    public          MovingDir() {
        this.setMovingRight();
    }


    public void     setMovingRight() {
        this.right = true;
        this.up = false;
        this.down = false;
        this.left = false;
    }

    public void     setMovingLeft() {
        this.left = true;
        this.up = false;
        this.down = false;
        this.right = false;
    }

    public void     setMovingUp() {
        this.left = false;
        this.right = false;
        this.up = true;
        this.down = false;
    }

    public void     setMovingDown() {
        this.left = false;
        this.right = false;
        this.down = true;
        this.up = false;
    }

    public String  getMovingDir() {
        if (this.left) {
            return "left";
        }
        if (this.right) {
            return "right";
        }
        if (this.up) {
            return  "up";
        }
        return "down";
    }
}
