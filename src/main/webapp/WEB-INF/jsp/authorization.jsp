<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<head>
    <meta charset="UTF-8">
    <title>Authentication</title>
    <link href="assets/bootstrap/bootstrap.css" rel="stylesheet">
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/skel.min.js"></script>
    <script src="assets/js/skel-layers.min.js"></script>
    <script src="assets/js/init.js"></script>
    <link rel="stylesheet" href="assets/css/skel.css"/>
    <link rel="stylesheet" href="assets/css/style.css"/>
    <link rel="stylesheet" href="assets/css/style-xlarge.css"/>
</head>
<body>
<header id="header">
    <h1><a href="index.html">Guitarzzz</a></h1>
    <nav id="nav">
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="generic.html">Generic</a></li>
            <li><a href="elements.html">Elements</a></li>
            <li><a href="authorization.html" class="button special">Sign Up</a></li>
        </ul>
    </nav>
</header>
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
