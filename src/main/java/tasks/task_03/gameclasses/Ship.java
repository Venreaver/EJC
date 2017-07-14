package tasks.task_03.gameclasses;

import tasks.task_03.GameConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Ship class represent ship on game board
 */
public class Ship {
    /**
     * List of cells which are parts of the this ship
     */
    private List<Cell> cellList;
    /**
     * List of cells which surround this ship
     */
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

    /**
     * Check whether the ship is alive
     *
     * @return <code>true</code> if at least one cell from cellList isn't shot otherwise <code>false</code>
     */
    public boolean isAlive() {
        for (Cell cell : cellList) {
            if (!cell.isShot()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get maximum ship row index
     *
     * @return maximum ship row index
     */
    public int getMaxShipRow() {
        int maxShipRow = -1;
        for (Cell cell : cellList) {
            if (maxShipRow < cell.getRow()) {
                maxShipRow = cell.getRow();
            }
        }
        return maxShipRow;
    }

    /**
     * Get minimum ship row index
     *
     * @return minimum ship row index
     */
    public int getMinShipRow() {
        int minShipRow = 100;
        for (Cell cell : cellList) {
            if (minShipRow > cell.getRow()) {
                minShipRow = cell.getRow();
            }
        }
        return minShipRow;
    }

    /**
     * Get maximum ship column index
     *
     * @return maximum ship column index
     */
    public int getMaxShipCol() {
        int maxShipCol = -1;
        for (Cell cell : cellList) {
            if (maxShipCol < cell.getCol()) {
                maxShipCol = cell.getCol();
            }
        }
        return maxShipCol;
    }

    /**
     * Get minimum ship column index
     *
     * @return minimum ship column index
     */
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
