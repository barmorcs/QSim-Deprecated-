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

public class Seeker extends Player {

    public int sightings, missedSightings, catchAttempts;
    public String caught = "did not catch the Snitch.";

    public Seeker() {

    }

    public boolean search() {

        if (this.isKnockedOut()) {
            return false;
        }

        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;
        int p1 = 15;

        if (this.pro == true) {
            p1 = 20;
        }

        int total = this.sight + roll;

        if (total > p1) {
            System.out.println(this.name + " has seen the Snitch!");
            sightings++;
            return true;
        } else {
            missedSightings++;
            return false;
        }

    }

    public boolean chase() {

        if (this.isKnockedOut()) {
            return false;
        }
        Random rnd = new Random();
        int roll = rnd.nextInt(5) + 1;

        int p1 = 8;

        if (this.pro == true) {
            p1 = 14;
        }

        int total = this.sight + roll;

        if (total > p1) {
            System.out.println(this.name + " has also seen the Snitch!");
            sightings++;
            return true;
        } else {
            return false;
        }

    }

    public boolean catchSnitch() {

        if (this.isKnockedOut()) {
            return false;
        }

        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;

        int p1 = 29;

        if (this.pro == true) {
            p1 = 39;
        }

        int total = this.sight + this.speed + this.aim + roll + roll;
        catchAttempts++;

        if (total > p1) {
            System.out.println(this.name + " caught the Snitch!");
            caught = "caught the Snitch.";
            return true;
        } else {
            System.out.println(this.name + " failed to catch the Snitch!");

            return false;
        }

    }

    public String headToHead(Seeker second) {

        Random rnd = new Random();
        int roll1 = rnd.nextInt(10) + 1;
        int roll2 = rnd.nextInt(10) + 1;
        int roll3 = rnd.nextInt(10) + 1;
        int roll4 = rnd.nextInt(10) + 1;

        int p1 = 55;
        int p2 = 28;

        if (this.pro == true) {
            p1 = 15;
            p2 = 39;
        }

        int total1 = this.sight + this.speed + this.aim + roll1 + roll2;
        int total2 = this.sight + this.speed + this.aim + roll3 + roll4;
        int total = total1 + total2;
        catchAttempts++;

        if (total > p1) {

            if (total1 > total2 || total1 > p2) {
                System.out.print(this.name + " caught the Snitch! ");
                caught = "caught the Snitch.";
                return this.getID();
            } else if (total1 < total2 || total2 > p2) {
                System.out.print(second.name + " caught the Snitch! ");
                second.caught = "caught the Snitch.";
                return second.getID();
            }

        } else {
            System.out.println("The Snitch has been lost!");

            return null;
        }
        return null;

    }

    public void getGameStats() {
        System.out.println("Seeker " + name + ": " + caught);
        System.out.print("Catches attempted: " + catchAttempts);

        System.out.print(". Snitch sightings: " + sightings);
        System.out.println(". Missed sightings: " + missedSightings + ".");
        System.out.print("Fouls attempted: " + this.foulsAttempted);
        System.out.print(". Fouls made: " + this.foulsMade);
        System.out.println(". Fouls missed: " + this.foulsMissed + ".");

        System.out.print("Penalties: " + this.penalty);
        System.out.println(". Health points remaining: " + this.hp + ".");

    }
}
