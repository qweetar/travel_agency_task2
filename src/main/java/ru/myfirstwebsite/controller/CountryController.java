package ru.myfirstwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myfirstwebsite.domain.Country;
import ru.myfirstwebsite.service.CountryService;

@Controller
@RequestMapping("/")
public class CountryController {

    @Autowired
    public CountryService countryService;

    @GetMapping("/countries")
    public String getAllCountries(Model model) {
        model.addAttribute("countries", countryService.findAll());
        return "countryList";
    }

    @GetMapping("/country/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("country", countryService.getById(id));
        return "showCountry";
    }

    @GetMapping("/addCountry")
    public String createCountryPage() {
        return "createCountry";
    }

    @PostMapping("/addCountry")
    public String addCountry(@ModelAttribute("country")Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @PostMapping("/updateCountry")
    public String updateCountry(@ModelAttribute("country") Country country) {
        countryService.update(country);
        return "redirect:/country/" + country.getCountryId();
    }

    @GetMapping("/updateCountry/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("country", countryService.getById(id));
        return "editCountry";
    }

    @GetMapping("/deleteCountry/{id}")
    public String deleteCountry(@PathVariable("id") Integer id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}
