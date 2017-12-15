<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="py-5 bg-dark text-white gradient-overlay">
	<div class="container">
		<div class="row">
	   	<div class="col-md-9 text-center align-self-center" style="">
		  <div class="horizontalScrollList">
		    <ul class="list-inline" >
		    	<c:forEach items="${daysList}" var="entry">
			      <li style="display: inline-block"><a href="reservationCreator?selectedDay=${entry}" class="horizontalScrollItem list-group-item">${entry}</a></li>
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
	  				 	${repertoireMovies.get(entry.getKey()).getName()}
	  				 	<c:forEach items="${entry.getValue()}" var="hourEntry">
	  				 		<a href="reservationCreator?selectedHourRoom=${hourEntry.getKey()}r${hourEntry.getValue().getId()}&selectedMovie=${entry.getKey()}">${hourEntry.getKey()}</a>
	  				 	</c:forEach>
					</c:forEach>
				</div>
			 </div>
      	</div>
    </div>
</div>