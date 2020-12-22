package com.elements;

import com.company.*;
import com.elements.*;

public class Grid {

    private final int x;
    private final int y;
    private Column[] cols;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        cols = new Column[y];
    }

    public void initializeGrid() {
        for (int i = 0; i < y; i++) {
            cols[i] = new Column(x);
            cols[i].initializeColumn();
        }
    }
    public Boolean colFull(int a) {
        return cols[a].colFull();
    }

    public Boolean gridFull() {
        Boolean value=true;
        for (int i = 0; i < y; i++) {
            value = value && cols[i].colFull();
        }
        return value;
    }

    public void reInitializeGrid() {
        for (int i = 0; i < y; i++) {
            cols[i].reInitializeColumn();
        }
    }

    public void updateGrid(int nbCol, int status) {
        cols[nbCol].fillColumn(status);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLastOcc(int y) {
        return cols[y].getLastOcc();
    }

    public int getSlot(int x, int y) {
        return cols[x].getSlot(y);
    }
}