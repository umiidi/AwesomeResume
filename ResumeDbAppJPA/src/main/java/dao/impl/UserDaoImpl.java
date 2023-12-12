package dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        EntityManager entityManager = em();

        String jpql = "select u from User u where 1=1 ";
        if (name != null && !name.trim().isEmpty()) jpql += " and u.name = :name";
        if (surname != null && !surname.trim().isEmpty()) jpql += " and u.surname = surname";
        if (nationalityId != null) jpql += " and u.nationality.id = :nid";

        Query query = entityManager.createQuery(jpql, User.class);
        if (name != null && !name.trim().isEmpty()) query.setParameter("name", name);
        if (surname != null && !surname.trim().isEmpty()) query.setParameter("surname", surname);
        if (nationalityId != null) query.setParameter("nid", nationalityId);
        List<User> list = query.getResultList();
        entityManager.close();
        return list;
    }

    private static final BCrypt.Hasher crypt = BCrypt.withDefaults();

    public boolean addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));

        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        EntityManager entityManager = em();
        entityManager.getTransaction().begin();
        entityManager.merge(u);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }

    @Override
    public User getById(int userId) {
        EntityManager entityManager = em();
        User u = entityManager.find(User.class, userId);
        entityManager.close();
        return u;
    }

    //  JPQL
//    @Override
//    public User getByEmail(String email) {
//        EntityManager entityManager = em();
//        Query query = entityManager.createQuery("select u from User u where u.email = :email", User.class);
//        query.setParameter("email", email);
//        List<User> userList = query.getResultList();
//        entityManager.close();
//        if (userList.size() == 1) {
//            return userList.get(0);
//        }
//        return null;
//    }

    //  Criteria Builder
//    @Override
//    public User getByEmail(String email) {
//        EntityManager entityManager = em();
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> userRoot = criteriaQuery.from(User.class);
//        criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(userRoot.get("email"), email));
//        Query query = entityManager.createQuery(criteriaQuery);
//        List<User> userList = query.getResultList();
//        entityManager.close();
//        if (userList.size() == 1) {
//            return userList.get(0);
//        }
//        return null;
//    }

    //  @NamedQuery
    @Override
    public User getByEmail(String email) {
        EntityManager entityManager = em();
        Query query = entityManager.createNamedQuery("User.findByEmail");
        query.setParameter("email", email);
        List<User> userList = query.getResultList();
        entityManager.close();
        if (userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    //  Native Query
//    @Override
//    public User getByEmail(String email) {
//        EntityManager entityManager = em();
//        Query query = entityManager.createNativeQuery("select * from user u where u.email = ?", User.class);
//        query.setParameter(1, email);
//        List<User> userList = query.getResultList();
//        entityManager.close();
//        if (userList.size() == 1) {
//            return userList.get(0);
//        }
//        return null;
//    }

    @Override
    public boolean removeUser(int id) {
        EntityManager entityManager = em();
        User u = entityManager.find(User.class, id);
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
