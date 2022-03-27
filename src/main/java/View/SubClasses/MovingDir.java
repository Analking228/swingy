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
        if (!this.left) {
            this.right = true;
            this.up = false;
            this.down = false;
        }
    }

    public void     setMovingLeft() {
        if (!this.right) {
            this.left = true;
            this.up = false;
            this.down = false;
        }
    }

    public void     setMovingUp() {
        if (!this.down) {
            this.left = false;
            this.right = false;
            this.up = true;
        }
    }

    public void     setMovingDown() {
        if (!this.up) {
            this.left = false;
            this.right = false;
            this.down = true;
        }
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
