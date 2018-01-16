package web.servlet;

import constants.WebConstants;
import entity.Cart;
import entity.Instrument;
import service.instruments.InstrumentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    private InstrumentService instrumentService;

    @Override
    public void init() throws ServletException {
        instrumentService = (InstrumentService) getServletContext().getAttribute(WebConstants.INSTRUMENT_SERVICE);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute(WebConstants.CART);
        String instrumentName = req.getParameter(WebConstants.INSTRUMENT_NAME);
        Instrument instrument = instrumentService.getInstrumentByName(instrumentName);
        cart.addToCart(instrument);
        System.out.println();
    }
}
