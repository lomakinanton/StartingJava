package painting;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Form1 extends JFrame {

    public Form1() throws HeadlessException {

        setTitle("Painting window");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel label = new JLabel();
        label.setBackground(Color.red);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setText("0:0");
        
        
        
        Canvas c = new Canvas();
        c.setBackground(Color.BLUE);
        
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                label.setText(String.valueOf(e.getX())+":"+String.valueOf(e.getY()));
            }
        });
        
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        setVisible(true);
        //c.repaint();
        
    }
  }

class Canvas extends java.awt.Canvas{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2 = (Graphics2D) g;
       // g2.setStroke(new BasicStroke(10));
        g2.drawLine(0, 0, 500, 500);
        g2.setColor(Color.red);
        
    }
    
    
    
}
