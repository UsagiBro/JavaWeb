<%@ tag body-content="empty" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<div class="form-group">
            <img src="/captchaServlet">
                <input type="hidden" name="captchaId" value="${captchaId}">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="captchaVal"
            id="captchaVal" placeholder="Enter captcha here" required>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.captcha}</strong>
            </p>
</div>