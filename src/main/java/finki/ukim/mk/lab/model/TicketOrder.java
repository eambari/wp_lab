package finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class TicketOrder {
    long id;
    String movieTitle;
    String clientName;
    String clientAddress;
    int numberOfTickets;

    public TicketOrder(String movieTitle, String clientName, String clientAddress, int numberOfTickets) {
        this.id = (long) (Math.random() * 1000);
        this.movieTitle = movieTitle;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.numberOfTickets = numberOfTickets;
    }
}
