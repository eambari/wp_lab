package finki.ukim.mk.lab.bootstrap;

import finki.ukim.mk.lab.model.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataHolder {
    public static List<Movie> movies;
    @PostConstruct
    public void init(){
        movies = new ArrayList<>();
        IntStream.rangeClosed(1,10).forEach(i -> movies.add(new Movie("Movie" + i, "Summary" + i, i)));
    }
}
