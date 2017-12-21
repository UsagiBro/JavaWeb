package web.servlet;

import service.UserService;
import storage.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = getUserParameters(req);

        if (createUser(user, req)) {
            resp.sendRedirect("authorization.html");
        } else {
            req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
        }
    }

    private User getUserParameters(HttpServletRequest req) {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        return new User(name, surname, password, email);
    }

    private boolean createUser(User user, HttpServletRequest req) {
        boolean result = false;
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        result = userService.createUser(user);
        req.setAttribute("errors", userService.getErrors());
        return result;
    }
}
