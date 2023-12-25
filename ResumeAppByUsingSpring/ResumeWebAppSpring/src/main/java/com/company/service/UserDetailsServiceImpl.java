package com.company.service;

import com.company.dao.inter.UserRepository;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            UserBuilder userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.disabled(false);
            userBuilder.password(user.getPassword());

            String[] authorities = new String[]{"ADMIN", "USER", "ROLE_USER"};
            userBuilder.authorities(authorities);

            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }

}
