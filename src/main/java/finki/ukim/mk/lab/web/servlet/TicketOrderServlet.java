package finki.ukim.mk.lab.web.servlet;

import finki.ukim.mk.lab.model.TicketOrder;
import finki.ukim.mk.lab.service.impl.TicketOrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {
    private final TicketOrderService ticketOrderService;
    private final SpringTemplateEngine springTemplateEngine;

    public TicketOrderServlet(TicketOrderService ticketOrderService, SpringTemplateEngine springTemplateEngine) {
        this.ticketOrderService = ticketOrderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);
        TicketOrder ticketOrder = ticketOrderService.placeOrder(
                req.getParameter("movie"),
                "Endrit Ambari",
                req.getRemoteAddr(),
                Integer.parseInt(req.getParameter("numTickets"))
        );
        context.setVariable("ticketOrder", ticketOrder);
        springTemplateEngine.process("orderConfirmation.html", context, resp.getWriter());
    }
}
