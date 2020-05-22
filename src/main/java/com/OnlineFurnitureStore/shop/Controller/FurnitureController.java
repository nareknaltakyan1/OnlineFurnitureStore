package com.OnlineFurnitureStore.shop.Controller;

import com.OnlineFurnitureStore.shop.Entity.Country;
import com.OnlineFurnitureStore.shop.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;

@Controller
public class FurnitureController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/furnitureList", method = RequestMethod.GET)
    public String furnitureList(Model model) {
        Country country = countryRepository.findCountryById((long) 1);
        model.addAttribute("country", country);

        LinkedList<Country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);

        return "Furniture";
    }
}
