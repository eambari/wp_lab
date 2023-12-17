package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
    List<Movie> searchMoviesByRating(double rating);
}
