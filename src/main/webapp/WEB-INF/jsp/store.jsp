<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>

<form action="store">
    <div class="mail-box">
        <aside class="sm-side">
            <div class="user-head">
                <c:if test="${not empty sessionScope.user}">
                    <h3>Hello, ${sessionScope.user.name} ${sessionScope.user.surname}</h3>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <h3>GO AND REGISTER!</h3>
                </c:if>
            </div>
            <div class="inbox-body">
                <h5>Max instruments on page</h5>
                <select id="selectbasic" name="instrumentCount" class="form-control col-md-3">
                    <c:choose>
                        <c:when test="${filterBean.instrumentCount ne null}">
                            <c:if test="${filterBean.instrumentCount eq '3'}">
                                <option value="3" selected="selected">3</option>
                                <option value="6">6</option>
                                <option value="12">12</option>
                                <option value="18">18</option>
                            </c:if>
                            <c:if test="${filterBean.instrumentCount eq '6'}">
                                <option value="3">3</option>
                                <option value="6" selected="selected">6</option>
                                <option value="12">12</option>
                                <option value="18">18</option>
                            </c:if>
                            <c:if test="${filterBean.instrumentCount eq '12'}">
                                <option value="3">3</option>
                                <option value="6">6</option>
                                <option value="12" selected="selected">12</option>
                                <option value="18">18</option>
                            </c:if>
                            <c:if test="${filterBean.instrumentCount eq '18'}">
                                <option value="3">3</option>
                                <option value="6">6</option>
                                <option value="12">12</option>
                                <option value="18" selected="selected">18</option>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <option value="3">3</option>
                            <option value="6">6</option>
                            <option value="12">12</option>
                            <option value="18" selected="selected">18</option>
                        </c:otherwise>
                    </c:choose>
                </select>
                <br>
                <div class="row">
                    <div class="col-md-6">
                        <h5>Filter by category</h5>
                        <select name="filterCategory" class="form-control">
                            <option value="">All</option>
                            <c:forEach items="${requestScope.categoriesList}" var="category">
                                <c:choose>
                                    <c:when test="${category.id eq filterBean.categoryFilter}">
                                        <option value="${category.id}" selected="selected">
                                                ${category.label}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.id}">${category.label}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <h5>Filter by manufacturer</h5>
                        <select name="filterManufacturer" class="form-control">
                            <option value="">All</option>
                            <c:forEach items="${requestScope.manufacturerList}" var="manufacturer">
                                <c:choose>
                                    <c:when test="${manufacturer.id eq filterBean.manufacturerFilter}">
                                        <option value="${manufacturer.id}" selected="selected">
                                                ${manufacturer.title}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${manufacturer.getId()}">${manufacturer.title}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br>
                <div class="row">
                    <h4 class="col-md-offset-2 col-md-3">Sort by: </h4>
                    <select name="sortValue" class="col-md-7 form-control">
                        <option value="">None</option>
                        <c:choose>
                            <c:when test="${filterBean.sort ne ''}">
                                <c:if test="${filterBean.sort eq 'price'}">
                                    <option value="ins_name">Name</option>
                                    <option value="price" selected="selected">Price</option>
                                </c:if>
                                <c:if test="${filterBean.sort eq 'ins_name'}">
                                    <option value="ins_name" selected="selected">Name</option>
                                    <option value="price">Price</option>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <option value="ins_name">Name</option>
                                <option value="price">Price</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <br>
                <div class="row">
                    <h4 class="col-md-offset-2 col-md-3">Sort direction: </h4>
                    <select name="sortDirection" class="col-md-7 form-control">
                        <option value="">Forward</option>
                        <c:choose>
                            <c:when test="${'sortBackward' eq filterBean.sortDirection}">
                                <option value="sortBackward" selected="selected">Backward</option>
                            </c:when>
                            <c:otherwise>
                                <option value="sortBackward">
                                    Backward
                                </option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <button type="submit" class="btn btn-compose-info">
                    Show instruments
                </button>
                <br>
                <br>
                <button data-toggle="modal" title="Compose" class="btn btn-compose">
                    Add new instrument to storage
                </button>
            </div>
        </aside>
        <aside class="lg-side">
            <div class="inbox-head">
                <h3>List of instruments</h3>
            </div>
            <div class="inbox-body">
                <div class="row">
                    <div class="col-md-12">
                        <h5>
                        </h5>
                        <table class="table table-inbox table-hover">
                            <tbody>
                            <div class="method">
                                <div class="row margin-0 list-header hidden-sm hidden-xs">
                                    <div class="col-md-3">
                                        <div class="header">
                                            Name
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="header">
                                            Price
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="header">
                                            Category
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="header">
                                            Manufacturer
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${not empty requestScope.instrumentBean.getInstruments()}">
                                    <c:forEach items="${requestScope.instrumentBean.getInstruments()}" var="instrument">
                                        <div class="row margin-0">
                                            <div class="col-md-3">
                                                <div class="cell">
                                                    <code>${instrument.getName()}</code>
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="cell">
                                                        ${instrument.getPrice()}
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="cell">
                                                        ${instrument.getCategory()}
                                                </div>
                                            </div>
                                            <div class="col-md-3">
                                                <div class="cell">
                                                        ${instrument.getManufacturer()}
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty requestScope.instrumentBean.getInstruments()}">
                                    <h4>Instruments not found</h4>
                                </c:if>
                            </div>
                            </tbody>
                        </table>
                        <br>
                        <div class="container">
                            <ul class="pagination">
                                <li>
                                    <%--<input type="submit" class="btn btn-info" value="previous"--%>
                                    <%--<c:if test="${requestScope.filterBean.currentPage <= 1}">--%>
                                    <%--disabled="disabled"--%>
                                    <%--</c:if>--%>
                                    <%--href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${filterBean.currentPage - 1}">--%>

                                    <a type="submit" class="btn btn-info
                                    <c:if test="${requestScope.filterBean.currentPage <= 1}">
                                                disabled
                                    </c:if>
                                    "
                                       href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${filterBean.currentPage - 1}">
                                        previous
                                    </a>
                                </li>
                                <c:forEach begin="1" end="${requestScope.pagesCount}" var="i">
                                    <li>
                                            <%--<input type="submit" class="btn btn-info" value="${i}"--%>
                                            <%--href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${i}">--%>

                                        <a type="submit" name="page" class="btn btn-info"
                                           href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${i}">
                                                ${i}
                                        </a>
                                    </li>
                                </c:forEach>
                                <li>
                                    <%--<input type="submit" class="btn btn-info" value="next"--%>
                                    <%--<c:if test="${requestScope.filterBean.currentPage >= requestScope.pagesCount}">--%>
                                    <%--disabled="disabled"--%>
                                    <%--</c:if>--%>
                                    <%--href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${filterBean.currentPage + 1}">--%>
                                    <a type="submit" class="btn btn-info
                                    <c:if test="${requestScope.filterBean.currentPage >= requestScope.pagesCount}">
                                    disabled
                                    </c:if>
                                    "
                                    href="store?instrumentCount=${param["instrumentCount"]}&filterCategory=${param["filterCategory"]}&filterManufacturer=${param["filterManufacturer"]}&sortValue=${param["sortValue"]}&sortDirection=${param["sortDirection"]}&currentPage=${filterBean.currentPage + 1}">
                                    next
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <br>
            </div>
        </aside>
    </div>
</form>
</body>