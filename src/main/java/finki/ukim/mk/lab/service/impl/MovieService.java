package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.repository.MovieRepository;
import finki.ukim.mk.lab.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {
        return movieRepository.searchMovies(text);
    }

    @Override
    public List<Movie> searchMoviesByRating(double rating) {
        return movieRepository.searchMoviesByRating(rating);
    }
}
