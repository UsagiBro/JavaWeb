<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<br>
<br>
<br>
<div class="col-xs-10">
    <div id="tb-testimonial" class="testimonial testimonial-danger">
        <div class="testimonial-section">
            ${sessionScope.error}
        </div>
        <div class="testimonial-desc">
            <img src="assets/images/error_symbol.png">
            <div class="testimonial-writer">
                <div class="testimonial-writer-name">Database error, please try again later(</div>
            </div>
        </div>
    </div>
</div>
</body