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

public class Player {

    public int reflex, sight, aim, strength, speed, hp, foulsMade, foulsAttempted, foulsMissed, penalty;
    public String house, name, position, id;
    public boolean playsDirty, knockedOut, pro;

    public Player() {

    }

    public void setStats(int re, int sp, int str, int si, int a, String d, boolean fouls) {
        reflex = re;
        sight = si;
        aim = a;
        strength = str;
        speed = sp;
        hp = 15;
        id = d;
        foulsMade = 0;
        foulsAttempted = 0;
        foulsMissed = 0;
        playsDirty = fouls;
        penalty = 0;
        knockedOut = false;

    }

    public int getStatsTotal() {
        return reflex + sight + aim + strength + speed;
    }

    public boolean playsDirty() {
        return playsDirty;
    }

    public int getFouls() {
        return foulsAttempted;
    }

    public int getReflex() {
        return reflex;
    }

    public int getSight() {
        return sight;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAim() {
        return aim;
    }

    public int getStr() {
        return strength;
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setID(String n) {
        id = n;
    }

    public String getID() {
        return id;
    }

    public String getTeam() {
        String team = id.substring(0, 2);

        return team;
    }

    public int getHP() {
        return hp;
    }

    public void loseHP(int minus) {
        hp = (hp - minus);
        System.out.println(this.name + " lost " + minus + " HP, " + hp + " remaining");
    }

    public boolean avoidBludger() {
        Random rnd = new Random();
        int roll = rnd.nextInt(10) + 1;
        int chance = rnd.nextInt(10) + 1;

        int p1 = 13;
        int p2 = 26;
        int hit = roll + chance;

        if (this.pro == true) {
            p1 = 24;
            p2 = 37;
            hit = hit / 2 + 2;
        }

        int total = speed + reflex + roll;

        if (total > p2) {
            System.out.println(this.name + " dodged a Bludger with a Sloth Grip Roll");
            return true;

        } else if (total > p1) {
            System.out.println(this.name + " dodged a Bludger");
            return true;

        } else {

            if ((hp - (hit)) > 0) {
                hp = (hp - (hit));
                System.out.println(this.name + " was hit by a Bludger! Lost "
                        + hit + " HP, " + hp + " remaining");

                if (hp <= 2) {
                    reflex = reflex - 2;
                    sight = sight - 2;
                    aim = aim - 2;
                    strength = strength - 2;
                    speed = speed - 3;
                } else if (hp <= 5) {
                    reflex--;
                    sight--;
                    aim--;
                    strength--;
                    speed--;
                } else if (hp <= 8) {
                    strength--;
                    speed--;
                }

            } else if ((hp - (hit)) < 0) {

                System.out.println(this.name + " was knocked out by a Bludger!");
                reflex = 0;
                sight = 0;
                aim = 0;
                strength = 0;
                speed = 0;
                knockedOut = true;
            }
            return false;

        }
    }

    public boolean foul(Player fouled, String foulType)//returns true if foul is committed
    {
        Random rnd = new Random();
        int rollD = rnd.nextInt(10) + 1;
        int rollO = rnd.nextInt(10) + 1;
        int loseHealth = rnd.nextInt(3);
        boolean violentFoul = false;
        String outLineTrue = "";
        String outLineFalse = "";

        int totalD = this.aim + this.reflex + this.strength + rollD;
        int totalO = fouled.getAim() + fouled.getReflex() + fouled.getSight() + rollO;

        switch (foulType.toLowerCase()) {
            case "blag":
                outLineTrue = this.name + " grabbed " + fouled.getName() + "'s broomstick!";
                outLineFalse = this.name + " tried to grab " + fouled.getName() + "'s broomstick but missed";
                violentFoul = false;

            case "blurt":
                outLineTrue = this.name + " locked onto " + fouled.getName() + "'s broomstick!";
                outLineFalse = this.name + " tried to lock onto " + fouled.getName() + "'s broomstick but missed";
                violentFoul = false;

            case "blatch":
                outLineTrue = this.name + " collided into " + fouled.getName();
                outLineFalse = this.name + " tried to collide into " + fouled.getName() + " but missed";
                violentFoul = true;

            case "cobb":
                outLineTrue = this.name + " hit " + fouled.getName();
                outLineFalse = this.name + " tried to hit " + fouled.getName() + " but missed";
                violentFoul = true;

            case "stoog":
                outLineTrue = this.name + " knocked " + fouled.getName() + " out of the way";
                outLineFalse = this.name + " tried to knock " + fouled.getName() + " out of the way but missed";
                violentFoul = true;

        }

        int p1 = 20;

        if (this.pro == true) {
            p1 = 36;

        }

        if (totalO > p1) {
            if (totalO > totalD) {
                System.out.println(outLineTrue);
                addFoul(true);
                if (violentFoul && !(loseHealth == 0)) {
                    fouled.loseHP(loseHealth);
                }
                return true;

            } else {
                System.out.println(outLineFalse);
                addFoul(false);
                return false;
            }
        } else {
            return false;
        }

    }

    public void addFoul(boolean foul) {
        if (foul == true) {
            foulsMade++;
        } else {
            foulsMissed++;
        }
        foulsAttempted++;
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPenalty() {
        penalty++;
    }

    public int getPenalty() {
        return penalty;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void knockOut() {
        knockedOut = true;
    }

    public boolean isPro() {
        return pro;
    }

    public void setPro(boolean in) {
        pro = in;
        hp = 20;
    }

}//eof
