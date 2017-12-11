<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">    
    <link rel="stylesheet" href="resources/CSS/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/style.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/Main.css" type="text/css">
    <script src="resources/JS/bootstrap.js" type="text/javascript"></script>
</head>

<body>
<nav class="navbar navbar-expand-md navbar-dark sticky-top banner">
    <div class="container">
        <a class="navbar-brand logo" href="#">
            <img style="max-height: 60px" src="resources/Images/logo.png">
            Cinema Smile
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">CINEMA</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">REPERTUAR<i class=""></i>
                        <br> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">PROMO</a>
                </li>
                 <sec:authorize access="isAuthenticated()">
	                 <li class="nav-item">
	                    <a class="nav-link text-white" href="adminManage">MANAGE</a>
	              	 </li>
                 </sec:authorize>
            </ul>
            <sec:authorize access="isAuthenticated()">
				<!-- For login user -->
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
				<form action="${logoutUrl}" method="post" id="logoutForm">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h2>
						User : ${pageContext.request.userPrincipal.name} | 
					</h2>
				</c:if>
				<a class="btn navbar-btn ml-2 text-white btn-secondary" href="logoutProcess"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Log out</a>
			</sec:authorize>
			<sec:authorize access="isAnonymous()">
          	  <a class="btn navbar-btn ml-2 text-white btn-secondary" data-toggle="modal" data-target="#loginPopUp"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Sign in</a>
            </sec:authorize>
        </div>
    </div>
</nav>
<div class="modal fade" id="loginPopUp" role="dialog">
   <div class="modal-dialog modal-sm">
     <div class="modal-content">
     	<%@include  file="login.jsp" %>
     </div>
   </div>
 </div>
<div class="text-center bg-secondary text-white gradient-overlay">
    <div class="carousel slide" style="" data-ride="carousel" id="carouselArchitecture">
        <ol class="carousel-indicators">
            <li data-target="#carouselArchitecture" data-slide-to="0" class=""><i></i></li>
            <li data-target="#carouselArchitecture" data-slide-to="1" class="active"><i></i></li>
            <li data-target="#carouselArchitecture" data-slide-to="2" class=""><i></i></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <div class="carousel-item">
                <img class="d-block img-fluid w-100" src="resources/Images/m1.jpg" data-holder-rendered="true"></div>
            <div class="carousel-item active">
                <img class="d-block img-fluid w-100" src="resources/Images/m2.jpg" data-holder-rendered="true"></div>
        </div>
    </div>
</div>
<div class="py-5 bg-dark text-white">
    <div class="container">
        <header>
            <h2>Najnowsze filmy</h2>
        </header>
        <div class="row">
            <div class="card">
                <img class="card-img-top" src="resources/Images/listyDoM.jpg" alt="Listy do M 3" />
                <div class="card-body">
                    <h4 class="card-title">Listy do M 3</h4>
                    <p class="card-text">Losy kilkorga bohaterów ponownie przeplatają się w Wigilię Bożego Narodzenia</p>
                </div>
            </div>
            <div class="card">
                <img class="card-img-top" src="resources/Images/emotki.jpg" alt="Emotki" />
                <div class="card-body">
                    <h4 class="card-title">Emotki.Film</h4>
                    <p class="card-text">Miasto Tekstopolis zamieszkują  emotki, gdzie każda z nich wyraża jedną konkretną emocję. Z wyjątkiem Minka, co może doprowadzić do katastrofy. </p>
                </div>
            </div>
            <div class="card">
                <img class="card-img-top" src="resources/Images/zlemamuski.jpg" alt="Zle mamuski 2" />
                <div class="card-body">
                    <h4 class="card-title">Złe mamuśki 2</h4>
                    <p class="card-text">Losy czterech kobiet pracujących w służbie medycznej splatają się w szpitalu, gdzie dochodzi do wielu nielegalnych przedsięwzięć.</p>
                </div>
            </div>

        </div>
    </div>
</div>
</div>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Nasze kina</h2>
        </header>
        <div class="row">
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>Our Cinema 1 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Wiejska 555, Warsaw</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema1.com</a>
                </p>
                <p class="mb-5"><strong>Our Cinema 2 Inc.</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>Kościuszki 983, Cracow</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@cinema2.com</a>
                </p>
            </div>
        </div>
    </div>
</div>

<div class="footer text-white">
    <hr  />
    <div class="container">
        <div class="row">
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-white">MagicCinema</h2>
                <p class="text-white">Some usefull static interesting description of company</p>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-white">Mapsite</h2>
                <ul class="list-unstyled">
                    <a href="#" class="text-white">CINEMA</a>
                    <br>
                    <a href="#" class="text-white">REPERTUAR</a>
                    <br>
                    <a href="#" class="text-white">PROMO</a>
                </ul>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4">Contact</h2>
                <p>
                    <a href="tel:+246 - 542 550 5462" class="text-white"><i
                            class="fa d-inline mr-3 fa-phone text-primary"></i>+246 - 542 550 5462</a>
                </p>
                <p>
                    <a href="mailto:info@magicinema.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>info@magiccinema.com</a>
                </p>
                <p>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>somewhere over the rainbow</a>
                </p>
            </div>
            <div class="p-4 col-md-3">
                <h2 class="mb-4 text-light">Subscribe</h2>
                <form>
                    <fieldset class="form-group text-white"><label for="exampleInputEmail1">Get our newsletter</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                    </fieldset>
                    <button type="submit" class="btn navbar-btn ml-2 text-white btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>

</html>