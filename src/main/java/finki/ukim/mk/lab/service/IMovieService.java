package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
    Optional<Movie> findById(Long id);

    Optional<Movie> saveMovie(String movieTitle, String summary, double rating, Long productionId);

    void deleteById(Long id);
}
