public class Plateaur {
    private int xSize;
    private int ySize;

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Plateaur(int xSize, int ySize) {
        this.xSize = xSize > 1 ? xSize : 0;
        this.ySize = ySize > 1 ? ySize : 0;
    }

    public boolean equals(Plateaur obj) {
        if (obj != null) {
            if (obj.getySize() == getySize() && obj.getxSize() == getxSize()) return true;
        }
        return false;
    }
}
