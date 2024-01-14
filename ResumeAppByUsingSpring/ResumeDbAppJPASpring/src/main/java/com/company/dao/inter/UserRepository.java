package com.company.dao.inter;

import com.company.dao.custom.UserCustomRepository;
import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserCustomRepository {

    @Query("select u from User u where u.name = :name")
    User findByName(@Param("name") String name);

    //  @Query(value = "select * from user where email = ?", nativeQuery = true)
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);

}
