package tasks.task_03.gamelogic;

import tasks.task_03.GameConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BattleShipGame {
    private GameBoard gameBoard;
    private int shotAttempts = GameConfig.SHOT_ATTEMPTS;

    public BattleShipGame() {
        gameBoard = new GameBoard();
        startGame();
    }

    private void startGame() {
        System.out.println(GameConfig.GREETING);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(GameConfig.START_GAME);
            reader.readLine();
            showMenu();
            nextPlayerChoice:
            while (shotAttempts > 0) {
                String playerChoice = reader.readLine().toUpperCase();
                switch (playerChoice) {
                    case "1":
                        gameBoard.reArrangeGameBoard();
                        shotAttempts = GameConfig.SHOT_ATTEMPTS;
                        showMenu();
                        break;
                    case "0":
                        System.out.println(GameConfig.BYE);
                        return;
                    default:
                        if (playerChoice.matches("[a-jA-J]([1-9]|10)")) {
                            int col = GameConfig.LETTERS.indexOf(playerChoice.charAt(0));
                            int row = Integer.parseInt(playerChoice.substring(1, playerChoice.length())) - 1;
                            if (gameBoard.markShot(row, col)) {
                                --shotAttempts;
                                if (gameBoard.getAliveShipsCount() == 0) {
                                    break nextPlayerChoice;
                                }
                                showMenu();
                                break;
                            }
                        }
                        System.out.println(GameConfig.INVALID_INPUT);
                        break;
                }
            }
            if (shotAttempts > 0) {
                System.out.println(GameConfig.WIN);
            } else {
                System.out.println(GameConfig.LOSS);
            }
        } catch (IOException e) {
            System.err.println(GameConfig.ERROR + e.getMessage());
        }
    }

    private void showMenu() {
        System.out.println(GameConfig.GAME);
        System.out.println(GameConfig.RESET_GAME);
        System.out.println(GameConfig.EXIT_GAME);
        System.out.println(GameConfig.SHOOT);
        System.out.println();
        System.out.print(GameConfig.GAP.charAt(0) + GameConfig.GAP);
        for (int i = 0, n = GameConfig.LETTERS.length(); i < n; ++i) {
            System.out.print(GameConfig.LETTERS.charAt(i) + GameConfig.GAP);
        }
        System.out.println();
        gameBoard.showGameBoard();
        System.out.println();
        System.out.println(GameConfig.INFO);
        System.out.print(GameConfig.ALIVE_SHIPS + gameBoard.getAliveShipsCount() + GameConfig.GAP);
        System.out.print(GameConfig.DESTROYED_SHIPS + (GameConfig.SHIPS_COUNT - gameBoard.getAliveShipsCount()) + GameConfig.GAP);
        System.out.println(GameConfig.SHOTS + shotAttempts);
        System.out.println(GameConfig.END_CONSOLE);
    }
}
