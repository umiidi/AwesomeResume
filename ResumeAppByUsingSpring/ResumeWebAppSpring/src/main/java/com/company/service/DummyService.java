package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void foo() {
        System.out.println("foo method");
    }

    @PreAuthorize("hasRole('ADMIN')")    // arxada ROLE_USER edir. Ona görə authority olaraq ROLE_USER olmalıdır...
    public void foo2() {
        System.out.println("foo2 method");
    }
}
