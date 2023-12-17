package finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Movie {
    long id;
    String title;
    String summary;
    double rating;

    public Movie(String title, String summary, double rating) {
        this.id = (long) (Math.random() * 1000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
    }
}
