

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;

class Form1 extends JFrame {

    @Override
    public void paintAll(Graphics g) {

        super.paintAll(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(10));
        g.drawLine(x, y, x, y);
        System.out.println(x + " " + y);
    }

    int x;
    int y;

    public Form1() {
        setTitle("Painting window");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        add(new myCanvas());
        setVisible(true);
    }
}

class myCanvas extends Canvas {

    int x;
    int y;

    BufferedImage back;
    Graphics2D back_g2d;

    ArrayList<Dot> dots = new ArrayList<>();

    public myCanvas() {
        setSize(500, 500);
        back = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        back_g2d = (Graphics2D) back.getGraphics();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == 1) {
                    
                }
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int _x=e.getX();
                int _y=e.getY();
                
                dots.add(new Dot(_x, _y));
                               
                
                back_g2d.setPaint(Color.red);
                back_g2d.setStroke(new BasicStroke(5));
                back_g2d.drawLine(dots.get(dots.size()-1).x, dots.get(dots.size()-1).y, _x, _y);

                paint(getGraphics());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
//        for (Dot dot : dots) {
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setColor(Color.red);
//            g2.setStroke(new BasicStroke(10));
//            g2.drawLine(0, 0, 500, 500);
//        }

       g.drawImage(back, 0, 0, this);
    }

    private static class Dot {
        int x;
        int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
