<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
    
    <div class="inbox-body col-md-9 col-md-offset-2">
                <div class="row">
                    <div class="col-md-12">
                        <div class="container">
                            <form action="makeOrder" method="post">
                                <button type="submit" class="btn btn-success">
                                    Make an order
                                </button>
                            </form>
                            <form action="clearCart" method="post">
                                <button class="btn btn-danger" >
                                    Clear the cart
                                </button>
                            </form>
                        </div>
                        <br>
                        <table class="table table-inbox table-hover">
                            <tbody>
                            <div class="method">
                                <div class="row margin-0 list-header hidden-sm hidden-xs">
                                    <div class="col-md-3">
                                        <div class="header">
                                            Name
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="header">
                                            Price
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="header">
                                            Category
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="header">
                                            Manufacturer
                                        </div>
                                    </div>
                                    <div class="col-md-1">
                                        <div class="header">
                                            Quantity
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <div class="header">
                                            Remove instrument
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${not empty sessionScope.cart.getAllInstruments()}">
                                    <c:forEach items="${sessionScope.cart.getAllInstruments()}" var="instrument">
                                        <form action="removeInstrumentFromCart" method="post">
                                        <input type="hidden" name="insName" value="${instrument.getName()}">    
                                            <div class="row margin-0">
                                                <div class="col-md-3">
                                                    <div class="cell">
                                                        <code>${instrument.getName()}</code>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="cell">
                                                            ${instrument.getPrice()}
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="cell">
                                                            ${instrument.getCategory()}
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                    <div class="cell">
                                                            ${instrument.getManufacturer()}
                                                    </div>
                                                </div>
                                                <div class="col-md-1">
                                                    <div class="cell">
                                                        <select class="form-control">
                                                            <option value="1" selected="selected">1</option>
                                                            <option value="2">2</option>
                                                            <option value="3">3</option>
                                                            <option value="4">4</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-2">
                                                        <div class="cell">
                                                            <button type="submit" class="btn btn-danger">
                                                                Remove instrument        
                                                            </button>
                                                        </div>  
                                                </div>
                                            </div>      
                                        </form>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${empty sessionScope.cart.getAllInstruments()}">
                                    <h4>Instruments not found</h4>
                                </c:if>
                            </div>
                            </tbody>
                        </table>
                        <br>
                    </div>
                </div>
                <br>
            </div>
    </%@include>
</body>