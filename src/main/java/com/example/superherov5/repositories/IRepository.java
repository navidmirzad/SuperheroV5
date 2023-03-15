package com.example.superherov5.repositories;

import com.example.superherov5.dto.SuperheroCityDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.dto.SuperheroPowerCountDTO;

import java.util.List;

public interface IRepository {

    SuperheroDTO searchForSuperhero(String superheroName);
    List<SuperheroPowerCountDTO> getSuperheroPowerCount();

    //SuperheroCityDTO getSuperheroCity(String city);
}

