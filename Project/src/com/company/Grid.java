package com.company;


import org.jetbrains.annotations.NotNull;

public class Grid {

private int x;
private int y;
Column[] cols;

Grid(int x, int y) {
    this.x=x;
    this.y=y;
    this.cols=new Column[this.x];
}

void initializeGrid(@NotNull Grid G) {
    for (int i = 0; i <G.x ; i++) {
        G.cols[i]=new Column(G.y);
        G.cols[i].initializeColumn(G.y);
    }
}

void updateGrid(int nbCol,int status) {
    this.cols[nbCol].fillColumn(status);
}

}
