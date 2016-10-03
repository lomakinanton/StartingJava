
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 * @author Anton Lomakin
 */
public class LanChat extends JFrame {

    public LanChat(String title) throws HeadlessException {
        setTitle(title);
        setBounds(100, 100, 640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        JTextField tf = new JTextField(); //поле основного чата
        tf.setBackground(Color.WHITE);
        tf.setEditable(false);
        
        JTextField sendTf = new JTextField();
        JButton sendButton = new JButton("Send");
        
        
        JPanel p1 = new JPanel();
        
        p1.setLayout(new GridLayout(1, 2));
        p1.add(sendTf);
        p1.add(sendButton);
        
        
        add(tf, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new LanChat("Lan chat");
    }

}
