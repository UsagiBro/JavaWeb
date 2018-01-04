<%@ tag body-content="empty" language="java" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<c:choose>
  <c:when test="${empty sessionScope.user}">
    <form action="authorization" method="post">
    <h3 class="validation-above">
        <strong>${sessionScope.wrong_authorization}</strong>
    </h3>
            <div class="form-group">
                <label for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp"
                    placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We will never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <div class="row">
                <div class="col">
                    <button type="submit" class="btn btn-block btn-success">
                        Submit
                    </button>
                </div>
                <div class="col">
                    <a href="registration" class="btn btn-block btn-primary">Registration</a>
                </div>
            </div>
        </form>
  </c:when>
  <c:otherwise>
    <form action="/cabinet">
        <div class="row login_box">
        	    <div class="col-md-12 col-xs-12" align="center">
                    <div class="outter"><img src="/avatarServlet" class="image-circle"/></div>
                    <h1>Hi ${sessionScope.user.getName()}</h1>
                    <h1>${sessionScope.user.getEmail()}</h1>
        	    </div>
                <div class="col-md-12 col-xs-12 login_control">
                        <div align="center">
                             <button class="btn btn-orange">Go to cabinet</button>
                        </div>
                </div>
        </div>
    </form>
  </c:otherwise>
</c:choose>