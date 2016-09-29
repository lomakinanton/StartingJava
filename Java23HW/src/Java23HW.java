
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/*
 * @author Anton Lomakin 
 */
public class Java23HW {

    public static void main(String[] args) {
        Java23HW hw = new Java23HW();
        //hw.task1();
        hw.task2();
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
        System.out.println("Statistic:" + m);
    }

    void task2() {
        //Универсальная книга, можно добавлять любое количество телефонов и адресов.
        Phonebook pb = new Phonebook();
        PhonebookEntry entry1 = new PhonebookEntry("Lomakin", "+79080751271", "lomakin.antonio@yandex.ru");
        PhonebookEntry entry2 = new PhonebookEntry("Lomakin", "+79080751271", "lomakin.antonio@yandex.ru");
        PhonebookEntry entry3 = new PhonebookEntry("Lomakin", "+79080751272", "lomakin.antonio@yandex.ru");
        PhonebookEntry entry4 = new PhonebookEntry("Ivanov", "+79514480204", "Ivanov@yandex.ru");
        PhonebookEntry entry5 = new PhonebookEntry("Lomakin", "+79080751272", "lomakin.antonio@gmail.com");

        pb.add(entry1);
        pb.add(entry2);
        pb.add(entry3);
        pb.add(entry4);
        pb.add(entry5);

        System.out.println("Telephone(s):"+pb.getTelByLastName("Lomakin"));
        System.out.println("Email(s):"+pb.getEmailByLastName("Lomakin"));

        //System.out.println(pb.toString());
    }
}
