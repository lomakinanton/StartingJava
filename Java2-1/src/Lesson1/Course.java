package Lesson1;

import java.util.ArrayList;

public class Course {
    private int difficultyLevel;

    public Course(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    void doIt(Team t){
        ArrayList<Member> winners = new ArrayList<>();

        for (Member m:t.getStaff()){
            if (m.getSkillLevel()>=difficultyLevel){
                winners.add(m);
            }
        }
        t.setWinners(winners);
    }
}