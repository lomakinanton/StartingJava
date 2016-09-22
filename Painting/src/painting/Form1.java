package painting;

import java.awt.HeadlessException;
import javax.swing.JFrame;

class Form1 extends JFrame{

    public Form1() throws HeadlessException {
        setTitle("Painting window");
        setBounds(200,200,500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                
        
        setVisible(true);
    }

    
}
