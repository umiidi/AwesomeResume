package com.company.service.inter;

import com.company.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll(String name, String surname, Integer nationalityId);

    User getById(int id);

    User getByEmail(String email);

    boolean addUser(User u);

    boolean updateUser(User u);

    boolean removeUser(int id);

}
