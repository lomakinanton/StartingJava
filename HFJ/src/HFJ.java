
import java.util.Calendar;
import java.util.Date;

public class HFJ {
    
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1);
        
        
        System.out.println(String.format("%td, %<tB, %<tY", c));
        
    }
   
}
