package validator;

import constants.WebConstants;

import javax.servlet.http.Part;
import java.util.*;

public class ImageValidator {

    private List<String> imageFormats;

    public ImageValidator() {
        this.imageFormats = new ArrayList<>();
        imageFormats.add("jpeg");
        imageFormats.add("png");
    }

    public Map<String, String> validate(Part part, long avatarSize) {
        Map<String, String> errors = new HashMap<>();
        String contentType = part.getContentType();
        if (part.getSize() > avatarSize) {
            errors.put(WebConstants.AVATAR, WebConstants.AVATAR_OVERLOAD);
        }
        if (!imageFormats.contains(contentType.split("/")[1]) || !contentType.startsWith("image")) {
            errors.put(WebConstants.AVATAR, WebConstants.WRONG_AVATAR_FORMAT);
        }
        return errors;
    }
}
