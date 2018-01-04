package web.avatar;

import constants.WebConstants;
import validator.ImageValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AvatarLoader {

    private long avatarSize;

    public AvatarLoader(long avatarSize) {
        this.avatarSize = avatarSize;
    }

    public Map<String, String> loadAvatarFromRequest(HttpServletRequest req) {
        Map<String, String> errors = new HashMap<>();
        ImageValidator validator = new ImageValidator();
        String filename = req.getParameter(WebConstants.EMAIL);
        final String SAVE_DIR = "src";
        String appPath = req.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        try {
            Part part = req.getPart("avatar");
            if (part.getSize() != 0) {
                errors.putAll(validator.validate(part, avatarSize));
                File fileSaveDir = new File(savePath);
                if (!fileSaveDir.exists()) {
                    fileSaveDir.mkdir();
                }
                filename = new File(filename).getName() + "." + part.getContentType().split("/")[1];
                part.write(savePath + File.separator + filename);
            }
        } catch (IOException | ServletException e) {
            errors.put(WebConstants.AVATAR, WebConstants.FILE_IS_INVALID);
        }
        return errors;
    }
}
