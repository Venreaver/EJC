package task_03;

public class Cell {
    private int row = GameConfig.NOT_EXIST;
    private int col = GameConfig.NOT_EXIST;
    private boolean isShot;
    private boolean isPartOfShip;

    public Cell() {
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isShot() {
        return isShot;
    }

    public void setShot(boolean shot) {
        isShot = shot;
    }

    public boolean isPartOfShip() {
        return isPartOfShip;
    }

    public void setPartOfShip(boolean partOfShip) {
        isPartOfShip = partOfShip;
    }
}
