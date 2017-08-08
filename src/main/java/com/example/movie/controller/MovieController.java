package com.example.movie.controller;

import com.example.movie.domain.Movie;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    String getMovies(Model model) {
        List<Movie> movies = movieService.getAll();
        model.addAttribute("listOMovies", movies);
        return "view_movies";
    }

    @GetMapping("/movie")
    String getMovie(Model model) {
        return "new_movie";
    }

    @PostMapping("/movie")
    String addMovie(Movie movie, Model model) {
        movieService.add(movie);
        List<Movie> movies = movieService.getAll();
        model.addAttribute("listOMovies", movies);
        return "view_movies";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/loggedout")
    String logout(Model model) {
        List<Movie> movies = movieService.getAll();
        model.addAttribute("listOMovies", movies);
        return "view_movies";
    }

}
