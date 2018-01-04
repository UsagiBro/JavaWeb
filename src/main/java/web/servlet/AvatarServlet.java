package web.servlet;

import constants.Paths;
import constants.WebConstants;
import entity.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

@WebServlet("/avatarServlet")
public class AvatarServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AvatarServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image.png");
        try (OutputStream os = resp.getOutputStream()) {
            ImageIO.write(findAvatar(req), "png", os);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private BufferedImage findAvatar(HttpServletRequest req) {
        BufferedImage image = null;
        User user = (User) req.getSession().getAttribute(WebConstants.USER);
        try {
        for (File file : Objects.requireNonNull(new File(Paths.IMAGES_PATH).listFiles())) {
            if (user.getEmail().equals(FilenameUtils.removeExtension(file.getName()))) {
                    image = ImageIO.read(file);
                    return image;

            }
        }
        image = ImageIO.read(new File(Paths.DEFAULT_IMAGE_PATH));
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
        return image;
    }

}
