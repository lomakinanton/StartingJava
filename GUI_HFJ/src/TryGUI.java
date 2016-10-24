
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TryGUI implements ActionListener {

    JFrame frame;
    MyDrawPanel md;
    int x;
    int y;

    public static void main(String[] args) {

        TryGUI t = new TryGUI();
        try {
            t.go();
        } catch (InterruptedException ex) {
            Logger.getLogger(TryGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void go() throws InterruptedException {
        frame = new JFrame();
       

       

        md = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       

        frame.getContentPane().add(md, BorderLayout.CENTER);

        frame.setBounds(50, 50, 300, 300);
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                frame.repaint();
                System.out.println(String.format("x = %s y = %s", x,y));
            }

           

        });

       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }

    class MyDrawPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color c1 = new Color(red, green, blue);
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color c2 = new Color(red, green, blue);

            Graphics2D g2d = (Graphics2D) g;
//            GradientPaint gp = new GradientPaint(70, 70, c1, 150, 150, c2);
//            g2d.setPaint(gp);
            g2d.setColor(c2);
            g2d.setStroke(new BasicStroke(5));
            g2d.drawLine(x, y, x, y);
            //Image image = new ImageIcon("D:\\Anton\\Desktop\\_iphone\\IMG_3849.jpg").getImage();

        }

    }
}
