<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
         <c:forEach items="${movieList}" var="entry">
            <div class="card" style="">
				<center><iframe width="340" height="250" src="https://www.youtube.com/embed/${entry.getLink()}" frameborder="0" gesture="media" allow="encrypted-media" allowfullscreen></iframe></center>
                <div class="card-body">
                    <h4 class="card-title">${entry.getName()}</h4>
                    <p class="card-text">${entry.getDescription()}</p>
                </div>
            </div>   
		</c:forEach>
    </div>
</div>

<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Nasze kina</h2>
        </header>
        <div class="row">
           	 <c:forEach items="${cinemasList}" var="entry">
            <div class="col-md-2 text-center align-self-center" style="">
                <p class="mb-5"><strong>${entry.getName()}</strong>
                    <br>
                    <a href="https://goo.gl/maps/AUq7b9W7yYJ2" class="text-white" target="_blank"><i
                            class="fa d-inline mr-3 fa-map-marker text-primary"></i>${entry.getCity()} ${entry.getStreet()}</a>
                    <br>
                    <a href="mailto:info@pingendo.com" class="text-white"><i
                            class="fa d-inline mr-3 fa-envelope-o text-primary"></i>${entry.getEmail()}</a>
                </p>
            </div>     
				</c:forEach>
        </div>
    </div>
</div>
