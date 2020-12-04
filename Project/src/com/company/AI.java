package com.company;

import java.util.Random;

public class AI implements Player {

    public int play(int nbr_slots) {
        Random r= new Random();
        int s=r.nextInt(nbr_slots);
        s++;
        return s;
    }

}
