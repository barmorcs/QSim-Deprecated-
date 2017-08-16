
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author barmorec
 */
public class PlayerTest extends Play {
    
    
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
    

    public static void setup() throws FileNotFoundException {

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

        String inTeam1 = "src/teams/Slytherin.txt";
        String inTeam2 = "src/teams/Hufflepuff.txt";

        try {
            s = new Scanner(new BufferedReader(new FileReader(inTeam1)));
            c = new Scanner(new BufferedReader(new FileReader(inTeam2)));
            boolean pro = false;
            if (inTeam1.contains("BIQL")) {
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
            T1C1.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1C1", s.nextBoolean(), true);
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
            T1B1.setStats(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), "T1B1", s.nextBoolean(), true);
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
    }
    public static void testChaserPlay() throws FileNotFoundException{
    PlayerTest.setup();
    Play game = new Play();
    Chaser chaser = Chasers.get("T1C1");
    Play.chaserPlay(chaser, 1);   
    }
        public static void main(String[] args) throws IOException {
            testChaserPlay();
        }
}
