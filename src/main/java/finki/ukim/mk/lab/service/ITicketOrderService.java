package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.TicketOrder;

public interface ITicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}
