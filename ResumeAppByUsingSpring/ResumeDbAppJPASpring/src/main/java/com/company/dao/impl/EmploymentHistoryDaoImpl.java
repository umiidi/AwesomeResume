package com.company.dao.impl;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        String jqpl = "Select eh from EmploymentHistory eh where eh.user.id=:userId";
        Query query = entityManager.createQuery(jqpl);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

}
