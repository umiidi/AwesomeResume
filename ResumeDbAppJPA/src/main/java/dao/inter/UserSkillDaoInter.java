package dao.inter;

import entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllSkillByUserId(int userId);

    boolean addUserSkill(UserSkill us);

    boolean updateUserSkill(UserSkill us);

    boolean removeUserSkill(int id);
}
