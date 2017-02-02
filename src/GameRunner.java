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

public class GameRunner extends Play{

   public static void main(String[] arg)
   {
      try { 
         //PrintStream out = new PrintStream(new FileOutputStream("Results/SampleGame2.txt"));
         //PrintStream summary = new PrintStream(new FileOutputStream("Results/GryffindorHufflepuffSummary.txt"));


         for (int i = 1; i<2; i++)
         {
            System.out.println("Game " + i);
            Play.main(new String[0]);
         }
      }
      catch (IOException e) {  
         e.printStackTrace();  
      }     
   }

}//eof
