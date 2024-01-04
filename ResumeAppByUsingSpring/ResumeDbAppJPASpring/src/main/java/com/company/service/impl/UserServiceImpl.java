package com.company.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserRepository;
import com.company.entity.User;
import com.company.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userRepository.getAll(name, surname, nationalityId);
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean addUser(User u) {
        userRepository.save(u);
        return true;
    }

    private static final BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean updateUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        userRepository.save(u);
        return true;
    }

    @Override
    public boolean removeUser(int id) {
        userRepository.deleteById(id);
        return true;
    }

}
