package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;
import service.category.CategoryService;
import service.instruments.InstrumentService;
import service.manufacturer.ManufacturerService;
import util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/filterInstruments")
public class FilterServlet extends HttpServlet {

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
        FilterBean filterBean = WebUtil.getFilterBeanFromRequest(req);
        InstrumentsBean instrumentsBean = instrumentService.getInstrumentsByFilter(filterBean);
        req.setAttribute(WebConstants.INSTRUMENT_BEAN, instrumentsBean);
        req.setAttribute("filterBean", filterBean);
        req.setAttribute(WebConstants.MANUFACTURER_LIST, manufacturerService.getAllManufacturers());
        req.setAttribute(WebConstants.CATEGORIES_LIST, categoryService.getAllCategories());

        req.getRequestDispatcher(Paths.STORE_JSP).forward(req, resp);
    }
}
