package finki.ukim.mk.lab.bootstrap;

import finki.ukim.mk.lab.model.Movie;
import finki.ukim.mk.lab.model.Production;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.PushBuilder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataHolder {
    public static List<Movie> movies;
    public static List<Production> productions;
    @PostConstruct
    public void init(){
        movies = new ArrayList<>();
        productions = new ArrayList<>();
        IntStream.rangeClosed(1,10).forEach(i -> productions.add(new Production("Production" + i, "Country" + i, "Address" + i)));
        IntStream.rangeClosed(1,10).forEach(i -> movies.add(new Movie("Movie" + i, "Summary" + i, i, productions.get(i - 1))));
    }
}
