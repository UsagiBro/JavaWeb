<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
	<div class="row login_box">
	    <div class="col-md-12 col-xs-12" align="center">
            <div class="outter"><img src="/avatarServlet" class="image-circle"/></div>
            <h1>Hi ${sessionScope.user.getName()}</h1>
	    </div>
        <div class="col-md-6 col-xs-6 follow line" align="center">
            <h3>
                  <br/> <span></span>
            </h3>
        </div>
        <div class="col-md-6 col-xs-6 follow line" align="center">
            <h3>
                  <br/> <span></span>
            </h3>
        </div>
        <div class="col-md-12 col-xs-12 login_control">
                <div class="control">
                    <div class="label">Email Address</div>
                    <input type="text" class="form-control" value=""/>
                </div>
                <div align="center">
                     <button class="btn btn-orange">BUY</button>
                </div>
        </div>
    </div>
</div>
</body>