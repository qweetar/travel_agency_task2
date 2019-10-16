package ru.myfirstwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.myfirstwebsite.domain.Review;
import ru.myfirstwebsite.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {

    @Autowired
    public ReviewService reviewService;

    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        model.addAttribute("reviews", reviewService.findAll());
        return "reviewList";
    }

    @GetMapping("/review/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("review", reviewService.getById(id));
        return "showReview";
    }

    @GetMapping("/addReview")
    public String createReviewPage() {
        return "createReview";
    }

    @PostMapping("/addReview")
    public String addReview(@ModelAttribute("review") Review review) {
        reviewService.save(review);
        return "redirect:/reviews";
    }

    @PostMapping("/updateReview")
    public String updateReview(@ModelAttribute("review") Review review) {
        reviewService.update(review);
        return "redirect:/review/" + review.getReviewId();
    }

    @GetMapping("/updateReview/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("review", reviewService.getById(id));
        return "editReview";
    }

    @GetMapping("/deleteReview/{id}")
    public String deleteReview(@PathVariable("id") Long id) {
        reviewService.delete(id);
        return "redirect:/reviews";
    }
}
