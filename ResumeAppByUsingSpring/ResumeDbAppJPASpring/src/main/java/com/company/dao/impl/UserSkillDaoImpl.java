package com.company.dao.impl;

import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.UserSkill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserSkillDaoImpl implements UserSkillDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        String jqpl = "Select us from UserSkill us where us.user.id=:userId";
        Query query = entityManager.createQuery(jqpl);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        entityManager.persist(us);
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        entityManager.merge(us);
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        UserSkill u = entityManager.find(UserSkill.class, id);
        entityManager.remove(u);
        return true;
    }

}
