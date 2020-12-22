package com.company;

import java.lang.Math;
import com.company.*;
import com.elements.*;

public class GridChecker {
    private final int x;
    private final int y;
    public int[][] gridMatrix;


    GridChecker(int x, int y) {
     this.x=x;
     this.y=y;
     gridMatrix=new int[x][y];
    }

    public void translateGrid(Grid grid) {
        for (int i = 0; i < this.x ;i++) {
            for (int j = 0; j < this.y; j++) {
                gridMatrix[i][j]=grid.getSlot(j,i);
            }
        }
    }
    public void translateCounterGrid(Grid grid) {
        for (int i = 0; i < grid.getX() ;i++) {
            for (int j = 0; j < grid.getY(); j++) {
                gridMatrix[j][i]=grid.getSlot(j,(this.y-1)-i);
            }
        }
    }

    public int checkRow(int rowIndex,int colIndex) {
        int count=0;
        int pos1 = Math.max(4-(this.y-colIndex),0);
        int pos2=  Math.min(colIndex,3);

        for (int pos = pos1; pos <= pos2 ; pos++) {
            count = gridMatrix[rowIndex][colIndex - pos] + gridMatrix[rowIndex][colIndex - pos + 1] + gridMatrix[rowIndex][colIndex - pos + 2] + gridMatrix[rowIndex][colIndex - pos + 3];
            if (Math.abs(count)==4) {
                return 1;
            }
        }
        return 0;
    }

    public int checkDiag(int rowIndex, int colIndex) {
        int count=0;
        if((x-rowIndex) + (y-colIndex)<=4 || colIndex+rowIndex<=2 ) return 0;
        else {
            int pos1 = Math.max(Math.max(4-(rowIndex+1),4-(y-colIndex)),0);
            int pos2=  Math.min(Math.min(x-(rowIndex+1),colIndex),3);
          for (int pos = pos1; pos <= pos2; pos++) {
              count=gridMatrix[rowIndex+pos][colIndex-pos]+gridMatrix[rowIndex+pos-1][colIndex-pos+1]+gridMatrix[rowIndex+pos-2][colIndex-pos+2]+gridMatrix[rowIndex+pos-3][colIndex-pos+3];
              if (Math.abs(count)==4) {
                  return 1;
              }
          }
       }
        return 0;
    }

    public int checkGrid(int rowIndex,int colIndex) {
        return checkRow(rowIndex,colIndex)+checkDiag(rowIndex,colIndex);
    }



}