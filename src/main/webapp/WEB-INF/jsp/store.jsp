<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="navbar.jsp" %>
        <div class="mail-box">
            <aside class="sm-side">
                <div class="user-head">
                    <c:if test="${not empty sessionScope.user}">
                    <h3>Hello, ${sessionScope.user.name} ${sessionScope.user.surname}</h3>
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        <h1>GO AND REGISTER!</h1>
                    </c:if>
                </div>
                <div class="inbox-body">
                    <form action="filterInstruments">
                        <h5>Instruments on page</h5>
                        <select id="selectbasic" name="instrumentsCount" class="form-control col-md-3">
                            <option value="4">4</option>
                            <option value="6">6</option>
                        <select>
						<div class="row">
							<div class="col-md-6">
								<h5>Filter by category</h5>
								<select name="filterCategory" class="form-control">
									<option value="">All</option>
									<c:forEach items="${requestScope.categoriesList}" var="category">
									<option value="${category.getId()}">${category.getLabel()}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-6">
								<h5>Filter by manufacturer</h5>
								<select name="filterManufacturer" class="form-control">
									<option value="">All</option>
									<c:forEach items="${requestScope.manufacturerList}" var="manufacturer">
                                    <option value="${manufacturer.getId()}">${manufacturer.getTitle()}</option>
                                    </c:forEach>
								</select>
							</div>
						</div> 
						<br>
						<div class="row">
							<h4 class="col-md-offset-2 col-md-3">Sort by: </h4>
							<select name="sortValue" class="col-md-7 form-control">
							    <option value="">None</option>
								<option value="price">Price</option>
								<option value="ins_name">Name</option>
							</select>						
						</div>						
						<br>
						<div class="row">
							<h4 class="col-md-offset-2 col-md-3">Sort direction: </h4>
							<select name="sortDirection" class="col-md-7 form-control">
								<option value="">Forward</option>
								<option value="sortBackward">Backward</option>
							</select>
						</div>
						<button type="submit" class="btn btn-compose-info">
                            Show instruments
                        </button>						
                    </form>				
                    <form action="">
                        <input type="hidden">
                        <button data-toggle="modal" title="Compose" class="btn btn-compose">
                            Add new instrument to storage
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
                        </div>
                    </div>
                    <br>
                </div>
            </aside>
        </div>
</body>