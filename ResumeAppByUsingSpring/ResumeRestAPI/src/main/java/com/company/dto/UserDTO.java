package com.company.dto;

import com.company.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;
    private List<UserSkillDTO> userSkill;


    public UserDTO() {
    }

    public UserDTO(User u) {
        this.id = u.getId();
        this.name = u.getName();
        this.surname = u.getSurname();
        this.phone = u.getPhone();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.userSkill = u.getUserSkillList() == null ? null : u.getUserSkillList().stream().map(UserSkillDTO::new).collect(Collectors.toList());
    }

    public UserDTO(int id, String name, String surname, String phone, String email, String password, List<UserSkillDTO> userSkill) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userSkill = userSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSkillDTO> getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(List<UserSkillDTO> userSkill) {
        this.userSkill = userSkill;
    }
}
