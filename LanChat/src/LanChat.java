
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.awt.ScrollPaneWheelScroller;

/**
 * @author Anton Lomakin
 */
public class LanChat extends JFrame {

    public LanChat(String title) throws HeadlessException {
        setTitle(title);
        setBounds(100, 100, 640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();

        JTextArea ta = new JTextArea(); //поле основного чата
        
        
        ta.setBackground(Color.WHITE);
        ta.setEditable(false);

        JTextField sendTf = new JTextField(); //поле редактирования сообщения
        sendTf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10 && !sendTf.getText().equals("")) {
                    ta.append("\n");
                    ta.append(sendTf.getText());
                    sendTf.setText("");
                }
            }
        });

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sendTf.getText().equals("")) {
                    ta.append("\n");
                    ta.append(sendTf.getText());
                    sendTf.setText("");
                }
            }
        });

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(1, 2));
        p1.add(sendTf);
        p1.add(sendButton);

        add(ta, BorderLayout.CENTER);
        add(p1, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LanChat("Lan chat");
    }

}
