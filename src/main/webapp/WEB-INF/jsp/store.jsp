<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
    <c:if test="${not empty sessionScope.user}">
        <div class="mail-box">
            <aside class="sm-side">
                <div class="user-head">
                    <h3>Hello, ${sessionScope.user.name} ${sessionScope.user.surname}</h3>
                </div>
                <div class="inbox-body">
                    <form action="">
                        <h5>Instruments on page</h5>
                        <select id="selectbasic" name="selectbasic" class="form-control col-md-3">
                            <option value="4">4</option>
                            <option value="6">6</option>
                        <select>
                    </form>
                    <form action="filter">
                        <input type="hidden" name="instrumentsBean" value="${requestScope.instrumentsBean}">
						<div class="row col-md-12">
							<div class="col-md-6">
								<h5>Filter by category</h5>
								<select id="selectbasic" name="category" class="form-control">
									<option value="">All</option>
									<option value="Guitar">Guitar</option>
									<option value="Bass">Bass</option>
									<option value="Drums">Drums</option>
								<select>
							</div>
							<div class="col-md-6">
								<h5>Filter by manufacturer</h5>
								<select id="selectbasic" name="manufacturer" class="form-control">
									<option value="">All</option>
									<option value="Fender">Fender</option>
									<option value="Gibson">Gibson</option>
									<option value="Tama">Tama</option>
								<select>
							</div>
						</div> 
						<br>
                        <div>
							<button class="btn btn-compose-info" type="submit">
								Filter items
							</button>
						</div>
                    </form>
                    <form action="">
                        <input type="hidden" name="command" value="sortPByDateUp">
                        <button class="btn btn-compose-info">
                            Add new instrument to storage
                        </button>
                    </form>
                    <form action="">
                        <input type="hidden" name="command" value="sortPByDateDown">
                        <button data-toggle="modal" title="Compose" class="btn btn-compose-info">
                            
                        </button>
                    </form>
                    <form action="">
                        <input type="hidden" name="command" value="toDeleteUnsentPayments">
                        <button data-toggle="modal" title="Compose" class="btn btn-compose">
                            
                        </button>
                    </form>
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
                                </div>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <br>
                </div>
            </aside>
        </div>
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <h1>GO AND REGISTER!</h1>
    </c:if>
</body>