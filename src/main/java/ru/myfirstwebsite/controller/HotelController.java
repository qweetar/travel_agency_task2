package ru.myfirstwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myfirstwebsite.domain.Hotel;
import ru.myfirstwebsite.service.HotelService;

@Controller
@RequestMapping("/hotel/")
public class HotelController {

    @Autowired
    public HotelService hotelService;

    @GetMapping("/hotels")
    public String getAllHotels(Model model) {
        model.addAttribute("hotels", hotelService.findAll());
        return "hotelList";
    }

    @GetMapping("/hotel/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hotel", hotelService.getById(id));
        return "showHotel";
    }

    @GetMapping("/addHotel")
    public String createHotelPage() {
        return "createHotel";
    }

    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.save(hotel);
        return "redirect:/hotels";
    }

    @PostMapping("/updateHotel")
    public String updateHotel(@ModelAttribute("hotel") Hotel hotel) {
        hotelService.update(hotel);
        return "redirect:/hotel/" + hotel.getHotelId();
    }

    @GetMapping("/updateHotel/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hotel", hotelService.getById(id));
        return "editHotel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable("id") Long id) {
        hotelService.delete(id);
        return "redirect:/hotels";
    }

}
