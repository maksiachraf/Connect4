package com.company;

import java.io.PrintWriter;
import java.util.Random;
import java.io.*;
import com.company.*;
import com.elements.*;

public class AI implements Player {

    private int score;
    String name;
    int maxCol;


    AI(String name,int maxCol) {
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

    public int play(PrintWriter pw) {
        Random r= new Random();
        int s=r.nextInt(maxCol);
        s++;
        return s;
    }

}
