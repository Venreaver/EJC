package tasks.task_03;

public class GameConfig {
    public static final int BOARD_SIZE = 10;
    public static final int SHIPS_TYPES = 4;
    public static final int MAX_SHIP_SIZE = 4;
    public static final int NOT_EXIST = -1;
    public static final int SHIPS_COUNT = 10;
    public static final int SHOT_ATTEMPTS = 60;

    public static final char EMPTY_CELL = '.';
    public static final char MISS_SHOT_CELL = 'o';
    public static final char SHIP_SHOT_CELL = '*';

    public static final String LETTERS = "ABCDEFGHIJ";
    public static final String GAP = "  ";
    public static final String GREETING = "Hello! This is BattleShip Game! Good Luck!";
    public static final String START_GAME = "Enter any key to start";
    public static final String LOSS = "Game Over. You lost this game. Better luck next time!";
    public static final String WIN = "You won! Congrats";
    public static final String GAME = "\n\n<<  ======================  BATTLESHIP GAME  ======================  >>";
    public static final String RESET_GAME = "Enter 1 to reset game";
    public static final String EXIT_GAME = "Enter 0 to exit";
    public static final String SHOOT = "Choose one of empty cells to shoot by entering combination (for example \"A4\")." +
            "\nShooting into non empty cell doesn't make sense";
    public static final String INFO = "INFORMATION:\n\".\" - empty cell  \"o\" - miss cell  \"*\" - hit cell";
    public static final String SHOTS = "Shots that you have: ";
    public static final String ALIVE_SHIPS = "Alive ships: ";
    public static final String DESTROYED_SHIPS = "Destroyed ships: ";
    public static final String END_CONSOLE = "==================================================";
    public static final String INVALID_INPUT = "Invalid input. Try again.";
    public static final String BYE = "Good Bye!";
    public static final String ERROR = "Error: ";
}
