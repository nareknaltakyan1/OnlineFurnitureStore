package com.OnlineFurnitureStore.shop.Service;

import com.OnlineFurnitureStore.shop.Entity.Country;
import com.OnlineFurnitureStore.shop.Repository.CountryRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public ResponseEntity allCountries(){
        try {
            ArrayList<Country> countries = countryRepository.findAll();
            return ResponseEntity.ok(countries);
        }catch (Exception e){
            return (ResponseEntity) ResponseEntity.badRequest();
        }
    }

    public ResponseEntity addCountry(String name){
        try {
            Country country = new Country();
            country.setName(name);
            country.setRemoved(false);
            countryRepository.save(country);
        }catch (Exception e){
            return (ResponseEntity) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("Added");
    }

    public ResponseEntity removeCountry(Long id){
        try {
            Country country = countryRepository.findCountryById(id);
            country.setRemoved(true);
            countryRepository.save(country);
        }catch (Exception e){
            return (ResponseEntity) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("Removed");
    }
}
