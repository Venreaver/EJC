package tasks.task_02.racelogic;

import tasks.task_02.ducks.*;
import tasks.task_02.fly.FlyByJump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DuckRace {
    public static final int MAX_DUCK_SPEED = 100;
    public static final int MIN_DUCK_SPEED = 10;
    private static final int RACE_TIME = 10;
    private static final int DUCKS_COUNT = 5;
    private static final int BET_SUM = 100;

    private int playerBank;
    private int raceBank;
    private List<DuckRacer> raceGroupList;

    public DuckRace() {
        playerBank = 500;
        raceBank = 2000;
        raceGroupList = new ArrayList<>();
        for (int i = 0; i < DUCKS_COUNT; ++i) {
            raceGroupList.add(new DuckRacer());
        }
    }

    public void run() {
        info();
        makeChoice();
    }

    private void info() {
        System.out.println("********DUCK RACE INFORMATION********");
        System.out.println("Your current balance is " + playerBank);
        System.out.println("Choose something to start:");
        System.out.println("    * Enter number from 1 to 5 to choose duck in the race");
        System.out.println("    * Enter 9 to get information");
        System.out.println("    * Enter 0 to exit");
    }

    private void createDucks() {
        for (DuckRacer duckRacer : raceGroupList) {
            int number = (int) (Math.random() * DUCKS_COUNT);
            switch (number) {
                case 0:
                    duckRacer.setDuck(new MallardDuck());
                    break;
                case 1:
                    duckRacer.setDuck(new ModelDuck());
                    duckRacer.getDuck().setFlyBehavior(new FlyByJump());
                    break;
                case 2:
                    duckRacer.setDuck(new RedHeadDuck());
                    break;
                case 3:
                    duckRacer.setDuck(new RocketDuck());
                    break;
                default:
                    duckRacer.setDuck(new RubberDuck());
                    break;
            }
        }
    }

    private void makeChoice() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while ((playerBank > 0) && (raceBank > 0)) {
                try {
                    int choice = Integer.parseInt(reader.readLine().trim());
                    switch (choice) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            createDucks();
                            playerBank -= BET_SUM;
                            raceBank += BET_SUM;
                            System.out.println("You chose duck № " + choice);
                            startRace();
                            int maxDistance = findWinners();
                            System.out.println("The maximum flight distance in this race is " + maxDistance);
                            System.out.println("================================================");
                            System.out.println("Winners are: ");
                            String winOrLose = "You lost this race! Better luck next time";
                            for (int i = 0; i < DUCKS_COUNT; ++i) {
                                if (raceGroupList.get(i).isWinner()) {
                                    System.out.print("Duck № " + (i + 1) + " - ");
                                    raceGroupList.get(i).getDuck().display();
                                    if (choice == i + 1) {
                                        System.out.print(" - PLAYER'S CHOICE");
                                        raceBank -= BET_SUM * 2;
                                        playerBank += BET_SUM * 2;
                                        winOrLose = "You won this race! Congrats!";
                                    }
                                    System.out.println();
                                }
                            }
                            System.out.println(winOrLose);
                            System.out.println("================================================");
                            info();
                            break;
                        case 9:
                            info();
                            break;
                        case 0:
                            System.out.println("GOOD BYE!");
                            return;
                        default:
                            System.out.println("Invalid input. Try again. Enter 9 for information");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input. Try again. Enter 9 for information");
                }
            }
            if (playerBank == 0) {
                System.out.println("GAME OVER: you lost all your moneys");
            } else {
                System.out.println("You are total winner! We have no more money to play with you! Goodbye!");
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void startRace() {
        System.out.println("================================================");
        System.out.println("Race group is ready!");
        for (int i = 3; i > 0; --i) {
            System.out.println("Time to start: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        System.out.println("GO!");
        for (int i = 0; i < RACE_TIME; ++i) {
            System.out.print(i + 1 + " ");
            for (DuckRacer duckRacer : raceGroupList) {
                duckRacer.setDistance(duckRacer.getDistance() + duckRacer.getDuck().performFly());
            }
            try {
                Thread.sleep(950);
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        System.out.println("\nFINISH!");
        System.out.println("================================================");
    }

    private int findWinners() {
        int max = 0;
        for (DuckRacer duckRacer : raceGroupList) {
            max = max < duckRacer.getDistance() ? duckRacer.getDistance() : max;
        }
        for (DuckRacer duckRacer : raceGroupList) {
            duckRacer.setWinner(duckRacer.getDistance() == max);
        }
        return max;
    }
}
