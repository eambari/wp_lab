package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.model.Production;
import finki.ukim.mk.lab.repository.MovieRepository;
import finki.ukim.mk.lab.repository.ProductionRepository;
import finki.ukim.mk.lab.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieService(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
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
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> saveMovie(String movieTitle, String summary, double rating, Long productionId) {
        Production production = productionRepository.findById(productionId).get();
        return movieRepository.saveMovie(movieTitle, summary, rating, production);
    }
}
