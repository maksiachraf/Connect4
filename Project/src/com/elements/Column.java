package com.elements;

import com.company.*;



public class Column {
    private int lastOcc;
    private final int length;
    private Slot[] slots;

    Column(int length) {
        lastOcc=length-1;
        this.length=length;
        slots=new Slot[length];
    }

    int getSlot(int x) {
            return slots[x].getStatus();
}
    int getLastOcc() {
        return lastOcc;
    }

    void initializeColumn() {
        for (int i = 0; i < length; i++) {
            this.slots[i]=new Slot(0);
        }
    }
    void reInitializeColumn() {
        for (int i = 0; i < length; i++) {
            this.slots[i].setStatus(0);
            lastOcc=length-1;
        }
    }
    public Boolean colFull(){
        if(lastOcc<0){
            return true;
        }
        else {
            return false;
        }
    }
    void fillColumn(int status) {
        int curr_pos=lastOcc;
        slots[curr_pos].setStatus(status);
        lastOcc--;
    }

}
