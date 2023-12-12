package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.UserSkillDaoInter;
import entity.UserSkill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDao implements UserSkillDaoInter {

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        EntityManager entityManager = em();
        String jqpl = "Select us from UserSkill us where us.user.id=:userId";
        Query query = entityManager.createQuery(jqpl);
        query.setParameter("userId", userId);
        List<UserSkill> list = query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        entityManager.persist(us);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        entityManager.merge(us);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean removeUserSkill(int id) {
        EntityManager entityManager = em();
        UserSkill u = entityManager.find(UserSkill.class, id);
        entityManager.getTransaction().begin();
        try {
            entityManager.remove(u);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

}
