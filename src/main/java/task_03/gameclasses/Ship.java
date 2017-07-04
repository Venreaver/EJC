package task_03.gameclasses;

import task_03.GameConfig;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Cell> cellList;
    private List<Cell> cellShadowList;
    private int shipSize;

    public Ship() {
        this.cellList = new ArrayList<>(GameConfig.MAX_SHIP_SIZE);
        this.cellShadowList = new ArrayList<>(GameConfig.MAX_SHIP_SIZE * 2 + 6);
    }

    public Ship(int shipSize) {
        this();
        this.shipSize = shipSize;
    }

    public int getShipSize() {
        return shipSize;
    }

    public List<Cell> getCellList() {
        return cellList;
    }

    public List<Cell> getCellShadowList() {
        return cellShadowList;
    }

    public boolean isAlive() {
        for (Cell cell : cellList) {
            if (!cell.isShot()) {
                return true;
            }
        }
        return false;
    }

    public int getMaxShipRow() {
        int maxShipRow = -1;
        for (Cell cell : cellList) {
            if (maxShipRow < cell.getRow()) {
                maxShipRow = cell.getRow();
            }
        }
        return maxShipRow;
    }

    public int getMinShipRow() {
        int minShipRow = 100;
        for (Cell cell : cellList) {
            if (minShipRow > cell.getRow()) {
                minShipRow = cell.getRow();
            }
        }
        return minShipRow;
    }

    public int getMaxShipCol() {
        int maxShipCol = -1;
        for (Cell cell : cellList) {
            if (maxShipCol < cell.getCol()) {
                maxShipCol = cell.getCol();
            }
        }
        return maxShipCol;
    }

    public int getMinShipCol() {
        int minShipCol = 100;
        for (Cell cell : cellList) {
            if (minShipCol > cell.getCol()) {
                minShipCol = cell.getCol();
            }
        }
        return minShipCol;
    }
}
