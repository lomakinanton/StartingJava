
/*
 * @author Anton
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Java23 {

    public static void main(String[] args) {
        new Java23().test6();
    }

    void test1() {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add("String");

    }

    private void test3() {
        LinkedList ll = new LinkedList();

        ll.add("1");
        ll.add("2");
        ll.add("3");
        ll.add("4");
        ll.add("5");
        ll.add("6");

    }

    private void test4() {
        Set<Cat> set = null;
        set = new HashSet<>();
        //set = new LinkedHashSet<>();
        //set = new TreeSet<>();

        Cat c = new Cat();
        Cat c2 = c;

        set.add(c);
        set.add(c2);

//        set.add("a1");
//
//        set.add("c9");
//        set.add("c9");
//        set.add("c9");
//        set.add("c9");
//
//        set.add("*/7qwerty");
//        set.add("*/7qwerty");
//        set.add("*/7qwerty");
//        set.add("*/7qwerty");
//
//        set.add("Kirill");
        System.out.println(set);
    }

    private void test5() {
        Map<String, Integer> m = null;
        m = new HashMap<>();
        //m = new TreeMap<>();
        //m = new LinkedHashMap<>();

        m.put("First", 1);
        m.put("Second", 2);

    }

    private void test6() {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Murka"));
        cats.add(new Cat("Murka"));
        cats.add(new Cat("Murka"));
        
        System.out.println(cats);
     }

}

class Cat {

    String name;

    public Cat() {
    }
    

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
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
        final Cat other = (Cat) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    

}
