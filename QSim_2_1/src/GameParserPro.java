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

public class GameParserPro {

    public static void main(String[] arg) throws IOException {

        HashMap<String, String> links = new HashMap<String, String>();

        links.put("Tutshill Tornados", "http://rpg.harrypotterhaven.net/index.php?topic=46358.0");
        links.put("Montrose Magpies", "http://rpg.harrypotterhaven.net/index.php?topic=46361.0");
        links.put("Wigtown Wanderers", "http://rpg.harrypotterhaven.net/index.php?topic=46363.0");
        links.put("Appleby Arrows", "http://rpg.harrypotterhaven.net/index.php?topic=46356.0");
        links.put("Chudley Cannons", "http://rpg.harrypotterhaven.net/index.php?topic=46242.0");
        links.put("Kenmare Kestrels", "http://rpg.harrypotterhaven.net/index.php?topic=46243.0");
        links.put("Falmouth Falcons", "http://rpg.harrypotterhaven.net/index.php?topic=46244.0");
        links.put("Wimbourne Wasps", "http://rpg.harrypotterhaven.net/index.php?topic=46359.0");
        links.put("Caerphilly Catapults", "http://rpg.harrypotterhaven.net/index.php?topic=46364.0");
        links.put("Ballycastle Bats", "http://rpg.harrypotterhaven.net/index.php?topic=46360.0");
        links.put("Puddlemere United", "http://rpg.harrypotterhaven.net/index.php?topic=46357.0");
        links.put("Pride of Portree", "http://rpg.harrypotterhaven.net/index.php?topic=46362.0");
        links.put("Holyhead Harpies", "http://rpg.harrypotterhaven.net/index.php?topic=46245.0");

        String openMain = "[center][size=12pt][b]MATCH TRANSCRIPT[/b][/size][/center][hr][center]";
        String openMainCont = "[center][size=12pt][b]MATCH TRANSCRIPT CONT[/b][/size][/center][hr][center]";

        String openTable = "[table][tr]";
        String openRow = "[td][size=9pt]";
        String closeRow = "[/size][/td]";
        String closeTable = "[/tr][/table][/center]";
        String spaces = "[td]   .   [/td]";
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Match Number: ");
            String matchNum = br.readLine();
            System.out.print("Results: ");
            String results = br.readLine();

            String[] res = results.split(", ");

            String[] teamUno = res[0].split(": ");
            String[] teamDos = res[1].split(": ");

            String team1 = teamUno[0];
            String team2 = teamDos[0];
            String team1score = teamUno[1];
            String team2score = teamDos[1];

            String date;

            switch (matchNum) {
                case "1":
                case "2":
                    date = "July 2049";
                    break;
                case "3":
                case "4":
                    date = "August 2049";
                    break;
                case "5":
                case "6":
                    date = "September 2049";
                    break;
                case "7":
                case "8":
                case "9":
                    date = "October 2049";
                    break;
                case "10":
                case "11":
                    date = "November 2049";
                    break;
                case "13":
                case "12":
                    date = "December 2049";
                    break;
                case "15":
                case "14":
                    date = "January 2050";
                    break;
                case "17":
                case "16":
                    date = "February 2050";
                    break;
                case "19":
                case "18":
                    date = "March 2050";
                    break;
                case "21":
                case "20":
                    date = "April 2050";
                    break;
                case "23":
                case "22":
                    date = "May 2050";
                    break;
                case "25":
                case "24":
                    date = "June 2050";
                    break;
                default:
                    date = "Invalid month";
                    break;
            }

            String team1link = links.get(team1);
            String team2link = links.get(team2);

            Scanner s = new Scanner(new BufferedReader(new FileReader("src/Results/GameData.txt")));
            PrintStream out = new PrintStream(new FileOutputStream("src/Results/GamePost.txt"));

            System.setOut(out);

            System.out.println("[center][size=15pt][b]MATCH " + matchNum);
            System.out.println();
            System.out.println("[url=" + team1link + "]" + team1 + "[/url] vs [url=" + team2link + "]" + team2 + "[/url][/b][/size]");
            System.out.println();
            System.out.println("[center][size=16pt][b]FINAL SCORE[/b]");
            System.out.println(team1 + ": " + team1score);
            System.out.println(team2 + ": " + team2score + "[/size]");
            System.out.println();
            System.out.println("[b]" + date + "[/b]");
            System.out.println();
            System.out.println();
            System.out.println("[hr]");
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(openMain);
            s.nextLine();
            //System.out.println(openTable);
            while (s.hasNext()) {
                //
                 System.out.println(openTable);

                for (int j = 0; j < 2; j++)//open table
                {

                    for (int k = 0; k < 1; k++) {//open table
                        System.out.println(openRow);
                        for (int i = 0; i < 60; i++) {
                            if (s.hasNext()) {
                                String line = s.nextLine();
                                if (line.contains("head to head") || line.contains("points") || line.contains("intercepted") || line.contains("failed to block") || line.contains("Snitch") || line.contains("Reverse") || line.contains(":") || line.contains("attempted to shoot a goal") || line.contains("attempted a goal") || line.contains("flew") || line.contains("called a foul") || line.contains("blocked") || line.contains("knocked") || line.contains("remaining") || line.contains("hit") || line.contains("scored") || line.contains("aimed") || line.contains("dodged") || line.contains("penalty")) {
                                    if (line.contains("HP")) {
                                        System.out.println("[color=red][b]" + line + "[/b][/color]");
                                    } else {
                                        System.out.println("[b]" + line + "[/b]");
                                    }

                                } else {
                                    System.out.println(line);
                                }

                            }
                            

                        }//end post
                        System.out.println(closeRow);
                            System.out.println(spaces);
                    }

                }
                                    System.out.println();
                        System.out.println();
                        System.out.println("[hr]");
                        System.out.println();
                        System.out.println();
                    //System.out.println(closeTable);

            }
            System.out.println(closeTable);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}//eof
