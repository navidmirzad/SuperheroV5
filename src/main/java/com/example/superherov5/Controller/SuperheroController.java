package com.example.superherov5.Controller;

import com.example.superherov5.Service.SuperheroService;
import com.example.superherov5.dto.SuperheroFormDTO;
import com.example.superherov5.dto.*;
import com.example.superherov5.model.Superhero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("superheroes")
public class SuperheroController {

    private SuperheroService superheroService;

    public SuperheroController(SuperheroService superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping("/")
    public String getListOfSuperheroes(Model model) {
        List <Superhero> listOfSuperheroes = superheroService.getSuperheroes();
        model.addAttribute("superheroes", listOfSuperheroes);

        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        SuperheroFormDTO superheroForm = new SuperheroFormDTO();
        model.addAttribute("superheroForm", superheroForm);

        List<String> powerList = Arrays.asList("Fast", "Strong", "Invisible");
        model.addAttribute("powerList", powerList);
        return "creation_form";
    }

    @PostMapping("/superheroes/create")
    public String submitForm(@ModelAttribute("superheroForm") SuperheroFormDTO superheroForm) {
        System.out.println(superheroForm);
        return "creation_success";
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

