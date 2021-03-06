package tasks.task_03.gamelogic;

import tasks.task_03.GameConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BattleShipGame represents simple console BattleShip game implementation
 * <p> In this version of game user have 60 shot attempts to kill all randomly arranged ships on game board
 *
 * @author Irina Vasileva
 */
public class BattleShipGame {
    private GameBoard gameBoard;
    private int shotAttempts = GameConfig.SHOT_ATTEMPTS;

    public BattleShipGame() {
        gameBoard = new GameBoard();
    }

    /**
     * Start game
     * <p>
     * <p>User can choose between: exit game, reset game, enter shot coordinates
     */
    public void startGame() {
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
                            int hit = gameBoard.markShot(row, col);
                            if (hit > -1) {
                                --shotAttempts;
                                if (gameBoard.getAliveShipsCount() == 0) {
                                    break nextPlayerChoice;
                                }
                                showMenu();
                                if (hit > 0) {
                                    System.out.println(GameConfig.HIT);
                                } else {
                                    System.out.println(GameConfig.MISS);
                                }
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

    /**
     * Show game information and menu
     */
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
        System.out.println(GameConfig.CONSOLE_LINE);
    }
}
