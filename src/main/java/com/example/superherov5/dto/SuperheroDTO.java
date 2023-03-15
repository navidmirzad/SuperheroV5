package com.example.superherov5.dto;

public class SuperheroDTO {

    private int hero_id;
    private String superheroName;
    private String realName;
    private int discoveryYear;
    private String isHuman;
    private int strength;
    private int city_id;

    public SuperheroDTO(int hero_id, String superheroName, String realName,
                        int discoveryYear, String isHuman, int strength, int city_id) {
        this.hero_id = hero_id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.discoveryYear = discoveryYear;
        this.isHuman = isHuman;
        this.strength = strength;
        this.city_id = city_id;
    }


    public int getHero_id() {
        return hero_id;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getDiscoveryYear() {
        return discoveryYear;
    }

    public String getIsHuman() {
        return isHuman;
    }

    public int getStrength() {
        return strength;
    }

    public int getCity_id() {
        return city_id;
    }
}
