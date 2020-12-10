package com.company;


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

    public void updateGrid(int nbCol, int status) {
        cols[nbCol].fillColumn(status);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getSlot(int x, int y) {
        return cols[x].getSlot(y);
    }
}