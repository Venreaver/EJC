package tasks.task_02.racelogic;

import tasks.task_02.RaceConfig;
import tasks.task_02.ducks.*;
import tasks.task_02.fly.FlyByJump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DuckRace {
    private int playerBank;
    private int raceBank;
    private List<DuckRacer> raceGroupList;

    public DuckRace() {
        playerBank = 500;
        raceBank = 2000;
        raceGroupList = new ArrayList<>();
        for (int i = 0; i < RaceConfig.DUCKS_COUNT; ++i) {
            raceGroupList.add(new DuckRacer());
        }
    }

    public void run() {
        info();
        makeChoice();
    }

    private void info() {
        System.out.println(RaceConfig.INFO_LINE);
        System.out.println(RaceConfig.CURRENT_BALANCE + playerBank);
        System.out.println(RaceConfig.CHOOSE_LINE);
        System.out.println(RaceConfig.DUCK_NUM_CHOICE);
        System.out.println(RaceConfig.INFO_CHOICE);
        System.out.println(RaceConfig.EXIT_CHOICE);
    }

    private void createDucks() {
        for (DuckRacer duckRacer : raceGroupList) {
            int number = (int) (Math.random() * RaceConfig.DUCKS_COUNT);
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
                String choice = reader.readLine().trim();
                if (choice.matches("\\d")) {
                    int numChoice = Integer.parseInt(choice);
                    switch (numChoice) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            createDucks();
                            playerBank -= RaceConfig.BET_SUM;
                            raceBank += RaceConfig.BET_SUM;
                            System.out.println(RaceConfig.PLAYER_CHOICE + numChoice);
                            startRace();
                            int maxDistance = findWinners();
                            System.out.println(RaceConfig.MAX_RACE_DISTANCE + maxDistance);
                            System.out.println(RaceConfig.CONSOLE_LINE);
                            System.out.println(RaceConfig.WINNERS);
                            String winOrLose = RaceConfig.LOST_RACE;
                            for (int i = 0; i < RaceConfig.DUCKS_COUNT; ++i) {
                                if (raceGroupList.get(i).isWinner()) {
                                    System.out.print(RaceConfig.DUCK_NUM + (i + 1) + " - ");
                                    raceGroupList.get(i).getDuck().display();
                                    if (numChoice == i + 1) {
                                        System.out.print(RaceConfig.PLAYER_DUCK);
                                        raceBank -= RaceConfig.BET_SUM * 2;
                                        playerBank += RaceConfig.BET_SUM * 2;
                                        winOrLose = RaceConfig.RACE_WINNING;
                                    }
                                    System.out.println();
                                }
                            }
                            System.out.println(winOrLose);
                            System.out.println(RaceConfig.CONSOLE_LINE);
                            info();
                            break;
                        case 9:
                            info();
                            break;
                        case 0:
                            System.out.println(RaceConfig.BYE);
                            return;
                        default:
                            System.out.println(RaceConfig.INVALID_INPUT);
                            break;
                    }
                } else {
                    System.out.println(RaceConfig.INVALID_INPUT);
                }
            }
            if (playerBank == 0) {
                System.out.println(RaceConfig.GAME_OVER);
            } else {
                System.out.println(RaceConfig.GAME_WINNING);
            }
        } catch (IOException ex) {
            System.err.println(RaceConfig.ERROR + ex.getMessage());
        }
    }

    private void startRace() {
        System.out.println(RaceConfig.CONSOLE_LINE);
        System.out.println(RaceConfig.RACE_READY);
        for (int i = 3; i > 0; --i) {
            System.out.println(RaceConfig.TIME_TO_START + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println(RaceConfig.ERROR + ex.getMessage());
            }
        }
        System.out.println(RaceConfig.RACE_START);
        for (int i = 0; i < RaceConfig.RACE_TIME; ++i) {
            System.out.print(i + 1 + " ");
            for (DuckRacer duckRacer : raceGroupList) {
                duckRacer.setDistance(duckRacer.getDistance() + duckRacer.getDuck().performFly());
            }
            try {
                Thread.sleep(950);
            } catch (InterruptedException ex) {
                System.err.println(RaceConfig.ERROR + ex.getMessage());
            }
        }
        System.out.println(RaceConfig.RACE_FINISH);
        System.out.println(RaceConfig.CONSOLE_LINE);
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
