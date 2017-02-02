/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barmorec
 */
import java.util.*;

public class Keeper extends Player {

    public int saves, saveFails, savesAttempted;

    public Keeper() {

    }

    public boolean pass(Chaser passTo) {
        Random rnd = new Random();
        int roll1 = rnd.nextInt(10) + 1;

        int p1 = 11;
        int p2 = 24;
        int p3 = 27;

        if (this.pro == true) {
            p1 = 20;
            p2 = 32;
            p3 = 36;
        }

        int total1 = this.aim + this.strength + roll1;

        if (total1 > p3) {
            System.out.print(this.name + " flew up and passed with a Porskoff Ploy");
            return passTo.catchQuaffle();

        } else if (total1 > p2) {
            System.out.print(this.name + " threw a Reverse Pass");
            return passTo.catchQuaffle();
        }

        if (total1 > p1) {
            System.out.print(this.name + " passed the Quaffle");
            return passTo.catchQuaffle();

        } else {
            System.out.println(this.name + " dropped the pass");
            return false;

        }

    }

    public boolean blockGoal(int help) {

        int p1 = 21;
        int p2 = 32;
        int p3 = 34;

        if (this.pro == true) {
            p1 = 36;
            p2 = 44;
            p3 = 48;
        }
        int check = this.aim + this.reflex + this.sight;

        if (check == 0) {
            System.out.println(this.name + " is knocked out! Failed to block the goal");
            return false;
        }

        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;
        int total = check + roll + help;

        if (total > p3) {
            System.out.println(this.name + " blocked the goal with a Starfish and Stick!");
            addGoal(true);
            return true;

        } else if (total > p2) {
            System.out.println(this.name + " blocked the goal with a Double Eight Loop!");
            addGoal(true);
            return true;

        } else if (total > p1) {
            System.out.println(this.name + " blocked the goal!");
            addGoal(true);
            return true;

        } else {
            System.out.println(this.name + " failed to block the goal!");
            addGoal(false);
            return false;

        }

    }

    public boolean blockPenalty(int help) {

        int check = this.aim + this.reflex + this.sight;

        if (check == 0) {
            System.out.println(this.name + " is knocked out! Failed to block the penalty shot");
            return false;
        }

        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;
        int total = check + roll - help;

        int p1 = 27;

        if (this.pro == true) {
            p1 = 36;
        }

        if (total > p1) {
            System.out.println(this.name + " blocked the penalty shot!");
            addGoal(true);
            return true;

        } else {
            System.out.println(this.name + " failed to block the penalty shot!");
            addGoal(false);
            return false;

        }

    }

    public void addGoal(boolean save) {
        if (save == true) {
            saves++;
        } else {
            saveFails++;
        }
        savesAttempted++;
    }

    public void getGameStats() {
        System.out.print("Keeper " + name + ":");
        System.out.print(" Saves attempted: " + saveFails);
        System.out.print(". Saves made: " + saves);
        System.out.println(". Missed saves: " + saveFails + ".");

        System.out.print("Fouls attempted: " + this.foulsAttempted);
        System.out.print(". Fouls made: " + this.foulsMade);
        System.out.println(". Fouls missed: " + this.foulsMissed + ".");

        System.out.print("Penalties: " + this.penalty);
        System.out.println(". Health points remaining: " + this.hp + ".");

    }

}
