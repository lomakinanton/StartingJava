
import java.util.ArrayList;

class Team {

    private String name;
    private Member[] staff;
    private ArrayList<Member> winners;

    public void setWinners(ArrayList<Member> winners) {
        this.winners = winners;
    }

    public Team(String name, Member[] staff) {
        this.name = name;
        this.staff = staff;
    }

    public Member[] getStaff() {
        return staff;
    }

    void showResults() {
        for (Member m : winners) {
            System.out.println("Member with id:" + m.getId() + " win!");
        }
    }

    void showStaff() {
        for (Member m : staff) {
            System.out.println("Member with id:" + m.getId() + " in the " + name);
        }
    }
}