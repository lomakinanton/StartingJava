
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
 * @author Anton Lomakin
 */
class Phonebook {

    private Set<PhonebookEntry> s = new HashSet<>();

    @Override
    public String toString() {
        String t = "";
        for (PhonebookEntry entry : s) {
            t = t + " " + entry.getLastName() + " tel:" + entry.getTel() + " email:" + entry.getEmail();
        }
        return t;
    }

    public Phonebook() {
    }

    ;

    void add(PhonebookEntry entry) {
        s.add(entry);
    }

    Set<String> getTelByLastName(String lastName) {
        Set<String> tel = new HashSet<>();
        int x = 0;
        for (PhonebookEntry entry : s) {
            if (entry.getLastName().equals(lastName)) {
                tel.add(entry.getTel());
            }
        }
        return tel;
    }
    
       Set<String> getEmailByLastName(String lastName) {
        Set<String> email = new HashSet<>();
        int x = 0;
        
        for (PhonebookEntry entry : s) {
            if (entry.getLastName().equals(lastName)) {
                email.add(entry.getEmail());
            }
        }
        return email;
    }

    /*private Map<String, String> lastNameTel = null;
    private Map<String, String> lastNameEmail = null;
    
    
    void add(String lastName, String tel, String Email) {
        lastNameTel.put(lastName, tel);
        lastNameEmail.put(lastName, Email);
    }*/
}
