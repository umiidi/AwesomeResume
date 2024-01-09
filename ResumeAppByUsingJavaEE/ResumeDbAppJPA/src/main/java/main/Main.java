package main;
import entity.UserSkill;

public class Main {
    public static void main(String[] args) {
        UserSkill us = Context.instanceUserSkillDao().getAllSkillByUserId(1).get(2);
        System.out.println(Context.instanceUserSkillDao().removeUserSkill(us.getId()));
    }
}