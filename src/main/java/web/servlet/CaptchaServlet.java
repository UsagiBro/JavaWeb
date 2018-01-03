package web.servlet;

import util.CaptchaDrawer;
import web.captcha.Captcha;
import web.captcha.generator_impl.CaptchaProvider;
import constants.WebConstants;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/captchaServlet")
public class CaptchaServlet extends HttpServlet {

    private CaptchaProvider captchaProvider;

    @Override
    public void init() throws ServletException {
        captchaProvider = (CaptchaProvider) getServletContext().getAttribute(WebConstants.CAPTCHA_PROVIDER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Captcha captcha = new Captcha();
        BufferedImage bufferedImage = CaptchaDrawer.createCaptchaImage(captcha);
        captchaProvider.setCaptcha(req, resp, captcha);
        resp.setContentType("image/png");
        try (OutputStream os = resp.getOutputStream()) {
            ImageIO.write(bufferedImage, "png", os);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
