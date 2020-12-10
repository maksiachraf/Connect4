package com.company;

public class GridChecker {
    private final int x;
    private final int y;
    private int[][] gridMatrix;

    GridChecker(int x, int y) {
     this.x=x;
     this.y=y;
     gridMatrix=new int[x][y];

    }
    public void translateGrid(Grid G) {
        for (int i = 0; i < this.x ;i++) {
            for (int j = 0; j < this.y; j++) {
                gridMatrix[i][j]=G.getSlot(i,j);
            }
        }
    }
    //public int checkLines(i)
    public int checkGrid(int checkValue) {
        for (int i = 0; i < this.y; i++) {
            int res = 0;
            int cnt=1;
            int[] val = new int[2];
            val[0]=0;
            val[1]=i;
            for (int j = 0; j <= i; j++) {
                if(cnt!=5) {
                    cnt++;
                    res = res + this.gridMatrix[j][i - j];
                    if(res == -4 ) {
                        return -1;
                    }
                    else if(res==4) {
                        return 1;
                    }
                }
                else {
                    cnt--;
                    res = res + this.gridMatrix[j][i - j]-this.gridMatrix[val[0]][val[1]];
                    val[0]++;
                    val[1]--;
                    if(res == -4 ) {
                        return -1;
                    }
                    else if(res==4) {
                        return 1;
                    }
                }

            }
        }
     return 0;
    }


}