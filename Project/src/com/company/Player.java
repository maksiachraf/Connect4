package com.company;

import java.io.PrintWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import com.company.*;
import com.elements.*;


public interface Player {

//public int play(int nbr_slots, UI ui);
public int play(PrintWriter pw);

public void wonRound();

public int getScore();

//interfqce Ui
  //      clqss ConsoleUI i,ple,ents UI


}
