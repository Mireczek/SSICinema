<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Manage cinemas</h2>
        </header>
        <div class="row">
            <div class="list-group scrollable">
            	<c:forEach items="${cinemasList.keySet()}" var="entry">
  				 	<a href="reservationSelectMovie?selectedCinema=${entry}" class="list-group-item">${entry}</a>
				</c:forEach>
			</div>
      </div>
    </div>
</div>