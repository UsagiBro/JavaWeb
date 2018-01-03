<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
<div class="container col-md-4">
    <form id="registrationForm" action="registration" enctype="multipart/form-data" method="post">
        <h3 class="validation-user-exists">
             <strong>${sessionScope.user_exists}</strong>
        </h3>
        <div class="form-group">
            <label for="name">Name</label>
            <input  class="form-control" id="name" name="name" value="${sessionScope.name}"
             placeholder="Enter your name" required>
            <p id="nameErr" class="validation-message">
                <strong>Name can contain only letters and be longer than 1 symbol</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.name}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="surname">Surname</label>
            <input  class="form-control" id="surname" name="surname" value="${sessionScope.surname}"
            placeholder="Enter your surname" required>
            <p id="surnameErr" class="validation-message">
                <strong>Surname can contain only letters and be longer than 1 symbol</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.name}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="email">Email address</label>
            <input  class="form-control" id="email" name="email" value="${sessionScope.email}"
             aria-describedby="emailHelp"
                    placeholder="Enter email" required>
            <p id="emailErr" class="validation-message">
                <strong>Type valid email</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.email}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password"
             placeholder="Enter password" required>
            <p id="passwordErr" class="validation-message">
                <strong>Password can consist of letters and numbers and must be longer than 4 symbols</strong>
            </p>
			<p class="validation-message-s">
                <strong>${sessionScope.errors.password}</strong>
            </p>
        </div>
        <div class="form-group">
            <label for="password">Repeat password</label>
            <input type="password" class="form-control" name="passwordRepeat"
             id="passwordRepeat" placeholder="Repeat password" required>
            <p id="passwordRepeatErr" class="validation-message">
                <strong>Passwords dont match</strong>
            </p>
            <p class="validation-message-s">
                <strong>${sessionScope.errors.passwordRepeat}</strong>
            </p>
        </div>
        <div class="form-group">
            <input class="btn btn-success" type="file" name="avatar" accept="image/*" />
            <p class="validation-message-s">
                <strong>${sessionScope.errors.avatar}</strong>
            </p>
        </div>
        <div class="6u 12u$(3)">
            <input type="checkbox" id="news" name="news">
            <label for="news">Send me site news</label>
        </div>
        <div class="6u$ 12u$(3)">
            <input type="checkbox" id="newProducts" name="newProducts">
            <label for="newProducts">Get info about new products</label>
        </div>

        <cpt:captcha/>

        <div class="row submit-row">
            <button type="submit" class="btn btn-block">
                Submit
            </button>
        </div>
    </form>
</div>
</body>