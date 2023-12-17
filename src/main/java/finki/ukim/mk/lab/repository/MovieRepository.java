package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.bootstrap.DataHolder;
import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.movies;
    }
    public List<Movie> searchMovies(String text){
        return DataHolder.movies.stream().filter(movie -> movie.getTitle().toLowerCase().contains(text.toLowerCase()) || movie.getSummary().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }
    public List<Movie> searchMoviesByRating(double rating){
        return DataHolder.movies.stream().filter(movie -> movie.getRating() >= rating).collect(Collectors.toList());
    }
    public Optional<Movie> saveMovie(String movieTitle, String summary, double rating, Production production) {
        if(production == null) {
            throw new IllegalArgumentException();
        }
        Movie movie = new Movie(movieTitle, summary, rating, production);
        DataHolder.movies.removeIf(m -> m.getTitle().equals(movie.getTitle()));
        DataHolder.movies.add(movie);
        return Optional.of(movie);
    }
    public Optional<Movie> findById(Long id) {
        return DataHolder.movies.stream().filter(i -> i.getId() == id).findFirst();
    }

    public void deleteById(Long id) {
        DataHolder.movies.removeIf(i -> i.getId() == id);
    }
}
