package util;

import constants.WebConstants;
import entity.User;
import entity.dto.FilterBean;
import entity.dto.UserBean;
import validator.FilterBeanValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public final class WebUtil {

    private WebUtil() {
        throw new IllegalStateException("Can't create an instance of this class");
    }

    public static User getUserFromUserBeanParameters(UserBean userBean) {
        String name = userBean.getName();
        String surname = userBean.getSurname();
        String password = userBean.getPassword();
        String email = userBean.getEmail();
        boolean news = userBean.getNews();
        boolean newProducts = userBean.getNewProducts();
        return new User(name, surname, password, email, news, newProducts);
    }

    public static UserBean getUserBeanFromRequest(HttpServletRequest req) {
        String name = req.getParameter(WebConstants.NAME);
        String surname = req.getParameter(WebConstants.SURNAME);
        String password = req.getParameter(WebConstants.PASSWORD);
        String email = req.getParameter(WebConstants.EMAIL);
        String passwordRepeat = req.getParameter(WebConstants.PASSWORD_REPEAT);
        boolean news = req.getParameter(WebConstants.NEWS) != null;
        boolean newProducts = req.getParameter(WebConstants.NEW_PRODUCTS) != null;
        req.getParameter(WebConstants.AVATAR);
        return new UserBean(name, surname, password, email, passwordRepeat, news, newProducts);
    }

    public static void setEnteredValuesToSession(UserBean userBean, HttpSession session) {
        session.setAttribute(WebConstants.NAME, userBean.getName());
        session.setAttribute(WebConstants.SURNAME, userBean.getSurname());
        session.setAttribute(WebConstants.EMAIL, userBean.getEmail());
        session.setAttribute(WebConstants.NEWS, userBean.getNews());
        session.setAttribute(WebConstants.NEW_PRODUCTS, userBean.getNewProducts());
    }

    public static void removeEnteredValuesFromSession(HttpSession session) {
        session.removeAttribute(WebConstants.NAME);
        session.removeAttribute(WebConstants.SURNAME);
        session.removeAttribute(WebConstants.EMAIL);
        session.removeAttribute(WebConstants.NEWS);
        session.removeAttribute(WebConstants.NEW_PRODUCTS);
        session.removeAttribute(WebConstants.ERRORS);
        session.removeAttribute(WebConstants.CAPTCHA_VALUE);
    }


    public static FilterBean getFilterBeanFromRequest(HttpServletRequest request) {
        FilterBean filterBean = new FilterBean();
        FilterBeanValidator filterBeanValidator = new FilterBeanValidator();
        filterBean.setCategoryFilter(request.getParameter(WebConstants.FILTER_CATEGORY));
        filterBean.setManufacturerFilter(request.getParameter(WebConstants.FILTER_MANUFACTURER));
        filterBean.setSort(request.getParameter(WebConstants.SORT_VALUE));
        filterBean.setSortDirection(request.getParameter(WebConstants.SORT_DIRECTION));

        String currentPage = request.getParameter(WebConstants.CURRENT_PAGE);
        String instrumentsCount = request.getParameter(WebConstants.INSTRUMENTS_COUNT);

        if (Objects.isNull(currentPage) || currentPage.isEmpty()) {
            filterBean.setCurrentPage(WebConstants.START_PAGE);
        } else {
            filterBeanValidator.validateParameterForFilterBean(currentPage);
            filterBean.setCurrentPage(Integer.valueOf(currentPage));
        }

        if (Objects.isNull(instrumentsCount) || instrumentsCount.isEmpty()) {
            filterBean.setInstrumentCount(WebConstants.DEFAULT_COUNT_OF_INSTRUMENTS_ON_PAGE);
        } else {
            filterBeanValidator.validateParameterForFilterBean(instrumentsCount);
            filterBean.setInstrumentCount(Integer.valueOf(instrumentsCount));
        }


        int offset = (filterBean.getCurrentPage() - 1) * filterBean.getInstrumentCount();
        if (offset < 0) {
            offset = 0;
        }
        filterBean.setOffset(offset);

        return filterBean;
    }
}
