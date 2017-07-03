package task_03.logic;

import task_03.GameConfig;
import task_03.gameclasses.Cell;
import task_03.gameclasses.Ship;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private Cell[][] cells;
    private List<Cell> availableCellList;
    private List<Ship> shipList;

    public GameBoard() {
        cells = new Cell[GameConfig.BOARD_SIZE][GameConfig.BOARD_SIZE];
        availableCellList = new LinkedList<>();
        for (int i = 0; i < cells.length; ++i) {
            for (int j = 0; j < cells[i].length; ++j) {
                cells[i][j] = new Cell(i, j);
                availableCellList.add(cells[i][j]);
            }
        }
        shipList = new LinkedList<>();
    }

    private void makeRandomBoard() {
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

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.makeRandomBoard();
        for (int i = 0; i < gameBoard.cells.length; ++i) {
            for (int j = 0; j < gameBoard.cells[i].length; ++j) {
                if (gameBoard.cells[i][j].isPartOfShip()) {
                    System.out.print(1 + "  ");
                } else if (gameBoard.cells[i][j].isShot()) {
                    System.out.print("*" + "  ");
                } else {
                    System.out.print("~" + "  ");
                }
            }
            System.out.println();
        }
    }
}
