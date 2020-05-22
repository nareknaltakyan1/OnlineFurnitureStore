package com.OnlineFurnitureStore.shop.Service;

import com.OnlineFurnitureStore.shop.Entity.Country;
import com.OnlineFurnitureStore.shop.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public ResponseEntity addCountry(String name){
        try {
            countryRepository.save(new Country(name));
        }catch (Exception e){
            return (ResponseEntity) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("Ok");
    }
}
