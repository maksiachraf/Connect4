package com.Interface;

import javax.swing.*;
import com.company.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static IciAction gameStart;
    int x;
    int y;
    private IciAction method;

    public Main(IciAction gameStart) {
        super("Connect_4");
        x = 0;
        y = 0;
        this.method = gameStart;
        build(gameStart);
    }

    private JPanel buildContentPanel(IciAction gameStart) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton bouton1 = new JButton(gameStart);
        panel.add(bouton1);

        return panel;
    }


    private JPanel showGameGrid() {
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout());
        return grid;
    }

    private void build(IciAction gameStart) {
        setTitle("Connect 4"); //On donne un titre à l'application
        setSize(320, 240); //On donne une taille à notre fenêtre
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(true); //On permet le redimensionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPanel(gameStart));
        setVisible(true);
    }

    public static void main(String[] args) {
        IciAction gameStart = new IciAction("Start Game");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main(gameStart);
                System.out.format("The sum of %d and %d . ", gameStart.getX(), gameStart.getY());
            }
        });


    }
}