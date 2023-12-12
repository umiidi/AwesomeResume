package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.SkillDaoInter;
import entity.Skill;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {

    @Override
    public List<Skill> getAll() {
        EntityManager entityManager = em();
        String jqpl = "Select s from Skill s";
        Query query = entityManager.createQuery(jqpl);
        List<Skill> list =  query.getResultList();
        entityManager.close();
        return list;
    }

    @Override
    public boolean addSkill(Skill s) {
        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

}
