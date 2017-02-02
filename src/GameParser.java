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

public class GameParser {

    public static void main(String[] arg) throws IOException {

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
                    date = "November 2049";
                    break;
                case "2":
                    date = "November 2049";
                    break;
                case "3":
                    date = "February 2050";
                    break;
                case "4":
                    date = "March 2050";
                    break;
                case "5":
                case "6":
                    date = "May 2050";
                    break;
                default:
                    date = "Invalid month";
                    break;
            }

            Scanner s = new Scanner(new BufferedReader(new FileReader("src/Results/GameData.txt")));
            PrintStream out = new PrintStream(new FileOutputStream("src/Results/GamePost.txt"));

            System.setOut(out);

            System.out.println("[center][size=15pt][b]MATCH " + matchNum);
            System.out.println();
            System.out.println(team1 + " vs " + team2 + "[/b][/size]");
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
                                if (line.contains("points") || line.contains("intercepted") || line.contains("failed to block") || line.contains("Snitch") || line.contains("Reverse") || line.contains(":") || line.contains("attempted to shoot a goal") || line.contains("attempted a goal") || line.contains("flew") || line.contains("called a foul") || line.contains("blocked") || line.contains("knocked") || line.contains("remaining") || line.contains("hit") || line.contains("scored") || line.contains("aimed") || line.contains("dodged") || line.contains("penalty")) {
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
