package com.company;

public class Column {
    private int lastOcc;
    private int length;
    Slot[] slots;

    Column(int length) {
        this.lastOcc=0;
        this.length=length;
        this.slots=new Slot[length];
    }

    void initializeColumn(int length) {
        this.length=length;
        for (int i = 0; i < length; i++) {
            this.slots[i]=new Slot(0);
        }
    }

    public void fillColumn(int status) {
        int curr_pos=this.lastOcc;
        this.slots[curr_pos].status=status;
        this.lastOcc++;
    }


}
