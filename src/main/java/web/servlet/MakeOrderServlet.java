package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.Cart;
import entity.order.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/makeOrder")
public class MakeOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute(WebConstants.CART);
        Order order = new Order();
        cart.clear();
        resp.sendRedirect(Paths.STORE_SERVLET);
    }
}
