package dao.inter;

import entity.Skill;

import java.util.List;

public interface SkillDaoInter {

    List<Skill> getAll();

    boolean addSkill(Skill s);

}
