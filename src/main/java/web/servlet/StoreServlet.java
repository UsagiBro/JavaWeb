package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.Cart;
import entity.dto.FilterBean;
import entity.dto.InstrumentsBean;
import service.category.CategoryService;
import service.instruments.InstrumentService;
import service.manufacturer.ManufacturerService;
import util.WebUtil;
import validator.FilterBeanValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

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
        loadFilterParametersInRequest(req);
        loadInstrumentsListInRequest(req);

        req.getRequestDispatcher(Paths.STORE_JSP).forward(req, resp);
    }

    private void loadFilterParametersInRequest(HttpServletRequest req) {
        req.setAttribute(WebConstants.MANUFACTURER_LIST, manufacturerService.getAllManufacturers());
        req.setAttribute(WebConstants.CATEGORIES_LIST, categoryService.getAllCategories());
    }

    private void loadInstrumentsListInRequest(HttpServletRequest req) {
        FilterBean filterBean = WebUtil.getFilterBeanFromRequest(req);
        InstrumentsBean instrumentsBean = instrumentService.getInstrumentsByFilter(filterBean);
        req.setAttribute(WebConstants.INSTRUMENT_BEAN, instrumentsBean);

        calculatePagesCount(req, filterBean);
        req.setAttribute(WebConstants.FILTER_BEAN, filterBean);
    }

    private void calculatePagesCount(HttpServletRequest req, FilterBean filterBean) {
        int instrumentsCount = instrumentService.getAllInstrumentsCount(filterBean);
        int pagesCount = (int) Math.ceil(instrumentsCount * 1.0 / filterBean.getInstrumentCount());
        req.setAttribute(WebConstants.PAGE_COUNT, pagesCount);
    }

}
