package com.example.superherov5.Controller;

import com.example.superherov5.Service.SuperheroService;
import com.example.superherov5.dto.SuperheroCityDTO;
import com.example.superherov5.dto.SuperheroDTO;
import com.example.superherov5.dto.SuperheroNamePowerDTO;
import com.example.superherov5.dto.SuperheroPowerCountDTO;
import com.example.superherov5.model.Superhero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Superhero>> getListOfSuperheroes() {
        List listOfSuperheroes = superheroService.getSuperheroes();
        return new ResponseEntity<List<Superhero>>(listOfSuperheroes, HttpStatus.OK);
    }

    @GetMapping("/{superheroName}")
    public ResponseEntity<SuperheroDTO> getSuperhero(@PathVariable String superheroName) {
        SuperheroDTO superhero = superheroService.searchForSuperhero(superheroName);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping("/superpower/count")
    public ResponseEntity<List<SuperheroPowerCountDTO>> getSuperheroPowerCount() {
        List superheroPowerCount = superheroService.getSuperheroPowerCount();
        return new ResponseEntity<List<SuperheroPowerCountDTO>>(superheroPowerCount, HttpStatus.OK);
    }

    @GetMapping("/superpower")
    public ResponseEntity<List<SuperheroNamePowerDTO>> getSuperheroNamePower() {
        List superheroPowerName = superheroService.superheroNamePower();
        return new ResponseEntity<List<SuperheroNamePowerDTO>>(superheroPowerName, HttpStatus.OK);
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<SuperheroCityDTO>> getSuperheroCity(@PathVariable String cityName) {
        List<SuperheroCityDTO> superheroCity = superheroService.getSuperheroCity(cityName);
        return new ResponseEntity<>(superheroCity, HttpStatus.OK);
    }


    /*


    @PostMapping("/create/")
    public ResponseEntity<Superhero> createSuperhero(@RequestBody Superhero superhero) {
        Superhero returnSuperhero = superheroService.createSuperhero(superhero);
        return new ResponseEntity<>(returnSuperhero, HttpStatus.OK);
    }

    @PutMapping("/edit/")
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero) {
        Superhero editSuperhero = superheroService.editSuperhero(superhero);
        return new ResponseEntity<>(editSuperhero, HttpStatus.OK);
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<Superhero> deleteSuperhero(@RequestBody Superhero superhero) {
        Superhero deleteSuperhero = superheroService.deleteSuperhero(superhero);
        return new ResponseEntity<>(deleteSuperhero, HttpStatus.OK);
    }
*/

}

