
import javax.swing.JFrame;

/**
 * @author Anton
 */
public class LearningSwing extends JFrame{
    
    public LearningSwing() {
        setTitle("Test window");
        setBounds(100,100,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LearningSwing();
    }
    
}
