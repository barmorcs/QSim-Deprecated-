/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author barmorec
 */
import java.io.*;
import java.util.*;
import java.util.HashMap;

/**
 *
 * @author barmorec
 */
public class Play extends Player {

    /**
     *
     */
    public static HashMap<String, Player> Players = new HashMap<String, Player>();

    /**
     *
     */
    public static HashMap<String, Chaser> Chasers = new HashMap<String, Chaser>();

    /**
     *
     */
    public static HashMap<String, Keeper> Keepers = new HashMap<String, Keeper>();

    /**
     *
     */
    public static HashMap<String, Seeker> Seekers = new HashMap<String, Seeker>();

    /**
     *
     */
    public static HashMap<String, Beater> Beaters = new HashMap<String, Beater>();

    static String team1 = "";
    static String team2 = "";

    public static String newhandle = null;

    /**
     *
     */
    public static int team1Score;

    /**
     *
     */
    public static int team2Score;

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        {
            Play game = new Play();

            Keeper T1K = new Keeper();
            Seeker T1S = new Seeker();
            Chaser T1C1 = new Chaser();
            Chaser T1C2 = new Chaser();
            Chaser T1C3 = new Chaser();
            Beater T1B1 = new Beater();
            Beater T1B2 = new Beater();

            Keeper T2K = new Keeper();
            Seeker T2S = new Seeker();
            Chaser T2C1 = new Chaser();
            Chaser T2C2 = new Chaser();
            Chaser T2C3 = new Chaser();
            Beater T2B1 = new Beater();
            Beater T2B2 = new Beater();

            Scanner s = null;
            Scanner c = null;

            Chaser newHandler = null;
            
            String inTeam1 = "src/teams/Gryffindor.txt";
            String inTeam2 = "src/teams/Slytherin.txt";

            try {
                s = new Scanner(new BufferedReader(new FileReader(inTeam1)));
                c = new Scanner(new BufferedReader(new FileReader(inTeam2)));
                boolean pro = false;
                if (inTeam1.contains("BIQL")){
                    pro = true;
                } 
                

                team1 = s.nextLine();

                T1K.setName(s.nextLine());
                T1K.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1K", s.nextBoolean());
                T1K.setPro(pro);
                Players.put("T1K", T1K);
                Keepers.put("T1K", T1K);
                s.nextLine();

                T1S.setName(s.nextLine());
                T1S.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1S", s.nextBoolean());
                T1S.setPro(pro);
                Players.put("T1S", T1S);
                Seekers.put("T1S", T1S);
                s.nextLine();

                T1C1.setName(s.nextLine());
                T1C1.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1C1", s.nextBoolean());
                T1C1.setPro(pro);
                Players.put("T1C1", T1C1);
                Chasers.put("T1C1", T1C1);
                s.nextLine();

                T1C2.setName(s.nextLine());
                T1C2.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1C2", s.nextBoolean());
                T1C2.setPro(pro);
                Players.put("T1C2", T1C2);
                Chasers.put("T1C2", T1C2);
                s.nextLine();

                T1C3.setName(s.nextLine());
                T1C3.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1C3", s.nextBoolean());
                T1C3.setPro(pro);
                Players.put("T1C3", T1C3);
                Chasers.put("T1C3", T1C3);
                s.nextLine();

                T1B1.setName(s.nextLine());
                T1B1.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1B1", s.nextBoolean());
                T1B1.setPro(pro);
                Players.put("T1B1", T1B1);
                Beaters.put("T1B1", T1B1);
                s.nextLine();

                T1B2.setName(s.nextLine());
                T1B2.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1B2", s.nextBoolean());
                T1B2.setPro(pro);
                Players.put("T1B2", T1B2);
                Beaters.put("T1B2", T1B2);

                //team 2
                team2 = c.nextLine();

                T2K.setName(c.nextLine());
                T2K.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2K", c.nextBoolean());
                T2K.setPro(pro);
                Players.put("T2K", T2K);
                Keepers.put("T2K", T2K);
                c.nextLine();

                T2S.setName(c.nextLine());
                T2S.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2S", c.nextBoolean());
                T2S.setPro(pro);
                Players.put("T2S", T2S);
                Seekers.put("T2S", T2S);
                c.nextLine();

                T2C1.setName(c.nextLine());
                T2C1.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2C1", c.nextBoolean());
                T2C1.setPro(pro);
                Players.put("T2C1", T2C1);
                Chasers.put("T2C1", T2C1);
                c.nextLine();

                T2C2.setName(c.nextLine());
                T2C2.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2C2", c.nextBoolean());
                T2C2.setPro(pro);
                Players.put("T2C2", T2C2);
                Chasers.put("T2C2", T2C2);
                c.nextLine();

                T2C3.setName(c.nextLine());
                T2C3.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2C3", c.nextBoolean());
                T2C3.setPro(pro);
                Players.put("T2C3", T2C3);
                Chasers.put("T2C3", T2C3);
                c.nextLine();

                T2B1.setName(c.nextLine());
                T2B1.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2B1", c.nextBoolean());
                T2B1.setPro(pro);
                Players.put("T2B1", T2B1);
                Beaters.put("T2B1", T2B1);
                c.nextLine();

                T2B2.setName(c.nextLine());
                T2B2.setStats(c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), c.nextInt(), "T2B2", c.nextBoolean());
                T2B2.setPro(pro);
                Players.put("T2B2", T2B2);
                Beaters.put("T2B2", T2B2);

            } finally {
                if (s != null) {
                    s.close();
                }
            }

