package finki.ukim.mk.lab.service.impl;

import finki.ukim.mk.lab.model.TicketOrder;
import finki.ukim.mk.lab.service.ITicketOrderService;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderService implements ITicketOrderService {

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        return new TicketOrder(movieTitle, clientName, address, numberOfTickets);
    }
}
