package ru.myfirstwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myfirstwebsite.domain.Tour;
import ru.myfirstwebsite.service.TourService;

@Controller
@RequestMapping("/tour/")
public class TourController {

    @Autowired
    public TourService tourService;

    @GetMapping("/tours")
    public String getAllTours(Model model) {
        model.addAttribute("tours", tourService.findAll());
        return "tourList";
    }

    @GetMapping("/tour/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tour", tourService.getById(id));
        return "showTour";
    }

    @GetMapping("/addTour")
    public String createTourPage() {
        return "createTour";
    }

    @PostMapping("/addTour")
    public String addTour(@ModelAttribute("tour") Tour tour) {
        tourService.save(tour);
        return "redirect:/tours";
    }

    @PostMapping("/updateTour")
    public String updateTour(@ModelAttribute("tour") Tour tour) {
        tourService.update(tour);
        return "redirect:/tour/" + tour.getTourId();
    }

    @GetMapping("/updateTour/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tour", tourService.getById(id));
        return "editTour";
    }

    @GetMapping("/deleteTour/{id}")
    public String deleteTour(@PathVariable("id") Long id) {
        tourService.delete(id);
        return "redirect:/tours";
    }
}
