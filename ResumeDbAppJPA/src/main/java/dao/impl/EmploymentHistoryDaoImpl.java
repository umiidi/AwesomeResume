package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.EmploymentHistoryDaoInter;
import entity.EmploymentHistory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDao implements EmploymentHistoryDaoInter {

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int userId) {
        EntityManager entityManager = em();
        String jqpl = "Select eh from EmploymentHistory eh where eh.user.id=:userId";
        Query query = entityManager.createQuery(jqpl);
        query.setParameter("userId", userId);
        List<EmploymentHistory> list = query.getResultList();
        entityManager.close();
        return list;
    }

}
