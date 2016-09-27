package conwaysgameoflife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class ConwaysGameOfLife {

    canvas canvasPanel;

    final public int LIFE_SIZE = 50;
    final int POINT_RADIUS = 10;
    final int FIELD_SIZE = (LIFE_SIZE + 1) * POINT_RADIUS - 3;
    final int BTN_PANEL_HEIGHT = 58;
    boolean[][] lifeGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];
    boolean[][] nextGeneration = new boolean[LIFE_SIZE][LIFE_SIZE];

    public static void main(String[] args) {
        new ConwaysGameOfLife().go();
    }

    void go() {
        JFrame frame = new JFrame();
        frame.setTitle("Conway's game of life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, FIELD_SIZE, FIELD_SIZE + BTN_PANEL_HEIGHT);
        frame.setResizable(false);

        JButton fillButton = new JButton("Fill");
        //fillButton.setPreferredSize(btnDimension);
        fillButton.setToolTipText("Fill randomly");
        fillButton.addActionListener(new FillButtonListener());

        JButton stepButton = new JButton("Step");
        stepButton.setToolTipText("Show next generation");
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processOfLife();
                canvasPanel.repaint();
            }
        });
        
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(fillButton);
        btnPanel.add(stepButton);
        canvasPanel = new canvas();
        canvasPanel.setBackground(Color.WHITE);

        frame.add(canvasPanel, BorderLayout.CENTER);
        frame.add(btnPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private class FillButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    lifeGeneration[x][y] = new Random().nextBoolean();
                }
            }
            canvasPanel.repaint();
        }
    }

    class canvas extends Canvas {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (int x = 0; x < LIFE_SIZE; x++) {
                for (int y = 0; y < LIFE_SIZE; y++) {
                    if (lifeGeneration[x][y]) {
                        g.fillOval(x * POINT_RADIUS, y * POINT_RADIUS, POINT_RADIUS, POINT_RADIUS);
                    }
                }
            }
        }

    }
    
    void processOfLife(){
        
    }

}
