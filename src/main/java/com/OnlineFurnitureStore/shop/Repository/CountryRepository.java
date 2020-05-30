package com.OnlineFurnitureStore.shop.Repository;

import com.OnlineFurnitureStore.shop.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryById(Long id);
    ArrayList<Country> findAll();
}
