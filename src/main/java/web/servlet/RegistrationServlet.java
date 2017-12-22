package web.servlet;

import constants.Constants;
import service.UserService;
import storage.entity.User;
import web.Paths;
import web.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Paths.REGISTRATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = WebUtil.getUserParameters(req);
        WebUtil.setEnteredValuesToSession(user, session);

        if (createUser(user, req)) {
            req.getSession().removeAttribute(Constants.ERRORS);
            resp.sendRedirect(Paths.AUTHORIZATION_HTML);
        } else {
            req.getSession().removeAttribute(Constants.ERRORS);
            resp.sendRedirect(Paths.REGISTRATION_SERVLET);
        }
    }



    private boolean createUser(User user, HttpServletRequest req) {
        boolean result;
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        result = userService.createUser(user);
        req.getSession().setAttribute(Constants.ERRORS, userService.getErrors());
        return result;
    }
}
