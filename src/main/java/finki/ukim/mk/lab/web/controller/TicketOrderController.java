package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.TicketOrder;
import finki.ukim.mk.lab.service.impl.TicketOrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;
    public TicketOrderController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }
    @PostMapping
    public String submitOrder(@RequestParam String movie,
                              @RequestParam int numTickets,
                              HttpServletRequest request,
                              Model model) {



        TicketOrder ticketOrder = ticketOrderService.placeOrder(movie, "Endrit Ambari", request.getRemoteAddr(), numTickets);
        model.addAttribute("ticketOrder", ticketOrder);
        return "orderConfirmation";
    }
}
