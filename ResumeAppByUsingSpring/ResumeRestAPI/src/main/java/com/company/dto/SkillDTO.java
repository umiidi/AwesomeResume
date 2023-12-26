package com.company.dto;

import com.company.entity.Skill;

public class SkillDTO {

    int id;
    String name;

    public SkillDTO() {
    }

    public SkillDTO(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
    }

    public SkillDTO(int id, String name) {
        this.id = id;
        this.name = name;
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

}
