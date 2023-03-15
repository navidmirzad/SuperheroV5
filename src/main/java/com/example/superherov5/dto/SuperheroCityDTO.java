package com.example.superherov5.dto;

public class SuperheroCityDTO {

    private String superheroName;
    private String realName;
    private String city;

    public SuperheroCityDTO(String superheroName, String realName, String city) {
        this.superheroName = superheroName;
        this.realName = realName;
        this.city = city;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getCity() {
        return city;
    }
}
