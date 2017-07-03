package task_03;

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
        System.out.println();
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
        System.out.println();
    }

    private void setShipShadow(Ship ship) {
        for (Cell cell: ship.getCellList()) {

        }
//        int maxShadowRow = ship.getMaxShipRow() + 1 != cells.length ? ship.getMaxShipRow() + 1 : ship.getMaxShipRow();
//        int minShadowRow = ship.getMinShipRow() > 0 ? ship.getMinShipRow() - 1 : ship.getMinShipRow();
//        int maxShadowCol = ship.getMaxShipCol() + 1 != cells[0].length ? ship.getMaxShipCol() + 1 : ship.getMaxShipCol();
//        int minShadowCol = ship.getMinShipCol() > 0 ? ship.getMinShipCol() - 1 : ship.getMinShipCol();
//        int horLength = maxShadowCol - minShadowCol + 1;
//        int verticalLength = maxShadowRow - minShadowRow;
//
//        if (minShadowRow < ship.getMinShipRow()) {
//            for (int i = 0; i < horLength; ++i) {
//                cells[minShadowRow][minShadowCol + i].setShot(true);
//                ship.getCellShadowList().add(cells[minShadowRow][minShadowCol + i]);
//            }
//        }
//        if (maxShadowRow > ship.getMaxShipRow()) {
//            for (int i = 0; i < horLength; ++i) {
//                cells[maxShadowRow][minShadowCol + i].setShot(true);
//                ship.getCellShadowList().add(cells[maxShadowRow][minShadowCol + i]);
//            }
//        }
//        if (minShadowCol > ship.getMinShipCol()) {
//            for (int i = 1; i < verticalLength; ++i) {
//                cells[minShadowRow + i][minShadowCol].setShot(true);
//                ship.getCellShadowList().add(cells[minShadowRow + i][minShadowCol]);
//            }
//        }
//        if (maxShadowCol > ship.getMaxShipCol()) {
//            for (int i = 1; i < verticalLength; ++i) {
//                cells[minShadowRow + i][maxShadowCol].setShot(true);
//                ship.getCellShadowList().add(cells[minShadowRow + i][maxShadowCol]);
//            }
//        }
        availableCellList.removeAll(ship.getCellShadowList());
    }

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.makeRandomBoard();
        for (int i = 0; i < gameBoard.cells.length; ++i) {
            for (int j = 0; j < gameBoard.cells[i].length; ++j) {
                if (gameBoard.cells[i][j].isPartOfShip()) {
                    System.out.print(1 + " ");
                } else if (gameBoard.cells[i][j].isShot()) {
                    System.out.print("X" + " ");
                } else {
                    System.out.print(0 + " ");
                }
//                boolean flag = false;
//                for (Ship ship : gameBoard.shipList) {
//                    if (ship.getCellList().contains(gameBoard.cells[i][j])) {
//                        System.out.print(1 + " ");
//                        flag = true;
//                    } else if (ship.getCellShadowList().contains(gameBoard.cells[i][j])) {
//                        flag = true;
//                        System.out.print("* ");
//                    }
//                }
//                if (!flag) {
//                    System.out.print(0 + " ");
//                }
            }
            System.out.println();
        }
    }
}
