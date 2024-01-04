package com.company.dao.custom;

import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        String jpql = "select u from User u where 1=1 ";
        if (name != null && !name.trim().isEmpty()) jpql += " and u.name = :name";
        if (surname != null && !surname.trim().isEmpty()) jpql += " and u.surname = surname";
        if (nationalityId != null) jpql += " and u.nationality.id = :nid";

        Query query = entityManager.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) query.setParameter("name", name);
        if (surname != null && !surname.trim().isEmpty()) query.setParameter("surname", surname);
        if (nationalityId != null) query.setParameter("nid", nationalityId);
        return query.getResultList();
    }

}
