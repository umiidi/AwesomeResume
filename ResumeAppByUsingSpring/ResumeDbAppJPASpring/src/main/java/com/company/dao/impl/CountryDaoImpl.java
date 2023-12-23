package com.company.dao.impl;

import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDaoInter {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Country> getAll() {
        String jqpl = "Select c from Country c";
        Query query = entityManager.createQuery(jqpl);
        return (List<Country>) query.getResultList();
    }

}