            Chaser hasBall = Chasers.get(Play.getNextChaser());

            boolean snitchCaught = false;
            Player randomPlayer = null;
            Chaser randomChaser = null;
            Beater randomBeater = null;
            Seeker otherSeeker = null;
            int playCount = 0;
            Seeker chasing = null;
            int getCount = 0;
            int h2hCount = 0;
            boolean h2h = false;

            //game logic
            while (snitchCaught == false) {
                playCount++;
                Random rnd = new Random();

                //CHASERS OMG 
                int chaserChance = rnd.nextInt(5);
                if (chaserChance == 1 || chaserChance == 3) {

                    if (hasBall.catchQuaffle(1)) {
                        Play.chaserPlay(hasBall, 0);
                    }
                    if (newhandle == null) {
                        hasBall = Chasers.get(Play.getOtherTeamPlayer(hasBall.getID(), "chaser"));
                    } else {
                        hasBall = Chasers.get(newhandle);
                        newhandle = null;
                    }
                }

                //RANDOM BEATERS OMG
                int chance4 = rnd.nextInt(10);
                boolean defense = rnd.nextBoolean();

                if (chance4 == 1) {
                    Beater attacker = Beaters.get(Play.getBeater());
                    Beater defender = Beaters.get(Play.getOtherTeamPlayer(attacker.getID(), "beater"));
                    if (attacker.attack()) {
                        randomPlayer = Players.get(Play.getOtherPlayer(attacker.getTeam()));
                        System.out.println("at " + randomPlayer);

                        if (Players.get(randomPlayer.getID()) == Players.get(defender.getID())) {
                            randomPlayer.avoidBludger();
                        } else if (defender.save()) {
                            if (defender.defend() == false) {
                                randomPlayer.avoidBludger();
                            }
                        } else {
                            randomPlayer.avoidBludger();
                        }
                    }
                }

                //Beater fouls
                if (chance4 == 2) {
                    Beater attacker = Beaters.get(Play.getBeater());
                    if (attacker.playsDirty) {
                        Beater defender = Beaters.get(Play.getOtherTeamPlayer(attacker.getID(), "beater"));
                        if (attacker.attack()) {
                            randomPlayer = Players.get(Play.getOtherPlayer(attacker.getTeam()));
                            System.out.println("at " + randomPlayer);
                            if (Players.get(randomPlayer.getID()) == Players.get(defender.getID())) {
                                randomPlayer.avoidBludger();
                            } else if (defender.save()) {
                                if (defender.defend() == false) {
                                    randomPlayer.avoidBludger();
                                }
                            } else {
                                randomPlayer.avoidBludger();
                            }

                        }
                    }
                }

                //SEEKERS OMG
                Random randomno = new Random();
                int chance = randomno.nextInt(20);

                if (chance == 1 && chasing == null) {
                    Seeker lucky = Seekers.get(Play.getSeeker()); //someone sees snitch
                    if (lucky.search()) {
                        getCount = playCount + 6;
                        chasing = lucky;
                        otherSeeker = Seekers.get(getOtherTeamPlayer(chasing.getID(), "seeker"));

                    }

                }

                //Seekers go head to head
                int chance1 = randomno.nextInt(6);
                int foulChance = randomno.nextInt(6);

                if (chance1 == 1 && !(chasing == null) && !(otherSeeker == null) && !h2h && otherSeeker.chase()) {
                    //Set new catch preReqs
                    h2h = true;
                    h2hCount = playCount + 4;

                    //Seeker foul attempts from each Seeker
                    if (foulChance == 1 && chasing.playsDirty() && foulChance == 1 && chasing.foul(otherSeeker, "stoog")) {
                        if (referee(chasing, otherSeeker, 0)) {
                            chasing = null;
                            h2h = false;
                            getCount = 0;
                            h2hCount = 0;
                        }

                        otherSeeker = null;
                    } else if (foulChance == 2 && otherSeeker.playsDirty() && otherSeeker.foul(chasing, "blag")) {
                        if (referee(otherSeeker, chasing, 0)) {
                            chasing = null;
                            otherSeeker = null;
                            h2h = false;
                            getCount = 0;
                            h2hCount = 0;
                        }
                        chasing = null;
                    }
                }

                //TODO: Seeker special plays
                if (!(chasing == null) && h2hCount > 0 && h2hCount == playCount) {
                    System.out.println("Seekers go head to head!");

                    String success = chasing.headToHead(otherSeeker);
                    if (!(success == null)) {
                        snitchCaught = true;
                        Play.score(success, 150);
                        break;

                    }

                }

                //first Seeker gets interrupted and snitch is lost 
                if ((getCount == (playCount - 3)) && !(chasing == null) && Play.seekerInterrupt(chasing)) {
                    getCount = 0;
                    System.out.println(chasing.getName() + " has lost the Snitch");
                    chasing = null;
                    h2h = false;
                }
                //seeker tries to catch
                if (!(chasing == null) && !(getCount == 0) && getCount == playCount) {
                    if (!(Play.seekerInterrupt(chasing))) {

                        if (chasing.catchSnitch()) {
                            snitchCaught = true;
                            Play.score(chasing.getID(), 150);
                            break;
                        } else {
                            chasing = null;
                            getCount = 0;
                            h2h = false;
                        }
                    } else {

                        getCount = 0;
                        System.out.println(chasing.getName() + " has lost the Snitch");
                        chasing = null;
                        h2h = false;
                    }
                }

            }//while
/*
            if (team1Score > team2Score) {
                System.out.println(team1 + " wins!");
            } else if (team1Score < team2Score) {
                System.out.println(team2 + " wins!");
            } else if (team1Score == team2Score) {
                System.out.println("It's a tie!");
            }

            System.out.println("*********************");
            System.out.println();
            System.out.println();

            System.out.println("Game Stats: ");
            System.out.println();

            T1K.getGameStats();
            T1S.getGameStats();
            T1C1.getGameStats();
            T1C2.getGameStats();
            T1C3.getGameStats();
            T1B1.getGameStats();
            T1B2.getGameStats();
            System.out.println();

            T2K.getGameStats();
            T2S.getGameStats();
            T2C1.getGameStats();
            T2C2.getGameStats();
            T2C3.getGameStats();
            T2B1.getGameStats();
            T2B2.getGameStats();

            System.out.println("*********************");
            System.out.println();
             */
        }//end game
    }

    /**
     * Handles one knocked out Seeker
     *
     * @return random seeker on random team
     */
    public static String getSeeker() {
        Random rnd = new Random();
        boolean value = rnd.nextBoolean();
        String player = "";
        if (value) {
            player = "T2S";
            if (Seekers.get(player).isKnockedOut()) {
                player = "T1S";
            }
        } else {
            player = "T1S";
            if (Seekers.get(player).isKnockedOut()) {
                player = "T2S";
            }
        }

        return player;
    }

    /**
     * Handles if any 3 Beaters are knocked out
     *
     * @return random beater on random team
     */
    public static String getBeater() {
        Random rnd = new Random();
        boolean player = rnd.nextBoolean();
        boolean value = rnd.nextBoolean();
        String outTeam = "";
        String beater = "";
        if (value) {
            outTeam = "T2";
        } else {
            outTeam = "T1";
        }
        String position;

        if (player) {
            position = "B2";
            if (Beaters.get(outTeam + position).isKnockedOut()) {
                position = "B1";
            }
        } else {
            position = "B1";
            if (Beaters.get(outTeam + position).isKnockedOut()) {
                position = "B2";
            }
        }
        beater = (outTeam + position);

        if (Beaters.get(beater).isKnockedOut()) {
            beater = getOtherTeamPlayer(beater, "beater");
        }

        return beater;
    }

    /**
     * Handles if one beater is knocked out
     *
     * @param team
     * @return random beater on specified team
     */
    public static String getBeater(String team) {
        Random rnd = new Random();
        boolean player = rnd.nextBoolean();
        String position = "";
        String beater = "";

        if (player) {
            position = "B1";
            if (Beaters.get(team + position).isKnockedOut()) {
                position = "B2";
            }
        } else {
            position = "B2";
            if (Beaters.get(team + position).isKnockedOut()) {
                position = "B1";
            }
        }

        beater = team + position;

        return beater;
    }

    /**
     *
     * @param team
     * @return random chaser on specified team
     */
    public static String getChaser(String team) {
        Random rnd = new Random();
        int player = rnd.nextInt(3);
        player += 1;
        String position;
        String chaser = "";

        chaser = team + "C" + player;
        if (Chasers.get(chaser).isKnockedOut()) {
            player = rnd.nextInt(3) + 1;
            chaser = team + "C" + player;
        }
        //if (Chasers.get(chaser).isKnockedOut()) {
        //    chaser = Play.getChaser(team);
       // }
        return chaser;
    }

    /**
     * handles one knocked out Chaser
     *
     * @param in
     * @return next chaser on team
     */
    public static String getNextChaser(String in) {
        Random rnd = new Random();
        boolean player = rnd.nextBoolean();
        String position = "";
        String val = in;
        String team = val.substring(0, 2);

        switch (val.substring(2)) {
            case "C1":
                if (player) {
                    position = "C2";
                } else {
                    position = "C3";
                }
                break;

            case "C2":
                if (player) {
                    position = "C1";
                } else {
                    position = "C3";
                }
                break;

            case "C3":
                if (player) {
                    position = "C1";
                } else {
                    position = "C2";
                }
                break;

        }

        String chase = (team + position);

        if (Chasers.get(chase).isKnockedOut()) {
            chase = Play.getNextChaser(chase, in);
        }
        return chase;
    }

    /**
     * handles one knocked out Chaser
     *
     * @param in
     * @return next chaser on team
     */
    public static String getNextChaser(String in1, String inKn) {
        String position = "";
        String valKn = inKn;
        String team = valKn.substring(0, 2);
        String out = "";

        if (in1.endsWith("C1")) {
            if (inKn.endsWith("C2")) {
                out = "C3";
            } else {
                out = "C2";
            }

        }
        if (in1.endsWith("C2")) {
            if (inKn.endsWith("C3")) {
                out = "C1";
            } else {
                out = "C3";
            }

        }
        if (in1.endsWith("C3")) {
            if (inKn.endsWith("C1")) {
                out = "C2";
            } else {
                out = "C1";
            }

        }
        String outPlayer = team + out;

        if (Chasers.get(outPlayer).isKnockedOut()) {
            return in1;
        }

        return outPlayer;

    }

    /**
     * Handles one knocked out chaser
     *
     * @return random chaser on a random team
     */
    public static String getNextChaser() {
        Random rnd = new Random();
        int player = rnd.nextInt(3);
        player += 1;
        String position;
        boolean value = rnd.nextBoolean();
        String outTeam = "";
        String team = "";
        if (value) {
            outTeam = "T2";
        } else {
            outTeam = "T1";
        }

        String chaser = "";

        if (outTeam.startsWith("T1")) {
            team = team1;

        } else {
            team = team2;
        }

        chaser = outTeam + "C" + player;
        if (Chasers.get(chaser).isKnockedOut()) {
            String next = Play.getNextChaser(chaser);

            if (next.equals(chaser) && Chasers.get(next).isKnockedOut()) {
                System.out.println("All " + team + "Chasers are knocked out!");

                if (outTeam.equals("T1")) {
                    chaser = "T2" + "C" + player;
                } else {
                    chaser = "T1" + "C" + player;
                }
            }
        }

        return chaser;
    }

    /**
     * gets a player on the opposite team
     *
     * @param pID
     * @param position
     * @return
     */
    public static String getOtherTeamPlayer(String pID, String position) {
        String outTeam = null;
        String player = "";
        if (pID.startsWith("T1")) {
            outTeam = "T2";
        } else {
            outTeam = "T1";
        }

        switch (position.toLowerCase()) {
            case "seeker":
                player = outTeam + "S";
                break;
            case "keeper":
                player = outTeam + "K";
                break;
            case "chaser":
                player = getChaser(outTeam);
                break;
            case "beater":
                player = getBeater(outTeam);

        }
        return player;

    }

    /**
     *
     * @param team
     * @return random player on OTHER team
     */
    public static String getOtherPlayer(String team) {
        Random rnd = new Random();
        int player = rnd.nextInt(5);
        String position;
        String outTeam;
        if (team.startsWith("T1")) {
            outTeam = "T2";
        } else {
            outTeam = "T1";
        }

        switch (player) {
            case 1:
                position = "S";
                break;
            case 2:
                position = "B1";
                break;
            case 3:
                position = "B2";
                break;
            case 4:
                position = "C1";
                break;
            case 5:
                position = "C2";
                break;
            case 0:
                position = "C3";
                break;
            default:
                position = "C1";
                break;
        }
        String play = (outTeam + position);

        while (Players.get(play).isKnockedOut()) {
            play = Play.getOtherPlayer(team);
        }
        return play;
    }

    /**
     *
     * @param shooter is interrupted
     * @return true if goal interrupted
     */
    public static boolean goalInterrupt(Chaser shooter) {
        Keeper otherKeeper = Keepers.get(getOtherTeamPlayer(shooter.getID(), "keeper"));
        Chaser otherChaser = Chasers.get(getOtherTeamPlayer(shooter.getID(), "chaser"));
        Chaser teammate = Chasers.get(getNextChaser(shooter.getID()));

        Random rnd = new Random();
        int chance = rnd.nextInt(25);

        if (chance == 7)//opposing chaser interrupts goal
        {
            if (otherChaser.blockGoal(0)) {
                return true;
            }
        }

        if (chance == 4 || chance == 6)//other chase commits foul against shooter
        {
            if (otherChaser.playsDirty()) {

                int foulPicker = rnd.nextInt(3);
                String foul = "";
                switch (foulPicker) {
                    case 0:
                        foul = "cobb";
                        break;
                    case 1:
                        foul = "blag";
                        break;
                    case 2:
                        foul = "blatch";
                        break;
                    case 3:
                        foul = "blurt";
                        break;
                }
                if (otherChaser.foul(shooter, foul)) {
                    shooter.drop();
                    referee(otherChaser, shooter, 2);
                    return true;
                }
            }

        }

        return false;

    }

    /**
     *
     * @param keeper is interrupted
     * @return true if goal interrupted
     */
    public static boolean goalInterrupt(Keeper keep, Chaser shooter) {
        Random rnd = new Random();
        int chance = rnd.nextInt(13);

        if (chance == 1)//shooter's beater hits opposing Keeper
        {
            if (beaterInterrupt(keep.getID()))//beater interrupt successful, keeper is hit and shooter scores
            {
                return true;
            } else {
                return false;
            }
        }
        return false;

    }
    
    /**
     *
     * @param keeper is interrupted
     * @return true if goal interrupted
     */
    public static Player goalFoul(Keeper keep, Chaser shooter) {
        Chaser teammate = Chasers.get(getNextChaser(shooter.getID()));
        if (teammate.getID() == shooter.getID()){
            return null;
        }

        Random rnd = new Random();
        int chance = rnd.nextInt(13);
        if (chance == 3)//other chaser commits foul against Keeper
        {
            if (teammate.playsDirty()) {
                if (teammate.foul(keep, "stoog")) {
                    //referee(teammate, keep, 2);
                    return teammate;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param targ
     * @return true if beater interrupts
     */
    public static boolean beaterInterrupt(String targ) {

        Player target = Players.get(targ);
        Beater interrupter = Beaters.get(getOtherTeamPlayer(target.getID(), "beater"));
        Beater defender = Beaters.get(getBeater(target.getTeam()));

        Random rnd = new Random();
        boolean value = rnd.nextBoolean();
        if (defender.save())//option with a defender
        {
            if (interrupter.attack()) {

                System.out.println("at " + target);
                if (defender.defend() == false) {
                    return !target.avoidBludger();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else //option without a defender
         if (interrupter.attack()) {
                System.out.println("at " + target);
                return !target.avoidBludger();
            } else {
                return false;
            }

    }

    /**
     *
     * @param target
     * @return null if intercept was defended
     */
    public static String chaserInterrupt(String target) {
        Chaser defender = Chasers.get(target);
        Chaser attacker = Chasers.get(getOtherTeamPlayer(target, "chaser"));

        if (defender.defendIntercept(attacker)) {
            return null;
        } else {
            return (attacker.getID());
        }

    }

    //chaser interrupted
    /**
     *
     * @param target
     * @return true if play is interrupted
     */
    public static boolean playInterrupt(Chaser target) {
        Random rnd = new Random();
        int chance = rnd.nextInt(20);
        if (chance == 1 || chance == 7 || chance == 20)//chaser can be interrupted by a beater
        {
            if (beaterInterrupt(target.getID())) {
                target.drop();
                return true;
            } else {
                return false;
            }

        }
        if (chance == 2 || chance == 5 || chance == 6)//chaser can be interrupted by another chaser
        {
            String inter = chaserInterrupt(target.getID());
            if (inter == null) {
                return false;
            } else {
                newhandle = inter;
                return true;
            }
        }

        if (chance == 3)//other chaser commits foul against passer
        {
            Chaser attacker = Chasers.get(getOtherTeamPlayer(target.getID(), "chaser"));
            if (attacker.playsDirty) {

                int foulPicker = rnd.nextInt(3);
                String foul = "";
                switch (foulPicker) {
                    case 0:
                        foul = "cobb";
                        break;
                    case 1:
                        foul = "blag";
                        break;
                    case 2:
                        foul = "blatch";
                        break;
                    case 3:
                        foul = "blurt";
                        break;
                }
                if (attacker.foul(target, foul)) {
                    target.drop();
                    if (!(referee(attacker, target, 1))) {
                        newhandle = attacker.getID();
                    }
                    return true;
                } else {
                    return false;
                }
            }

        }

        if (chance == 4)//other beater commits foul against passer
        {
            Beater attacker = Beaters.get(getOtherTeamPlayer(target.getID(), "beater"));
            if (attacker.playsDirty) {

                int foulPicker = rnd.nextInt(3);
                String foul = "";
                switch (foulPicker) {
                    case 0:
                        foul = "cobb";
                        break;
                    case 1:
                        foul = "blag";
                        break;
                    case 2:
                        foul = "blatch";
                        break;
                    case 3:
                        foul = "blurt";
                        break;
                }
                if (attacker.foul(target, foul)) {
                    target.drop();
                    referee(attacker, target, 1);
                    return true;
                } else {
                    return false;
                }
            }

        }

        return false;
    }

    /**
     *
     * @param p1
     * @param passes
     * @return
     */
    public static boolean chaserPlay(Chaser p1, int passes) {
        Chaser p2 = Chasers.get(getNextChaser(p1.getID()));
        Keeper otherKeeper = Keepers.get(getOtherTeamPlayer(p1.getID(), "keeper"));

        if (p1.getID().equals(p2.getID())) {
            System.out.println("Other Chasers are knocked out!");
            if (!playInterrupt(p1)) {
                if (p1.shootGoal(otherKeeper)) {
                    System.out.println(p1.toString() + " scored a goal!");
                    score(p1.getTeam(), 10);
                } else {
                    return true;
                }
                return true;
            }
        }

        int pass = passes;
        if (pass < 2) {
            if (p1.pass(p2)) {
                if (playInterrupt(p2)) {
                    return true;
                }

                pass++;
                return chaserPlay(p2, pass);
            } else {
                return true;
            }
        } else if (p1.shootGoal(otherKeeper)) {
            System.out.println(p1.toString() + " scored a goal!");
            score(p1.getTeam(), 10);
        } else {
            return true;
        }
        return true;
    }

    /**
     *
     * @param player
     * @param num
     */
    public static void score(String player, int num) {
        if (player.startsWith("T1")) {
            team1Score += num;
            System.out.println(num + " points to " + team1 + "! ");

        } else {
            team2Score += num;
            System.out.println(num + " points to " + team2 + "! ");

        }
        System.out.println(team1 + ": " + team1Score + ", " + team2 + ": " + team2Score);

    }

    /**
     *
     * @param fouler
     * @param victim
     * @return
     */
    public static boolean referee(Player fouler, Player victim, int seen) {
        Random rnd = new Random();
        int chance = rnd.nextInt(5);
        chance = chance - seen;
        String id = victim.getID();
        Chaser shooter = null;
        String victimTeam = id.substring(0, 2);

        if (chance < 2) {
            System.out.println("Referee has called a foul on " + fouler.getName());
            fouler.addPenalty();
            if (id.endsWith("C1") || id.endsWith("C2") || id.endsWith("C3")) {
                shooter = Chasers.get(victim.getID());
            } else {
                shooter = Chasers.get(getChaser(victimTeam));
            }

            Keeper otherKeeper = Keepers.get(getOtherTeamPlayer(shooter.getID(), "keeper"));

            if (shooter.shootPenalty(otherKeeper)) {
                System.out.println(shooter.toString() + " scored a penalty goal!");
                score(shooter.getTeam(), 10);
            }
            return true;
        }
        return false;

    }

    /**
     *
     * @param target
     * @return true if seeker is interrupted
     */
    public static boolean seekerInterrupt(Seeker target) {
        Random rnd = new Random();
        int chance = rnd.nextInt(9);
        String getId = target.getID();
        Player fouler = null;

        Chaser chase = Chasers.get(getOtherTeamPlayer(getId, "chaser"));
        Beater beat = Beaters.get(getOtherTeamPlayer(getId, "beater"));
        Keeper keep = Keepers.get(getOtherTeamPlayer(getId, "keeper"));

        if (chance == 1 && beaterInterrupt(target.getID())) {
            return true;
        } else if (chance == 2 && chase.playsDirty()) {
            fouler = chase;
        } else if (chance == 3 && beat.playsDirty()) {
            fouler = beat;
        } else if (chance == 4 && keep.playsDirty()) {
            fouler = keep;
        }

        if (!(fouler == null)) {
            int foulPicker = rnd.nextInt(3);
            String foul = "";
            switch (foulPicker) {
                case 0:
                    foul = "cobb";
                    break;
                case 1:
                    foul = "blag";
                    break;
                case 2:
                    foul = "blatch";
                    break;
                case 3:
                    foul = "blurt";
                    break;
            }
            if (fouler.foul(target, foul)) {
                referee(fouler, target, 1);
                return true;
            }
        }

        return false;
    }

    /**
     *
     *
     * @return true if seeker is interrupted
     */
    public static int chasers() {

        return 3;

    }

}//eof
