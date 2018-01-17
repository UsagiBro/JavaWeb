package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.Cart;
import entity.Instrument;
import service.instruments.InstrumentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeInstrumentFromCart")
public class RemoveInsFromCartServlet extends HttpServlet {

    private InstrumentService instrumentService;

    @Override
    public void init() throws ServletException {
        instrumentService = (InstrumentService) getServletContext().getAttribute(WebConstants.INSTRUMENT_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instrumentName = req.getParameter(WebConstants.INSTRUMENT_NAME);
        Instrument instrument = instrumentService.getInstrumentByName(instrumentName);
        Cart cart = (Cart) req.getSession().getAttribute(WebConstants.CART);
        cart.removeFromCart(instrument);
        resp.sendRedirect(Paths.CART_SERVLET);
    }
}
