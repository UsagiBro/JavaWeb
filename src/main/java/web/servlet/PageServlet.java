package web.servlet;

import constants.Paths;
import constants.WebConstants;
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

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {

    private InstrumentService instrumentService;
    private ManufacturerService manufacturerService;
    private CategoryService categoryService;
    private FilterBeanValidator filterBeanValidator;

    @Override
    public void init() throws ServletException {
        instrumentService = (InstrumentService) getServletContext().getAttribute(WebConstants.INSTRUMENT_SERVICE);
        manufacturerService = (ManufacturerService) getServletContext().getAttribute(WebConstants.MANUFACTURER_SERVICE);
        categoryService = (CategoryService) getServletContext().getAttribute(WebConstants.CATEGORY_SERVICE);
        filterBeanValidator = new FilterBeanValidator();
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
        req.setAttribute(WebConstants.FILTER_BEAN, filterBean);
        filterBeanValidator.validate(filterBean);

        processPage(req, filterBean);
        InstrumentsBean instrumentsBean = instrumentService.getInstrumentsByFilter(filterBean);
        req.setAttribute(WebConstants.INSTRUMENT_BEAN, instrumentsBean);
    }

    private void processPage(HttpServletRequest request, FilterBean filterBean) {
        String page = request.getParameter(WebConstants.PAGE);
        int offset;
        int filterInstrumentCount = Integer.valueOf(filterBean.getInstrumentCount());
        if (page.equals("next")) {
            offset =  Integer.valueOf(filterBean.getOffset()) + filterInstrumentCount;
        } else if (page.equals("previous")){
            offset = (Integer.valueOf(page) - 1) - filterInstrumentCount;
        } else {
            offset = (Integer.valueOf(page) - 1) * filterInstrumentCount;
        }
        filterBean.setOffset(String.valueOf(offset));
    }
}
