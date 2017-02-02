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

public class Beater extends Player {

    public int hits, hitsMissed, hitsAttempted;
    public int blocks, blocksMissed, blocksAttempted;

    public Beater() {

    }

    public boolean defend() {
        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;

        int p1 = 26;

        if (this.pro == true) {
            p1 = 60;
        }

        int total = this.getStatsTotal() + roll;

        if (total > p1) {
            System.out.println(this.name + " blocked the Bludger");
            addBlock(true);
            return true;

        } else {
            System.out.println(this.name + " missed the Bludger");
            addBlock(false);
            return false;

        }

    }

    public boolean attack() {
        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;

        int p1 = 12;

        if (this.pro == true) {
            p1 = 28;
        }

        int total = this.strength + this.aim + roll;

        if (total > p1) {
            System.out.print(this.name + " hit a Bludger ");
            addHit(true);
            return true;

        } else {
            return false;

        }

    }
    
        public boolean save() {
        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;

        int p1 = 12;

        if (this.pro == true) {
            p1 = 28;
        }

        int total = this.sight + this.speed + roll;

        if (total > p1) {
            return true;
        } else {
            return false;

        }

    }

    public void addBlock(boolean made) {
        if (made == true) {
            blocks++;
        } else {
            blocksMissed++;
        }
        blocksAttempted++;
    }

    public void addHit(boolean made) {
        if (made == true) {
            hits++;
        } else {
            hitsMissed++;
        }
        hitsAttempted++;
    }

    public void getGameStats() {
        System.out.print("Beater " + name + ":");
        System.out.print(" Hits attempted: " + hitsAttempted);
        System.out.print(". Hits: " + hits);
        System.out.println(". Hits missed: " + hitsMissed + ".");

        System.out.print("Blocks attempted: " + blocksAttempted);
        System.out.print(". Blocks: " + blocks);
        System.out.println(". Blocks missed: " + blocksMissed + ".");
        System.out.print("Fouls attempted: " + this.foulsAttempted);
        System.out.print(". Fouls made: " + this.foulsMade);
        System.out.println(". Fouls missed: " + this.foulsMissed + ".");

        System.out.print("Penalties: " + this.penalty);
        System.out.println(". Health points remaining: " + this.hp + ".");

    }

}
