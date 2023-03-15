package com.example.superherov5.dto;

import java.util.List;

public class SuperheroFormDTO {

    private int hero_id;
    private String superheroName;
    private String realName;
    private int discoveryYear;
    private int strength;
    private String city;
    List<String> powerList;

    public SuperheroFormDTO(int hero_id, String superheroName, String realName, int discoveryYear, int strength, String city, List<String>powerList) {
        this.hero_id = hero_id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.discoveryYear = discoveryYear;
        this.strength = strength;
        this.city = city;
        this.powerList = powerList;
    }

    public SuperheroFormDTO() {

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

    public int getStrength() {
        return strength;
    }

    public String getCity() {
        return city;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setDiscoveryYear(int discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPowerList(List<String> powerList) {
        this.powerList = powerList;
    }

    @Override
    public String toString() {
        return hero_id + " " + superheroName + " " + realName + " " + discoveryYear + " " + strength + " "
                + city + " " + powerList + " ";
    }
}
