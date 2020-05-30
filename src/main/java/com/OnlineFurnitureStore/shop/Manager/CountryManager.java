package com.OnlineFurnitureStore.shop.Manager;

import com.OnlineFurnitureStore.shop.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class CountryManager {

    @Autowired
    private CountryService countryService;

    public ResponseEntity allCountries(){
        return countryService.allCountries();
    }

    public ResponseEntity addCountry(String name){
        return countryService.addCountry(name);
    }

    public ResponseEntity removeCountry(Long id){
        return countryService.removeCountry(id);
    }

}
