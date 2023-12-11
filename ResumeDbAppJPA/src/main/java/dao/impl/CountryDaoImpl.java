package dao.impl;

import dao.inter.AbstractDao;
import dao.inter.CountryDaoInter;
import entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAll() {
        EntityManager em = em();
        String jqpl = "Select c from Country c";
        Query query = em.createQuery(jqpl);
        List<Country> list =  query.getResultList();
        em.close();
        return list;
    }

}
