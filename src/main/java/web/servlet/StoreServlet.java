package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.Instrument;
import entity.InstrumentsBean;
import service.instruments.InstrumentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

    private InstrumentService instrumentService;

    @Override
    public void init() throws ServletException {
        instrumentService = (InstrumentService) getServletContext().getAttribute(WebConstants.INSTRUMENT_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InstrumentsBean instrumentsBean = instrumentService.getAllInstruments();
        req.setAttribute(WebConstants.INSTRUMENT_BEAN, instrumentsBean);
        req.getRequestDispatcher(Paths.STORE_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
