
import java.util.Objects;

/*
 * @author Anton Lomakin
 */
public class PhonebookEntry {

    private String lastName;
    private String tel;
    private String email;

    public PhonebookEntry() {
    }

    public PhonebookEntry(String lastName, String tel, String email) {
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///чтобы нельзя было сделать дубли
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.tel);
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhonebookEntry other = (PhonebookEntry) obj;
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
}
