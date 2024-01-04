package com.company.dao.impl;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SkillDaoImpl implements SkillDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Skill> getAll() {
        String jqpl = "Select s from Skill s";
        Query query = entityManager.createQuery(jqpl);
        return query.getResultList();
    }

    @Override
    public boolean addSkill(Skill s) {
        entityManager.persist(s);
        return true;
    }

}
