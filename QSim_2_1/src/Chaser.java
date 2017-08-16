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

public class Chaser extends Keeper {

    public int goalsMade, goalsMissed, goalsAttempted;
    public int passesMade, passesMissed, passesAttempted;
    public int blocks, blocksMissed, blocksAttempted;
    public int intercepted, interceptedSaved, interceptsAttempted;

    Play game = new Play();
    int Seed = (int)System.nanoTime(); 
    Random rnd = new Random(Seed);

    public Chaser() {

    }

    public boolean catchQuaffle() {
        int roll = rnd.nextInt(10) + 1;

        int p1 = 14;
        if (this.pro == true) {
            p1 = 25;
        }

        int total = this.aim + this.reflex + this.sight + roll;

        if (this.knockedOut) {
            System.out.println(" but there was no one there!");
            addPass(false);
            return false;
        }

        if (total > p1) {
            System.out.println(" to " + this.name);
            addPass(true);
            return true;
        } else {
            System.out.println(" but " + this.name + " dropped it");
            addPass(false);
            return false;
        }

    }
    
        public boolean catchQuaffle(int help) {
        int roll = rnd.nextInt(10) + 1 + help;

        int p1 = 14;
        if (this.pro == true) {
            p1 = 25;
        }

        int total = this.aim + this.reflex + this.sight + roll;

        if (this.knockedOut) {
            System.out.println(" but there was no one there!");
            addPass(false);
            return false;
        }

        if (total > p1) {
            System.out.println(" to " + this.name);
            addPass(true);
            return true;
        } else {
            System.out.println(" but " + this.name + " dropped it");
            addPass(false);
            return false;
        }

    }


    public boolean catchQuaffle(boolean first) {
        int roll = rnd.nextInt(10) + 1;

        int p1 = 16;
        if (this.pro == true) {
            p1 = 24;
        }

        int total = this.aim + this.reflex + this.sight + roll;

        if (total > p1) {
            if (first) {
                System.out.println(this.name + " grabbed the Quaffle");
            }
            return true;
        } else {
            return false;
        }

    }

    public boolean defendIntercept(Chaser offense)//returns true if intercept is dodged
    {
        int rollD = rnd.nextInt(10) + 1;
        int rollO = rnd.nextInt(10) + 1;

        int p1 = 20;
        if (this.pro == true) {
            p1 = 32;
        }

        int totalD = this.aim + this.reflex + this.sight + rollD;
        int totalO = offense.getAim() + offense.getReflex() + offense.getSight() + rollO;

        if (totalO > p1) {
            if (totalO > totalD) {
                System.out.println(offense.getName() + " intercepted the Quaffle from " + this.name);
                addIntercept(true);
                return false;

            } else {
                System.out.println(this.name + " dodged an interception from " + offense.getName());
                addIntercept(false);
                return true;
            }
        } else {
            return true;
        }

    }

    public boolean shootGoal(Keeper keep) {
        int roll = rnd.nextInt(10) + 1;

        int p1 = 10;
        int p2 = 26;
        int p3 = 31;
        int d = 18;

        if (this.pro == true) {
            p1 = 22;
            p2 = 35;
            p3 = 39;
            d = 30;
        }

        int total = this.aim + this.strength + roll;
        int diff = total - d;

        if (total > p3) {
            System.out.println(this.name + " hit the Quaffle with their broom towards the goalpost");

        } else if (total > p2) {

            if (this.aim > this.strength) {
                System.out.println(this.name + " aimed a Dionysus Dive");
            } else {
                System.out.println(this.name + " aimed a Chelmondiston Charge");
            }

        } else if (total > p1) {
            System.out.println(this.name + " attempted to shoot a goal");

        } else {
            System.out.println(this.name + " attempted a goal and missed");
            addGoal(false);
            return false;

        }

        if (total > p1) {
            if (!Play.goalInterrupt(this)) { //chaser interrupt

                if (Play.goalInterrupt(keep, this)) { //keeper interrupt
                    if (keep.blockGoal(-5 - diff)) {
                        addGoal(false);
                        return false;
                    } else {
                        addGoal(true);
                        return true;
                    }
                } else {
                    Player what = Play.goalFoul(keep, this);
                    if (what != null) {
                        if (Play.referee(what, keep, 2)) {
                            return false;
                        } else if (keep.blockGoal(-5 - diff)) {
                            addGoal(false);
                            return false;
                        } else {
                            addGoal(true);
                            return true;
                        }
                    }

                }
                if (keep.blockGoal(0 - diff)) {
                    addGoal(false);
                    return false;
                } else {
                    addGoal(true);
                    return true;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean scoreGoal() {
        int roll = rnd.nextInt(10) + 1;

        int p1 = 12;

        if (this.pro == true) {
            p1 = 29;
        }

        int total = this.aim + this.strength + roll;

        if (total > p1) {
            System.out.println(this.name + " scored a goal!");
            addGoal(true);
            return true;
        } else {
            System.out.println(this.name + " attempted a goal and missed");
            addGoal(false);
            return false;

        }

    }

    public boolean shootPenalty(Keeper keep) {
        int roll = rnd.nextInt(10) + 1;

        int p1 = 10;

        if (this.pro == true) {
            p1 = 25;
        }
        int total = this.aim + this.strength + roll;

        if (total > p1) {
            System.out.println(this.name + " attempted to shoot a penalty shot");

        } else {
            System.out.println(this.name + " missed the penalty shot");
            addGoal(false);
            return false;

        }

        int diff = total - p1;
        if (total > p1) {
            if (!keep.blockPenalty(diff)) {
                addGoal(true);
                return true;
            } else {
                addGoal(false);
                return false;
            }
        } else {
            return false;
        }
    }

    public void drop() {
        System.out.println(this.name + " dropped the Quaffle");

    }

    @Override
    public void getGameStats() {
        System.out.print("Chaser " + name + ":");
        System.out.print(" Goals attempted: " + goalsAttempted);
        System.out.print(". Goals made: " + goalsMade);
        System.out.println(". Goals missed: " + goalsMissed + ".");

        System.out.print("Passes attempted: " + passesAttempted);
        System.out.print(". Passes made: " + passesMade);
        System.out.println(". Passes missed: " + passesMissed + ".");

        System.out.print("Times intercepted: " + intercepted);
        System.out.println(". Saved interceptions: " + interceptedSaved);

        System.out.print("Fouls attempted: " + this.foulsAttempted);
        System.out.print(". Fouls made: " + this.foulsMade);
        System.out.println(". Fouls missed: " + this.foulsMissed + ".");

        System.out.print("Penalties: " + this.penalty);
        System.out.println(". Health points remaining: " + this.hp + ".");

    }

    @Override
    public void addGoal(boolean made) {
        if (made == true) {
            goalsMade++;
        } else {
            goalsMissed++;
        }
        goalsAttempted++;
    }

    public void addPass(boolean made) {
        if (made == true) {
            passesMade++;
        } else {
            passesMissed++;
        }
        passesAttempted++;
    }

    public void addBlock(boolean made) {
        if (made == true) {
            blocks++;
        } else {
            blocksMissed++;
        }
        blocksAttempted++;
    }

    public void addIntercept(boolean made) {
        if (made == true) {
            intercepted++;
        } else {
            interceptedSaved++;
        }
        interceptsAttempted++;
    }

}
