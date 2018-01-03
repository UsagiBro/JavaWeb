<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container col-md-4">
    <form action="authorization" method="post">
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
</div>
</body>
