package com.example.superherov5.dto;

import java.util.List;

public class SuperheroNamePowerDTO {

    private String superheroName;
    private String realName;
    private List<String> superpowers;

    public SuperheroNamePowerDTO(String superheroName, String realName, List<String> superpowers) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.superpowers = superpowers;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public List<String> getSuperpowers() {
        return superpowers;
    }
}
