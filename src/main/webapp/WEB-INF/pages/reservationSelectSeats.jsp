<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
    <c:choose>
	    <c:when test="${selectedSeats.isEmpty()}">
	     	    Select seat
	    </c:when>    
	    <c:otherwise>
	       <a href="showFinalizeReservation" >Finalize reservation</a>
	    </c:otherwise>
    </c:choose>
        <div class="row">
            <div class="">
            	<c:forEach items="${seatsDefinition}" var="column">
  				 	<c:forEach items="${column}" var="seat">
	  				 	<c:choose>
						    <c:when test="${!seat.isLocked()}">
							    <c:choose>
								    <c:when test="${selectedSeats.contains(seat.getPosition())}">
								     	<a href="reservationCreatorSeatsSelection?selectedSeat=${seat.getRow()}:${seat.getColumn()}" >O</a>
								    </c:when>    
								    <c:otherwise>
								       <a href="reservationCreatorSeatsSelection?selectedSeat=${seat.getRow()}:${seat.getColumn()}" >S</a>
								    </c:otherwise>
								</c:choose>
						    </c:when>    
						    <c:otherwise>
						       X
						    </c:otherwise>
						</c:choose>
  				 	</c:forEach>
  				 	<br/>
				</c:forEach>
			</div>
      </div>
    </div>
</div>