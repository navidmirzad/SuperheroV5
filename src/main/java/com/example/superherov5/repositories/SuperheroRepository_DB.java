package com.example.superherov5.repositories;

import com.example.superherov5.dto.SuperheroCityDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.dto.SuperheroNamePowerDTO;
import com.example.superherov5.dto.SuperheroPowerCountDTO;
import com.example.superherov5.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SuperheroRepository_DB implements IRepository {
    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {

            String SQL = "select * from superhero";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()) {
                int hero_id = rs.getInt("hero_id");
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int discoveryYear = rs.getInt("discoveryYear");
                String isHuman = rs.getString("isHuman");
                int strength = rs.getInt("strength");
                superheroes.add(new Superhero(hero_id, superheroName, realName, discoveryYear, isHuman, strength));
            }
            return superheroes;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SuperheroDTO searchForSuperhero(String superheroName) {
        SuperheroDTO superheroByName = null;

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {

            String SQL = "select * from superhero where superheroName = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, superheroName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int hero_id = rs.getInt("hero_id");
                String superheroNameColumn = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int discoveryYear = rs.getInt("discoveryYear");
                String isHuman = rs.getString("isHuman");
                int strength = rs.getInt("strength");
                int city_id = rs.getInt("city_id");
                superheroByName = new SuperheroDTO(hero_id, superheroNameColumn, realName,
                        discoveryYear, isHuman, strength, city_id);

            }
            return superheroByName;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPowerCountDTO> getSuperheroPowerCount() {

        List<SuperheroPowerCountDTO> superheroPowerCount = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {

            String SQL = "SELECT hero_id, superheroName, realName, COUNT(*) AS superpowerCount \n" +
                    "FROM superhero \n" +
                    "JOIN superpowerrelation USING (hero_id) \n" +
                    "JOIN superpower ON superpower.power_id = superpowerrelation.power_id \n" +
                    "GROUP BY hero_id, superheroName, realName;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()) {
                int hero_id = rs.getInt("hero_id");
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int powerCount = rs.getInt("superpowerCount");
                superheroPowerCount.add(new SuperheroPowerCountDTO(hero_id, superheroName, realName, powerCount));
            }
            return superheroPowerCount;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroNamePowerDTO> getSuperheroNameAndPower() {
        List<SuperheroNamePowerDTO> superheroNamePower = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {

            String SQL = "SELECT s.hero_id, s.superheroName, s.realName, GROUP_CONCAT(COALESCE(sp.superpower, '') SEPARATOR ', ') AS superpowers\n" +
                    "FROM superhero s\n" +
                    "LEFT JOIN superpowerRelation spr ON s.hero_id = spr.hero_id\n" +
                    "LEFT JOIN superpower sp ON spr.power_id = sp.power_id\n" +
                    "GROUP BY s.hero_id, s.superheroName, s.realName;\n";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(SQL);

            while (rs.next()) {
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                List<String> superpowers = Arrays.asList(rs.getString("superpowers").split(","));
                superheroNamePower.add(new SuperheroNamePowerDTO(superheroName, realName, superpowers));
            }

            return superheroNamePower;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<SuperheroCityDTO> getSuperheroCity(String cityName) {
        List<SuperheroCityDTO> superheroCity = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {

            String SQL = "SELECT s.superheroName, s.realName, c.cityName\n" +
                    "FROM superhero s\n" +
                    "INNER JOIN city c ON s.city_id = c.city_id\n" +
                    "WHERE c.cityName = ?\n" +
                    "GROUP BY s.superheroName, s.realName, c.cityName;\n";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, cityName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                superheroCity.add(new SuperheroCityDTO(rs.getString("superheroName"),
                        rs.getString("realName"),
                        rs.getString("cityName")));
            }
            return superheroCity;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
