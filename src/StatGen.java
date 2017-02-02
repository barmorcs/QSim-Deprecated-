
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author barmorec
 */
public class StatGen {

    public static void main(String[] arg) {

        try {

            Scanner s = new Scanner(new BufferedReader(new FileReader("src/inTeams/inWanderers.txt")));

            String teamName = s.next();
            String mascot = s.next();
            s.nextLine();
            String team = teamName + " " + mascot;

            PrintStream out = new PrintStream(new FileOutputStream("src/teams/BIQL/" + teamName + mascot + ".txt"));
            File file = new File("src/teams/BIQL/" + teamName + mascot + "Files.txt");

            PrintWriter teamFile = new PrintWriter(file);

            System.setOut(out);
            teamFile.println(team);
            System.out.println(team);

            while (s.hasNext()) {
                int reflex = 0;
                int speed = 0;
                int strength = 0;
                int sight = 0;
                int aim = 0;
                boolean fouls = false;
                int base = 20;
                int total = 0;
                int remaining = 0;
                boolean captain = false;

                teamFile.println();
                String player = s.nextLine();//player name
                String[] name = player.split("Name: ");
                player = name[1];

                teamFile.println(player);
                System.out.println(player);

                s.nextLine(); //skip team name

                String pos = s.nextLine();//player position
                teamFile.println(pos);
                String[] posti = pos.split("Position: ");
                pos = posti[1].toLowerCase();
                if (pos.toLowerCase().contains("captain")) {
                    captain = true;
                    base += 5;
                }
                pos = pos.substring(0, 6);
                //System.out.println(pos);

                String age = s.nextLine();//player age
                String[] age1 = age.split("Age: ");
                age = age1[1];
                int playerAge = Integer.parseInt(age);
                int agePoints;

                if (playerAge > 40) {
                    int take = (playerAge - 40);
                    take = take / 3;
                    agePoints = (playerAge / 2) - take;
                } else {
                    agePoints = playerAge / 2;
                }
                //System.out.println(agePoints);

                String years = s.nextLine();//player yot
                String[] yot = years.split("Years on Team: ");
                years = yot[1];
                int playerYOT = Integer.parseInt(years);
                int yotPoints = playerYOT / 2 + 1;
                //System.out.println(yotPoints);

                s.nextLine(); //skip alumni
                s.nextLine(); //skip reputation

                String style = s.nextLine();//playing style
                String[] ps = style.split("Playing style: ");
                String[] styleP = ps[1].split(", ");
                String style1 = styleP[0].toLowerCase();
                String style2 = styleP[1].toLowerCase();
                String style3 = styleP[2].toLowerCase();

                teamFile.println("Playing Style: " + style1 + ", " + style2 + ", " + style3);

                total = agePoints + base + yotPoints + 6;

                teamFile.println("Points: " + total);

                if (pos.contains("keeper")) {
                    reflex = 7;
                    speed = 4;
                    strength = 4;
                    sight = 6;
                    aim = 6;
                } else if (pos.contains("seeker")) {
                    reflex = 4;
                    speed = 6;
                    strength = 4;
                    sight = 7;
                    aim = 6;
                } else if (pos.contains("chaser")) {
                    reflex = 5;
                    speed = 4;
                    strength = 7;
                    sight = 5;
                    aim = 6;
                } else if (pos.contains("beater")) {
                    reflex = 5;
                    speed = 5;
                    strength = 6;
                    sight = 5;
                    aim = 6;
                }

                remaining = total - (reflex + speed + strength + sight + aim);
                //System.out.println(remaining);

                String[] traits = {"physical", "quick", "direct", "skillful", "cunning", "cautious", "confident", "creative", "aggressive", "fast", "organized", "selfish", "collaborative"};

                for (String x : traits) {
                    if (style1.contains(x) || style2.contains(x) || style3.contains(x)) {
                        if (x.contains("physical")) {
                            strength++;
                            speed++;
                            aim++;
                            sight--;
                            fouls = true;
                        }
                        if (x.contains("quick") || x.contains("fast")) {
                            speed++;
                            speed++;
                            speed++;
                            strength--;
                        }
                        if (x.contains("direct")) {
                            speed++;
                            aim++;
                        }
                        if (x.contains("skillful")) {
                            reflex++;
                            aim++;
                            strength++;
                            speed--;
                        }
                        if (x.contains("cunning")) {
                            aim++;
                            speed++;
                            reflex++;
                            strength--;
                            fouls = true;
                        }
                        if (x.contains("cautious")) {
                            reflex++;
                            sight++;
                            speed++;
                            strength--;
                        }
                        if (x.contains("confident")) {
                            strength++;
                            aim++;
                            fouls = true;
                        }
                        if (x.contains("creative")) {
                            reflex++;
                            aim++;
                        }
                        if (x.contains("aggressive")) {
                            strength++;
                            aim++;
                            reflex++;
                            speed--;
                            fouls = true;
                        }

                        if (x.contains("organized")) {
                            aim++;
                            sight++;
                            reflex++;
                            strength--;
                        }
                        if (x.contains("selfish")) {
                            speed++;
                            reflex++;
                            sight--;
                            fouls = true;
                        }
                        if (x.contains("collaborative")) {
                            sight++;
                            aim++;
                        }
                    }
                }

                if ((remaining / 5) > 0) {

                    while ((remaining / 5) > 0) {
                        reflex++;
                        speed++;
                        strength++;
                        sight++;
                        aim++;
                        remaining = remaining - 5;
                    }
                }

                if (remaining == 4) {

                    if (pos.contains("keeper")) {
                        aim++;

                    } else if (pos.contains("seeker")) {
                        sight++;

                    } else if (pos.contains("chaser")) {
                        aim++;

                    } else if (pos.contains("beater")) {
                        strength++;
                    }
                    remaining--;
                }

                if (remaining == 3) {
                    reflex++;
                    remaining--;
                }

                if (remaining == 2) {

                    if (pos.contains("keeper")) {
                        sight++;

                    } else if (pos.contains("seeker")) {
                        speed++;

                    } else if (pos.contains("chaser")) {
                        strength++;

                    } else if (pos.contains("beater")) {
                        aim++;
                    }
                    remaining--;
                }

                if (remaining == 1) {
                    if (pos.contains("keeper")) {
                        aim++;

                    } else if (pos.contains("seeker")) {
                        sight++;

                    } else if (pos.contains("chaser")) {
                        aim++;

                    } else if (pos.contains("beater")) {
                        strength++;
                    }
                    remaining--;
                }

                System.out.println(reflex);
                System.out.println(speed);
                System.out.println(strength);
                System.out.println(sight);
                System.out.println(aim);
                System.out.println(fouls);

                teamFile.println();
                teamFile.println("Reflex: " + reflex);
                teamFile.println("Speed: " + speed);
                teamFile.println("Strength: " + strength);
                teamFile.println("Sight: " + sight);
                teamFile.println("Aim: " + aim);
                if (fouls) {
                    teamFile.println("Fouls: yes");
                } else {
                    teamFile.println("Fouls: no");
                }
                teamFile.println();
                //end player
            }
            teamFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
