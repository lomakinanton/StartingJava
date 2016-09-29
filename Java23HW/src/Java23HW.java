
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * @author Anton Lomakin 
 */
public class Java23HW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Java23HW().task1();
    }

    private void task1() {
        String myString = "one one one two two three four four four four five five five five five five six six six six"; //20 слов       
        String[] words = myString.split(" ");
        Set<String> s = new LinkedHashSet<>(); //соблюдаем порядок
        Map<String, Integer> m = null;
        m = new LinkedHashMap<>();
        int i = 1;
        String currentWord = "";
        for (String word : words) {
            if (currentWord.equals(word)) {
                i++;
                m.put(word, i);
            } else {
                i = 1;
                currentWord = word;
                m.put(word, i);
            }
            s.add(word);
        }
        System.out.println("Words list:" + s);
        System.out.println("Words statistic:" + m);

    }

}
