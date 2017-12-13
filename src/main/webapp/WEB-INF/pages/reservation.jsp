<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div id="accesibleSeatPlanContainer">
     <form:form name="selectSeats" action="selectSeatsProcess" method="post">
      	<table align="center">
	     	<c:forEach items="${seatsListRows}" var="seats">
	        <tr>
		        <c:forEach items="${seats}" var="seat">				
		          <td>
		              <c:choose>
					    <c:when test="${disabledSeats.contains(seat.getPosition())}">
					         <input type="checkbox" name="seat" disabled="disabled" checked="checked"/>
					    </c:when>    
					    <c:otherwise>
					        <input type="checkbox" name="seat" />
					    </c:otherwise>
					 </c:choose>
		          </td>
		        </c:forEach>
	        </tr>
	       </c:forEach>
       </table>
     </form:form>
</div>