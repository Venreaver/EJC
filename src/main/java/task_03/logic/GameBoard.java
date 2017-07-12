package task_03.logic;

import task_03.GameConfig;
import task_03.gameclasses.Cell;
import task_03.gameclasses.Ship;

import java.util.ArrayList;
import java.util.List;

class GameBoard {
    private Cell[][] cells;
    private List<Cell> availableCellList;
    private List<Ship> shipList;

    GameBoard() {
        this.cells = new Cell[GameConfig.BOARD_SIZE][GameConfig.BOARD_SIZE];
        this.availableCellList = new ArrayList<>(GameConfig.BOARD_SIZE * GameConfig.BOARD_SIZE);
        this.shipList = new ArrayList<>();
        makeRandomBoard();
    }

    private void makeRandomBoard() {
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                if (cells[i][j] == null) {
                    cells[i][j] = new Cell(i, j);
                } else {
                    cells[i][j].clearCell();
                }
                availableCellList.add(cells[i][j]);
            }
        }
        int size = GameConfig.MAX_SHIP_SIZE;
        for (int count = 0; count < GameConfig.SHIPS_TYPES; ++count, --size) {
            for (int i = 0; i <= count; ++i) {
                arrangeShip(new Ship(size));
            }
        }
    }

    private void arrangeShip(Ship ship) {
        int shipSize = ship.getShipSize();
        Cell cell = availableCellList.get((int) (Math.random() * availableCellList.size()));
        if (shipSize > 1) {
            List<List<Cell>> positionList = new ArrayList<>(shipSize * 2);
            List<Cell> currentPositionList;
            nextPositionHorizontal:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getRow() - i + j < cells.length && cell.getRow() - i + j >= 0
                            && availableCellList.contains(cells[cell.getRow() - i + j][cell.getCol()])) {
                        currentPositionList.add(cells[cell.getRow() - i + j][cell.getCol()]);
                    } else {
                        continue nextPositionHorizontal;
                    }
                }
                positionList.add(currentPositionList);
            }
            nextPositionVertical:
            for (int i = 0; i < shipSize; ++i) {
                currentPositionList = new ArrayList<>(shipSize);
                for (int j = 0; j < shipSize; ++j) {
                    if (cell.getCol() - i + j < cells[0].length && cell.getCol() - i + j >= 0
                            && availableCellList.contains(cells[cell.getRow()][cell.getCol() - i + j])) {
                        currentPositionList.add(cells[cell.getRow()][cell.getCol() - i + j]);
                    } else {
                        continue nextPositionVertical;
                    }
                }
                positionList.add(currentPositionList);
            }
            currentPositionList = positionList.get((int) (Math.random() * positionList.size()));
            for (Cell currCell : currentPositionList) {
                currCell.setPartOfShip(true);
                ship.getCellList().add(currCell);
            }
        } else if (shipSize == 1) {
            cell.setPartOfShip(true);
            ship.getCellList().add(cell);
        }
        availableCellList.removeAll(ship.getCellList());
        setShipShadow(ship);
        shipList.add(ship);
    }

    private void setShipShadow(Ship ship) {
        boolean isExistMinRow = ship.getMinShipRow() > 0;
        boolean isExistMaxRow = ship.getMaxShipRow() + 1 != cells.length;
        boolean isExistMinCol = ship.getMinShipCol() > 0;
        boolean isExistMaxCol = ship.getMaxShipCol() + 1 != cells[0].length;
        int minShadowRow = isExistMinRow ? ship.getMinShipRow() - 1 : ship.getMinShipRow();
        int maxShadowRow = isExistMaxRow ? ship.getMaxShipRow() + 1 : ship.getMaxShipRow();
        int minShadowCol = isExistMinCol ? ship.getMinShipCol() - 1 : ship.getMinShipCol();
        int maxShadowCol = isExistMaxCol ? ship.getMaxShipCol() + 1 : ship.getMaxShipCol();
        int verticalStartPos = isExistMinRow ? 1 : 0;
        int verticalLength = isExistMaxRow ? maxShadowRow - minShadowRow : maxShadowRow - minShadowRow + 1;
        int horLength = maxShadowCol - minShadowCol + 1;

        for (int i = 0; i < horLength; ++i) {
            if (isExistMinRow) {
                ship.getCellShadowList().add(cells[minShadowRow][minShadowCol + i]);
            }
            if (isExistMaxRow) {
                ship.getCellShadowList().add(cells[maxShadowRow][minShadowCol + i]);
            }
        }
        for (int i = verticalStartPos; i < verticalLength; ++i) {
            if (isExistMinCol) {
                ship.getCellShadowList().add(cells[minShadowRow + i][minShadowCol]);
            }
            if (isExistMaxCol) {
                ship.getCellShadowList().add(cells[minShadowRow + i][maxShadowCol]);
            }
        }
        availableCellList.removeAll(ship.getCellShadowList());
    }

    void reArrangeGameBoard() {
        availableCellList.clear();
        shipList.clear();
        makeRandomBoard();
    }

    boolean markShot(int row, int col) {
        if (cells[row][col].isShot()) {
            return false;
        }
        cells[row][col].setShot(true);
        if (cells[row][col].isPartOfShip()) {
            Ship currentShip = null;
            for (Ship ship : shipList) {
                if (ship.getCellList().contains(cells[row][col])) {
                    currentShip = ship;
                }
            }
            if (currentShip != null && !currentShip.isAlive()) {
                for (Cell shadowCell : currentShip.getCellShadowList()) {
                    shadowCell.setShot(true);
                }
                shipList.remove(currentShip);
            }
        }
        return true;
    }

    int getAliveShipsCount() {
        return shipList.size();
    }

    void showGameBoard() {
        for (int i = 0; i < GameConfig.BOARD_SIZE; ++i) {
            int rowNum = i + 1;
            if (rowNum != GameConfig.BOARD_SIZE) {
                System.out.print(rowNum + GameConfig.GAP);
            } else {
                System.out.print(rowNum + GameConfig.GAP.substring(0, 1));
            }
            for (int j = 0; j < GameConfig.BOARD_SIZE; ++j) {
                if (cells[i][j].isShot()) {
                    if (cells[i][j].isPartOfShip()) {
                        System.out.print(GameConfig.SHIP_SHOT_CELL + GameConfig.GAP);
                    } else {
                        System.out.print(GameConfig.MISS_SHOT_CELL + GameConfig.GAP);
                    }
                } else {
                    System.out.print(GameConfig.EMPTY_CELL + GameConfig.GAP);
                }
            }
            System.out.println();
        }
    }
}
