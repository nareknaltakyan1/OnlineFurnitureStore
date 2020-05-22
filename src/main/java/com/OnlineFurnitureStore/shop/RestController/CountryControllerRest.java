package com.OnlineFurnitureStore.shop.RestController;

import com.OnlineFurnitureStore.shop.Entity.Country;
import com.OnlineFurnitureStore.shop.Manager.CountryManager;
import com.OnlineFurnitureStore.shop.Repository.CountryRepository;
import com.OnlineFurnitureStore.shop.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryControllerRest {

    @Autowired
    private CountryManager countryManager;

    @PostMapping(value = "/add")
    public ResponseEntity addCountry(@RequestBody CountryDTO countryDTO){
        return countryManager.addCountry(countryDTO.getName());
    }
}
