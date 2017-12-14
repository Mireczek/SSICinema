<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="py-5 bg-dark text-white gradient-overlay">
	<div class="container">
	<div class="row">
	  <div class="scroller scroller-left"><i class="glyphicon glyphicon-chevron-left"></i></div>
	  <div class="scroller scroller-right"><i class="glyphicon glyphicon-chevron-right"></i></div>
	   	<div class="col-md-9 text-center align-self-center" style="">
		  <div class="wrapper">
		    <ul class="nav nav-tabs list" id="myTab">
		    	<c:forEach items="${daysList}" var="entry">
			      <li><a href="reservationCreator?selectedDay=${entry}">${entry}</a></li>
	  			</c:forEach>
		  	</ul>
  		  </div>
		</div>
		<div class="col-md-2 text-center align-self-center" style="">
			<c:choose>
			    <c:when test="${chooseSeats!= null && chooseSeats ==true}">
					<a href="reservationCreatorSeatsSelection">Select seats</a>
			    </c:when>    
			    <c:otherwise>
			       Choose cinema, day, movie and hour to select seats.
			    </c:otherwise>
			</c:choose>
	 	</div>
	 	</div>
	</div>
    <div class="container">
        <div class="row">
         <div class="col-md-3 text-center align-self-center" style="">
            <div class="list-group scrollable">
            	<c:forEach items="${cinemasList}" var="entry">
  				 	<a href="reservationCreator?selectedCinema=${entry.getId()}" class="list-group-item">${entry.getName()}</a>
				</c:forEach>
			</div>
			</div>
			 <div class="col-md-9 text-center align-self-center" style="">
				 <div class="list-group scrollable">
	            	<c:forEach items="${repertoire}" var="entry">
	  				 	${entry.ketKey().getName()}
	  				 	<c:forEach items="${repertoire.getValue()}" var="hourEntry">
	  				 		<a href="reservationCreator?selectedHour=${hourEntry}&selectedMovie=${entry.ketKey().getId()}">${hourEntry}</a>
	  				 	</c:forEach>
					</c:forEach>
				</div>
			 </div>
      	</div>
    </div>
</div>