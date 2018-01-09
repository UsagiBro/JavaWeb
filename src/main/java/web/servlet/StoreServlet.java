package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.dto.InstrumentsBean;
import entity.dto.Manufacturer;
import service.category.CategoryService;
import service.instruments.InstrumentService;
import service.manufacturer.ManufacturerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/store")
public class StoreServlet extends HttpServlet {

    private InstrumentService instrumentService;
    private ManufacturerService manufacturerService;
    private CategoryService categoryService;

    @Override
    public void init() throws ServletException {
        instrumentService = (InstrumentService) getServletContext().getAttribute(WebConstants.INSTRUMENT_SERVICE);
        manufacturerService = (ManufacturerService) getServletContext().getAttribute(WebConstants.MANUFACTURER_SERVICE);
        categoryService = (CategoryService) getServletContext().getAttribute(WebConstants.CATEGORY_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(WebConstants.MANUFACTURER_LIST, manufacturerService.getAllManufacturers());
        req.setAttribute(WebConstants.CATEGORIES_LIST, categoryService.getAllCategories());

        InstrumentsBean instrumentsBean = instrumentService.getAllInstruments();
        req.setAttribute(WebConstants.INSTRUMENT_BEAN, instrumentsBean);
        req.getRequestDispatcher(Paths.STORE_JSP).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
