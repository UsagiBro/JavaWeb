<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jspf/taglib.jspf" %>
<%@include file="/WEB-INF/jspf/head.jspf" %>
<body>
<%@include file="/WEB-INF/jsp/navbar.jsp" %>
<!-- Banner -->
<section id="banner">
		<c:if test="${not empty sessionScope.user}">
            <h2>Greetings! ${sessionScope.user.name}</h2>
			<p>Want to start shopping?</p>
			<ul class="actions">
				<li>
					<form action="cabinet">
						<div class="col">
							<button class="button big" type="submit">Into cabinet</button>
						</div>
					</form>
				</li>
			</ul>
        </c:if>
        <c:if test="${empty sessionScope.user}">
            <h2>Hoi! This is Guitarzzz.</h2>
			<p>The largest online music shoppu in da world.</p>
			<ul class="actions">
				<li>
					<form action="registration">
						<div class="col">
							<button class="button big" type="submit">Register now</button>
						</div>
					</form>
				</li>
			</ul>
        </c:if>
</section>

<!-- One -->
<section id="one" class="wrapper style1 special">
    <div class="container">
        <header class="major">
            <h2>Our beautiful list of goods</h2>
            <p>See the best instruments that can be found in our world!</p>
        </header>
        <div class="row">
            <div class="col-md-3">
                <section class="box">
                    <img src="assets/images/sturatocasta.jpg" class="img-responsive" width="300" height="300">
                    <h3>Fender Stratocaster 300$</h3>
                    <p>It's a fender, guys, Fender!.</p>
                </section>
            </div>
            <div class="col-md-3">
                <section class="box">
                    <img src="assets/images/telecasta.jpg" class="img-responsive" width="300" height="300">
                        <h3>Fender Telecaster 400$</h3>
                    <p>It's also Fender, but more black-white than white-black</p>
                </section>
            </div>
            <div class="col-md-3">
                <section class="box">
                    <img src="assets/images/mustang.jpg" class="img-responsive" width="300" height="300">
                        <h3>Fender Mustang 350$</h3>
                    <p>I's just mustang, like horse, but guitar</p>
                </section>
            </div>
        </div>
    </div>
</section>

<!-- Three -->
<section id="three" class="wrapper style3 special">
    <div class="container">
        <header class="major">
            <h2>Consectetur adipisicing elit</h2>
            <p>Lorem ipsum dolor sit amet. Delectus consequatur, similique quia!</p>
        </header>
    </div>
    <div class="container 50%">
        <form action="#" method="post">
            <div class="row uniform">
                <div class="6u 12u$(small)">
                    <input name="name" id="name" value="" placeholder="Name" type="text">
                </div>
                <div class="6u$ 12u$(small)">
                    <input name="email" id="email" value="" placeholder="Email" type="email">
                </div>
                <div class="12u$">
                    <textarea name="message" id="message" placeholder="Message" rows="6"></textarea>
                </div>
                <div class="12u$">
                    <ul class="actions">
                        <li><input value="Send Message" class="special big" type="submit"></li>
                    </ul>
                </div>
            </div>
        </form>
    </div>
</section>

<!-- Footer -->
<footer id="footer">
    <div class="container">
        <section class="links">
            <div class="row">
                <section class="3u 6u(medium) 12u$(small)">
                    <h3>Lorem ipsum dolor</h3>
                    <ul class="unstyled">
                        <li><a href="#">Lorem ipsum dolor sit</a></li>
                        <li><a href="#">Nesciunt itaque, alias possimus</a></li>
                        <li><a href="#">Optio rerum beatae autem</a></li>
                        <li><a href="#">Nostrum nemo dolorum facilis</a></li>
                        <li><a href="#">Quo fugit dolor totam</a></li>
                    </ul>
                </section>
                <section class="3u 6u$(medium) 12u$(small)">
                    <h3>Culpa quia, nesciunt</h3>
                    <ul class="unstyled">
                        <li><a href="#">Lorem ipsum dolor sit</a></li>
                        <li><a href="#">Reiciendis dicta laboriosam enim</a></li>
                        <li><a href="#">Corporis, non aut rerum</a></li>
                        <li><a href="#">Laboriosam nulla voluptas, harum</a></li>
                        <li><a href="#">Facere eligendi, inventore dolor</a></li>
                    </ul>
                </section>
                <section class="3u 6u(medium) 12u$(small)">
                    <h3>Neque, dolore, facere</h3>
                    <ul class="unstyled">
                        <li><a href="#">Lorem ipsum dolor sit</a></li>
                        <li><a href="#">Distinctio, inventore quidem nesciunt</a></li>
                        <li><a href="#">Explicabo inventore itaque autem</a></li>
                        <li><a href="#">Aperiam harum, sint quibusdam</a></li>
                        <li><a href="#">Labore excepturi assumenda</a></li>
                    </ul>
                </section>
                <section class="3u$ 6u$(medium) 12u$(small)">
                    <h3>Illum, tempori, saepe</h3>
                    <ul class="unstyled">
                        <li><a href="#">Lorem ipsum dolor sit</a></li>
                        <li><a href="#">Recusandae, culpa necessita nam</a></li>
                        <li><a href="#">Cupiditate, debitis adipisci blandi</a></li>
                        <li><a href="#">Tempore nam, enim quia</a></li>
                        <li><a href="#">Explicabo molestiae dolor labore</a></li>
                    </ul>
                </section>
            </div>
        </section>
        <div class="row">
            <div class="8u 12u$(medium)">
                <ul class="copyright">
                    <li>&copy; Untitled. All rights reserved.</li>
                    <li>Design: <a href="http://templated.co">TEMPLATED</a></li>
                    <li>Images: <a href="http://unsplash.com">Unsplash</a></li>
                </ul>
            </div>
            <div class="4u$ 12u$(medium)">
                <ul class="icons">
                    <li>
                        <a class="icon rounded fa-facebook"><span class="label">Facebook</span></a>
                    </li>
                    <li>
                        <a class="icon rounded fa-twitter"><span class="label">Twitter</span></a>
                    </li>
                    <li>
                        <a class="icon rounded fa-google-plus"><span class="label">Google+</span></a>
                    </li>
                    <li>
                        <a class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>

</body>
</html>