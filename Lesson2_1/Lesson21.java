/*
��������: ������� �����
����: 21.09.2016
�������� �������: Java 2, lesson 1
*/
public class Lesson21 {

    public static void main(String[] args) {
        new Lesson21().start();
    }

    void start() {
        Member[] m1 = {new Member(10, 11),new Member(100, 12),new Member(75, 13),new Member(150, 14)};
        Member[] m2 = {new Member(85, 21),new Member(30, 22),new Member(45, 23),new Member(75, 24)};
        Course c = new Course(85); // ������� ������ �����������, int - ���������
        Team t1 = new Team("Team1", m1); // ������� ������ �������
        Team t2 = new Team("Team2", m2); // ������� ������ �������
        c.doIt(t1); // ������ ������ ������� ������ ������
        c.doIt(t2); // ������ ������ ������� ������ ������
        t1.showResults(); // ���������� ���������� ������ �������
        t2.showResults(); // ���������� ���������� ������ �������
        //t1.showStaff();
        //t2.showStaff();
    }
}