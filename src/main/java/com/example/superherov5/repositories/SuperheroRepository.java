package com.example.superherov5.repositories;

import com.example.superherov5.model.Superhero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {

    private List<Superhero> superheroes = new ArrayList<>();

    public Superhero createSuperhero(Superhero superhero) {
        superheroes.add(superhero);
        return superhero;
    }

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public Superhero searchForSuperhero(String superheroName) {
        //List<Superhero> superheroMatch = new ArrayList<>();
        Superhero superheroMatch = null;

        for (Superhero søgning : superheroes) {
            if (søgning.getSuperheroName().toLowerCase().contains(superheroName.toLowerCase())) {

                superheroMatch = søgning;
            }
        }
        return superheroMatch;
    }

    public Superhero editSuperhero(Superhero superhero) {
        int i = 0;
        while (i < superheroes.size()) {
            if (superhero.getSuperheroName().equals(superheroes.get(i).getSuperheroName())) {
                superheroes.set(i, superhero);
                return superhero;
            }
            i++;
        }
        return null;
    }

    public Superhero deleteSuperhero(Superhero superhero) {
        Superhero superheroToRemove = searchForSuperhero(superhero.getSuperheroName());
        superheroes.remove(superheroToRemove);
        return superheroToRemove;
    }

}

