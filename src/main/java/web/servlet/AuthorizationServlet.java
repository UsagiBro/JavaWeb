package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.User;
import service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = (UserService) getServletContext().getAttribute(WebConstants.USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Paths.AUTHORIZATION_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(WebConstants.EMAIL);
        String password = req.getParameter(WebConstants.PASSWORD);
        User user = userService.getUserByEmailAndPassword(email, password);
        HttpSession session = req.getSession();
        session.setAttribute(WebConstants.USER, user);
        resp.sendRedirect(Paths.CABINET_SERVLET);
    }
}
