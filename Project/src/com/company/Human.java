package com.company;

import com.company.*;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import com.company.*;
import com.elements.*;

public class Human implements Player {
    int score;
    int maxCol;
    String name;
    int index;
    Scanner playerScanner=new Scanner(System.in);

     Human(String name,int maxCol) {
         this.name=name;
         this.maxCol=maxCol;
         score=0;
     }
     public void wonRound() {
         score++;
     }
    public int getScore() {
        return score;
    }
   // public int play(int nb_slots, UI ui) {
   public int play(PrintWriter pw) {
         //ui.getIntFro,User();
       int x=1;
       do {
           String str="";
           try{
               if(!playerScanner.hasNextInt()) {
                   str=playerScanner.next();
                   if(str.equals("sortir")) throw new ExitException();
                   else {
                   throw new InvalidInputException();}}
               int a=playerScanner.nextInt();
               x=2;
               return a;
           }
           catch (ExitException exit) {
               pw.close();
               System.exit(0);
           }
           catch (InvalidInputException im) {

               String err="Erreur saisie colonne " + str;
               if(!str.equals("sortir")) System.out.println(err);
           }



       } while(x==1);
       return 0;
    }

    //clqss ConleUI i,ple,ents ui


      //      (
        //            int getIntFro,User()
    //(



      //      )
        //    )

}
