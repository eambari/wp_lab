package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.bootstrap.DataHolder;
import finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.movies;
    }
    public List<Movie> searchMovies(String text){
        return DataHolder.movies.stream().filter(movie -> movie.getTitle().contains(text) || movie.getSummary().contains(text)).collect(Collectors.toList());
    }
    public List<Movie> searchMoviesByRating(double rating){
        return DataHolder.movies.stream().filter(movie -> movie.getRating() >= rating).collect(Collectors.toList());
    }
}
