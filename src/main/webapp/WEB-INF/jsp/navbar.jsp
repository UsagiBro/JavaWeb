<!-- Header -->
<header id="header">
    <h1><a href="index.html">Guitarzzz</a></h1>
    <nav id="nav">
        <ul>
            <li><a href="index.html">Home</a></li>
            <li><a href="generic.html">Generic</a></li>
            <li><a href="elements.html">Elements</a></li>
            <li>
                <c:if test="${not empty sessionScope.user}">
                    <a href="logout" class="button special">Logout</a>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <a href="authorization" class="button special">Sign Up</a>
                </c:if>
            </li>
        </ul>
    </nav>
</header>
