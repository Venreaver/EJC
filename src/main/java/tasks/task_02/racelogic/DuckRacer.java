package tasks.task_02.racelogic;

import tasks.task_02.ducks.DecoyDuck;
import tasks.task_02.ducks.Duck;

public class DuckRacer {
    private Duck duck;
    private int distance = 0;
    private boolean winner = false;

    public Duck getDuck() {
        if (duck == null) {
            duck = new DecoyDuck();
        }
        return duck;
    }

    public void setDuck(Duck duck) {
        this.duck = duck;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
