package ru.myfirstwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myfirstwebsite.domain.Tour;
import ru.myfirstwebsite.service.ReviewService;
import ru.myfirstwebsite.service.TourService;

import java.util.Date;

@Controller
@RequestMapping("/")
public class TourController {

    @Autowired
    public TourService tourService;

    @Autowired
    public ReviewService reviewService;

    @GetMapping("/tours")
    public String getAllTours(
            @RequestParam(required = false, defaultValue = "")String country,
            Model model
    ) {
        Iterable<Tour> tours = tourService.findAll();

        if (country != null && !country.isEmpty()) {
            tours = tourService.findByCountry(country);
        } else {
            tours = tourService.findAll();
        }
        model.addAttribute("tours", tours);
        model.addAttribute("country", country);
        return "tourList";
    }

    @GetMapping("/searchTour")
    public String getToursBySearch(
            @RequestParam(required = false, defaultValue = "")String country,
            @DateTimeFormat(pattern="yyyy-MM-dd")Date tour_date,
            Integer tourDuration,
            String tourPrice,
            Integer numStars,
            String tourType,
            Model model
    ) {
        Iterable<Tour> tours = tourService.findAll();

        tours = tourService.searchTour(country, tour_date, tourDuration, tourPrice, numStars, tourType);
        model.addAttribute("tours", tours);
        model.addAttribute("country", country);
        return "tourList";
    }

    @GetMapping("/tour/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tour", tourService.getById(id));
        model.addAttribute("reviews", reviewService.getReviewByTourId(id));
        return "showTour";
    }

    @GetMapping("/tourByHotel/{id}")
    public String getToursByHotelId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tour", tourService.getToursByHotelId(id));
        return "showTour";
    }

    @GetMapping("/tourByUser/{id}")
    public String getToursByUserId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("tours", tourService.getToursByUserId(id));
        return "tourUserList";
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
