package com.company.dao.custom;

import com.company.entity.User;

import java.util.List;

public interface UserCustomRepository {

    List<User> getAll(String name, String surname, Integer nationalityId);

}
