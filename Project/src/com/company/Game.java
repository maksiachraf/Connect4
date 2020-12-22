
package com.company;

import com.company.*;
import java.io.*;
import java.io.PrintWriter;
import java.util.Random;
import java.io.*;
import com.elements.*;


public class Game {
    private int x;
    private int y;
    private int turn;
    private int rowToCheck;
    private int colToCheck;
    private Player p1;
    private Player p2;
    private Grid grid;
    private GridChecker gridChecker;
    private GridChecker counterGridChecker;
    private int next_turn;

public Game(int x,int y) {
    this.x=x;
    this.y=y;
   grid=new Grid(x,y);
   grid.initializeGrid();
   rowToCheck=0;
   colToCheck=0;
   gridChecker=new GridChecker(x,y);
   counterGridChecker=new GridChecker(y,x);
   gridChecker.translateGrid(grid);
   counterGridChecker.translateCounterGrid(grid);
   turn=1;
   next_turn=-1;

}

private void reInitializeGame() {
    grid.reInitializeGrid();
    rowToCheck=0;
    colToCheck=0;
    int a=turn;
    turn=next_turn;
    next_turn=a;
}


public int checkGrid(PrintWriter pw) {
    if(grid.gridFull()){
        showGrid();
        pw.println("Egalite");
        System.out.println("Egalite");
        reInitializeGame();
        return 1;
    }
    switch(turn) {
        case 1:
        if(gridChecker.checkGrid(rowToCheck,colToCheck)!=0 ||counterGridChecker.checkGrid(colToCheck,(this.x-1)-rowToCheck)!=0) {
            p1.wonRound();
            pw.println("Joueur 1 gagne");
            showGrid();
            System.out.println("Joueur 1 gagne");
            reInitializeGame();
            return 1;
        }
        turn=-1;
        return 0;

        case -1 :
            if(gridChecker.checkGrid(rowToCheck,colToCheck)!=0 ||counterGridChecker.checkGrid(colToCheck,(this.x-1)-rowToCheck)!=0) {
                p2.wonRound();
                pw.println("Joueur 2 gagne");
                showGrid();
                System.out.println("Joueur 2 gagne");
                reInitializeGame();
                return 1; }
            turn=1;
            return 0;
    }
    return 0;
}

public void setGamePlayerOne(int playerType,String name1) {

    switch(playerType) {
        case -1: p1=new AI(name1, y);
        break;
        case 1:  p1=new Human(name1,y);
        break;
    }

}
public void setGamePlayerTwo(int playerType,String name2) {
    switch(playerType) {
        case -1: p2=new AI(name2, y);
            break;
            case 1:  p2=new Human(name2,y);
             break;
        }

    }


public void playGame(PrintWriter pw) {

    int x=1;
    switch(turn) {
        case 1:
            do {
                int a = p1.play(pw);
                try {
                    if (a > y || a <= 0) throw new InvalidColumn();
                    if (grid.colFull(a-1)) throw new FullColumnException();
                    grid.updateGrid(a - 1, 1);
                    rowToCheck = grid.getLastOcc(a - 1) + 1;
                    colToCheck = a - 1;
                    x=2;
                    gridChecker.translateGrid(grid);
                    counterGridChecker.translateCounterGrid(grid);
                    return;
                }
                catch (FullColumnException fc) {
                    System.out.println("Erreur colonne pleine "+String.valueOf(a));
                    pw.println("Joueur 1 joue "+String.valueOf(a));
                    //pw.println("Erreur colonne pleine "+String.valueOf(a));
                }
                catch (InvalidColumn is) {
                    System.out.println("Erreur colonne non valide "+String.valueOf(a));
                    pw.println("Erreur colonne non valide " + String.valueOf(a));
                }
            } while(x==1);

        case -1:
            do {
                int b=p2.play(pw);
                try {
               if (b > y || b <= 0) throw new InvalidColumn();
               if (grid.colFull(b-1)) throw new FullColumnException();
               grid.updateGrid(b-1,-1);
               rowToCheck=grid.getLastOcc(b-1)+1;
               colToCheck=b-1;
               x=2;
               gridChecker.translateGrid(grid);
               counterGridChecker.translateCounterGrid(grid);
               return;
            }
                catch (FullColumnException fc) {
                    System.out.println("Erreur colonne pleine "+String.valueOf(b));
                    pw.println("Joueur 2 joue "+String.valueOf(b));
                    //pw.println("Erreur colonne pleine "+String.valueOf(a));
                }
                catch (InvalidColumn is) {
                    System.out.println("Erreur colonne non valide "+String.valueOf(b));
                    pw.println("Erreur colonne non valide " + String.valueOf(b));
                }
            } while(x==1);
    }
}

public void showGrid() {
    for (int j = 0; j < grid.getY(); j++) {
        System.out.print(String.valueOf(j+1) + " ");
    }
    System.out.println();
    for (int i = 0; i < grid.getX() ;i++) {
        for (int j = 0; j < grid.getY(); j++) {

            switch(grid.getSlot(j,i)) {
                case 1:
                    System.out.print("x ");
                    break;
                case -1:
                    System.out.print("o ");
                    break;
                case 0:
                    System.out.print(". ");
                    break;
            }
        }
        System.out.println();
    }
}

public int gameFinished() {
      if(p1.getScore()==2){
          return 1;
      }
      else if(p2.getScore()==2) {
          return -1;
      }
      else {
          return 0;
      }
    }

    public String getScore() {
    return "Score "+String.valueOf(p1.getScore())+ " - "+String.valueOf(p2.getScore());
    }

    public String serialization() {
     switch(turn){
         case 1 :
             return "Joueur 1 joue " + String.valueOf(colToCheck+1);
         case -1 :
             return "Joueur 2 joue " + String.valueOf(colToCheck+1);
     }
     return "";
    }
}

