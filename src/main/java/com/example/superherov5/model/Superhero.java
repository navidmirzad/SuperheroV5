package com.example.superherov5.model;

public class Superhero {

    private int hero_id;
    private String superheroName;
    private String realName;
    private String superPowers;
    private int discoveryYear;
    private String isHuman;      // TODO: make boolean
    private int strength;
    private String city;

    public Superhero(int hero_id, String superheroName, String realName, int discoveryYear, String isHuman, int strength) {
        this.hero_id = hero_id;
        this.superheroName = superheroName;
        this.realName = realName;
        this.discoveryYear = discoveryYear;
        this.isHuman = isHuman;
        this.strength = strength;
    }

    public Superhero() {

    }


    public String getSuperheroName() {
        return superheroName;
    }

    public String getSuperPowers() {
        return superPowers;
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

    public double getStrength() {
        return strength;
    }


    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setSuperPowers(String superPowers) {
        this.superPowers = superPowers;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setDiscoveryYear(int yearCreated) {
        this.discoveryYear = yearCreated;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String toString() {
        return "\n" + "--------------------" + "\n" + "SUPERHERO #" + "\n" + "--------------------"
                + "\n" + "Superhero name: " + superheroName + "\n" + "Super powers: " +
                superPowers + "\n" + "Real name: " + realName + "\n"
                + "Year created: " + discoveryYear + "\n" +
                "Is human? " + isHuman + "\n" + "Strength: " + strength + "\n";
    }

}
