/*
    Выполнил: Ломакин Антон
    Дата: 12.09.2016
    В качестве параметров передаем названия текстовых файлов
    Поиск слова будет осуществляться в том, что получилось в результате склейки файлов.
    Если нужно в одном файле - значит нужно передавать один файл в параметрах.
    Строку поиска спросят во время выполнения программы
*/
import java.io.*;
import java.util.*;
class hw6lomakin {
    public static void main(String[] args) {
        //для начала склеим файлы, указанные в параметрах.
        //будем записывать в sb все, что прочитали
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<args.length; i++) {
            try (BufferedInputStream r = new BufferedInputStream(new FileInputStream(args[i]))) {
                int x;
                do    {
                    x = r.read();
                    if (x > 0) sb.append((char) x);
                }
                while(x != -1);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            //перевод строки между файлами
            sb.append("\n");
        }
        //вывод результата склейки
        System.out.println(sb);
        //далее начинается поиск слова в файле
        System.out.println("Enter word:");
        String word = sc.nextLine();
        //хорошо что есть метод indexOf() - иначе бы пришлось перебирать все буквы в цикле
        int index = sb.indexOf(word);
        if (index > 0) System.out.println("The first symbol of the word has a number: " + (index+1));
        else System.out.println("The word is not found!");
        
        /*Далее сериализация. Как я понял, смысл этого явления в том,
            чтобы сохранить объект, а затем прочитать его. Объект уже есть - это StringBuilder sb,
            его и запишем. Но его оказалось мало чтобы раскрыть суть, поэтому еще класс кота добавил.
        */
        //Запись
        try {
            FileOutputStream fos = new FileOutputStream("mytext.ser");    //этот поток записывает байты в файлы
            ObjectOutputStream oos = new ObjectOutputStream(fos);         //этот поток записывает объекты в байты
            //а вместе это соединение потоков
            cat c = new cat("Kitty");
            oos.writeObject(sb);       //стринг билдер запывается без проблем
            oos.writeObject(c);        //а кот записывается только с implements Serializable
            oos.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //Чтение
        try {
            FileInputStream fis = new FileInputStream("mytext.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object one = ois.readObject();                            //соблюдаем порядок. Сначала стрингбилдер
            Object two = ois.readObject();                            //затем кот
            StringBuilder sb1 = (StringBuilder) one;
            cat c2 = (cat) two;
            System.out.println("deserialized text: "+sb1);            //вывод десериализованного стрингбилдера
            System.out.println("deserialized cats name: "+c2.name);   //вывод десериализованного кота. Они, кстати, не равны своим копиям выше - разные объекты.
            ois.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Сериализуемый класс Cat
class cat implements Serializable {
    String name;
    //Cпособность прыгать не сохранится, т.к. зависит от условий выполнения программы
    transient boolean canJump;
    cat(String name) {
        this.name = name;
    }
}