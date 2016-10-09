
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Anton
 */
public class Java26 {

    public static void main(String[] args) {
        SimpleInternetConnection con = new SimpleInternetConnection();
        try {
            System.out.print(con.getPage("https://www.yandex.ru/"));
        } catch (IOException ex) {
            Logger.getLogger(Java26.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
