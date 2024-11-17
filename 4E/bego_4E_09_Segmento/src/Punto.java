public class Punto {
    private int x;
    private int y;
/*
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
 */

    public Punto() {
        this.x = 10;
        this.y = 10;
    }

    public Punto(int x, int y) throws Exception {
        if (x > 40) {
            throw new Exception("OutOfRange x");
        }

        if (y > 50) {
            throw new Exception("OutOfRange y");
        }

        this.setX(x);
        this.setY(y);
    }

    public int getQuadrante() throws Exception {
        if (this.x > 0 && this.y > 0) {
            return 1;
        } else if (this.x < 0 && this.y > 0) {
            return 2;
        }else if (this.x < 0 && this.y < 0) {
            return 3;
        } else if (this.x > 0 && this.y < 0) {
            return 4;
        }

        throw new Exception("Il punto e' sugli assi");
    }

    public Punto(int y) throws Exception {
        this(23, y);
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    private void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("X: %d, Y: %d", x, y);
    }
}