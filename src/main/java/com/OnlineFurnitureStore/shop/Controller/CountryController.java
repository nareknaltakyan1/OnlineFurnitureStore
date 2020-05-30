package com.OnlineFurnitureStore.shop.Controller;

import com.OnlineFurnitureStore.shop.Manager.CountryManager;
import com.OnlineFurnitureStore.shop.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryManager countryManager;

    @GetMapping(value = "/all")
    public ResponseEntity allCountry(){
        return countryManager.allCountries();
    }

    @PostMapping(value = "/add")
    public ResponseEntity addCountry(@RequestParam("name") String name){
        return countryManager.addCountry(name);
    }

    @PostMapping(value = "/remove")
    public ResponseEntity removeCountry(@RequestParam("id") Long id){
        return countryManager.removeCountry(id);
    }
}
