package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.UserSkillDaoInter;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception {
        int id = rs.getInt("user_skill_id");
        int skillId = rs.getInt("skill_id");
        String skillName = rs.getString("skill_name");
        int power = rs.getInt("power");
        int userId = rs.getInt("user_id");
        return new UserSkill(id, new Skill(skillId, skillName), new User(userId), power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("SELECT u.*, us.id as user_skill_id, us.skill_id, s.name as skill_name, us.power, us.user_id "
                    + "FROM user as u "
                    + "left join user_skill as us on us.user_id = u.id     "
                    + "left join skill as s on s.id = us.skill_id "
                    + "where u.id = ?");
            pstmt.setInt(1, userId);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                result.add(getUserSkill(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("insert into user_skill(user_id, skill_id, power) values (?,?,?)");
            pstmt.setInt(1, us.getUser().getId());
            pstmt.setInt(2, us.getSkill().getId());
            pstmt.setInt(3, us.getPower());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("update user_skill set skill_id = ?, power = ? where id = ?");
            pstmt.setInt(1, us.getSkill().getId());
            pstmt.setInt(2, us.getPower());
            pstmt.setInt(3, us.getId());
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(int id) {
        try (Connection c = connect()) {
            PreparedStatement pstmt = c.prepareStatement("delete from user_skill where id = ?");
            pstmt.setInt(1, id);
            pstmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
