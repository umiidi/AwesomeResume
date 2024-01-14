package com.company.dto;

import com.company.entity.UserSkill;

public class UserSkillDTO {

    int id;
    int power;
    SkillDTO skill;

    public UserSkillDTO() {
    }

    public UserSkillDTO(UserSkill userSkill) {
        this.id = userSkill.getId();
        this.power = userSkill.getPower();
        this.skill = new SkillDTO(userSkill.getSkill());
    }

    public UserSkillDTO(int id, int power, SkillDTO skill) {
        this.id = id;
        this.power = power;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

}
