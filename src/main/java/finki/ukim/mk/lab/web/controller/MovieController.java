package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.model.Production;
import finki.ukim.mk.lab.service.impl.MovieService;
import finki.ukim.mk.lab.service.impl.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final ProductionService productionService;

    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService = productionService;
    }
    private static void CheckModelError(String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
    }

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model) {
        CheckModelError(error, model);
        model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }

    @PostMapping
    public String SearchMovies(@RequestParam(required = false) String error, @RequestParam String searchText, Model model) {
        CheckModelError(error, model);
        if (searchText != null || !searchText.isEmpty()) {
            model.addAttribute("movies", movieService.searchMovies(searchText));
        } else model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }
    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable long id, Model model) {
        Movie movie = movieService.findById(id).get();
        model.addAttribute("movie", movie);
        model.addAttribute("productions", productionService.listAll());
        return "add-movie";
    }
    @GetMapping("/add")
    public String addMovie(Model model) {
        model.addAttribute("productions", this.productionService.listAll());
        return "add-movie";
    }
    @PostMapping("/add")
    public String addMovie(@RequestParam String movieTitle,
                            @RequestParam String summary,
                            @RequestParam double rating,
                            @RequestParam Long productionId,
                            @RequestParam(required = false) String movieId,
                            Model model) {
        if (movieId != null && !movieId.isEmpty()) {
            long id = Long.parseLong(movieId);
            Optional<Movie> movie = movieService.findById(id);
            if (movie.isPresent()) {
                movieService.deleteById(id);
            }
        }
        movieService.saveMovie(movieTitle, summary, rating, productionId);
        return "redirect:/movies";

    }
    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        this.movieService.deleteById(id);
        return "redirect:/movies";
    }
}
