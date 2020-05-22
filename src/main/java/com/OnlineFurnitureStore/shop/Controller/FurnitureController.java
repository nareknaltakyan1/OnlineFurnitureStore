package com.OnlineFurnitureStore.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FurnitureController {

    @RequestMapping(value = "/furnitureList", method = RequestMethod.GET)
    public String furnitureList(Model model) {
//        model.addAttribute("message", "Hello, world!");
        return "Furniture";
    }
}
