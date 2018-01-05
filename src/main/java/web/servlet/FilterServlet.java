package web.servlet;

import constants.WebConstants;
import entity.InstrumentsBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filter")
public class FilterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InstrumentsBean instrumentsBean = (InstrumentsBean) req.getAttribute(WebConstants.INSTRUMENT_BEAN);
        instrumentsBean.filter();
    }
}
