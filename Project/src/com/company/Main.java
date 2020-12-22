package com.company;

import java.io.*;

import java.util.Scanner;
import com.company.*;
import com.elements.*;

public class Main {


    public static void main(String[] args) throws IOException{

        FileWriter wr=new FileWriter("log.txt",false);
        PrintWriter pw=new PrintWriter(wr);

        Scanner scanner = new Scanner(System.in);


        /*System.out.print("Veuillez saisir le nombre de lignes : ");
        int a = scanner.nextInt();

        System.out.print("Veuillez saisir le nombre de colonnes : ");
        int b = scanner.nextInt();
      */

        Game game = new Game(6,7);

        int x=1;

        do {
            System.out.println("Joueur 1?");
            try {
                int p1;
                String playerType = scanner.next();
                switch (playerType) {
                    case "AI":
                        p1 = -1;
                        break;
                    case "humain":
                        p1 = 1;
                        break;
                    case "sortir":
                        throw new ExitException();
                    default:
                        throw new Exception();
                }
                String pseudo1 = scanner.next();
                game.setGamePlayerOne(p1, pseudo1);
                pw.println("Joueur 1 est "+playerType+" "+pseudo1);
                pw.flush();
                x=2;
            }
            catch(ExitException ee) {

                scanner.close();
                pw.close();
                System.exit(1);
            }catch (Exception e) {
                pw.println("Erreur saisie Joueur 1");
                System.out.println("Erreur saisie Joueur 1");
                scanner.nextLine();
            }

        } while(x==1);

        x=1;
        do {
            System.out.println("Joueur 2?");
            try {
                int p2=0;
                String playerType = scanner.next();
                switch (playerType) {
                    case "AI":
                        p2 = -1;
                        break;
                    case "humain":
                        p2 = 1;
                        break;
                    case "sortir" :
                        throw new ExitException();
                    default :
                        throw new Exception();
                }
                String pseudo2 = scanner.next();
                pw.println("Joueur 2 est "+playerType+" "+pseudo2);
                game.setGamePlayerTwo(p2, pseudo2);
                x=2;
            }
            catch(ExitException ee) {
                scanner.close();
                pw.close();
                System.exit(1);
            }
            catch (Exception e) {
                pw.println("Erreur saisie Joueur 2");
                System.out.println("Erreur saisie Joueur 2");
                scanner.nextLine();
            }
        } while(x==1);

        // Game deroulement
        while (game.gameFinished()==0) {
            pw.println("Manche commence");
            do  {
                game.showGrid();
                game.playGame(pw);
                pw.println(game.serialization());

            } while(game.checkGrid(pw)==0 );

            pw.println(game.getScore());
            }

        pw.println("Partie finie");
        pw.close();

    }

}

