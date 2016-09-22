package Lesson1;

/*
Выполнил: Ломакин Антон
Дата: 21.09.2016
Домашнее задание: Java 2, lesson 1
*/
public class Lesson1 {

    public static void main(String[] args) {
        new Lesson1().start();
    }

    void start() {
        Member[] m1 = {new Member(10, 11),new Member(100, 12),new Member(75, 13),new Member(150, 14)};
        Member[] m2 = {new Member(85, 21),new Member(30, 22),new Member(45, 23),new Member(75, 24)};
        Course c = new Course(85); // Создаем полосу препятствий, int - сложность
        Team t1 = new Team("Team1", m1); // Создаем первую команду
        Team t2 = new Team("Team2", m2); // Создаем вторую команду
        c.doIt(t1); // Просим первую команду пройти полосу
        c.doIt(t2); // Просим вторую команду пройти полосу
        t1.showResults(); // Показываем результаты первой команды
        t2.showResults(); // Показываем результаты второй команды
        //t1.showStaff();
        //t2.showStaff();
    }
}