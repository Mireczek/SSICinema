<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Manage cinemas</h2>
        </header>
        <div class="row">
            <div class="list-group scrollable">
            	<c:forEach items="${cinemasList}" var="entry">
  				 	<a href="manageCinema?item=${entry}" class="list-group-item">${entry}</a>
				</c:forEach>
			</div>
            <div class="col-md-9 text-center align-self-center" style="">
            	<c:if test="${not empty selectedCinema}" >
            		${selectedCinema.name}
            		<br/>
            		Rooms:
            		<br/>
            		<c:forEach items="${roomsList}" var="room">
  				 		<a href="" class="list-group-item">${room.getName()}</a>
					</c:forEach>
					
            		<form:form id="roomForm" modelAttribute="room" action="roomAddProcess" method="post">
			            <table align="center">
			                <tr>
			                    <td>
			                        <form:label path="name">name:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="name" name="name" id="name" />
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:input type="hidden" path="cinema" name="cinema" id="cinema" value="${selectedCinema.name}"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="seatsRows">seatsRows:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="seatsRows" name="seatsRows" id="seatsRows"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="seatsColumns">seatsColumns:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="seatsColumns" name="seatsColumns" id="seatsColumns"/>
			                    </td>
			                </tr>
			                
			                <tr>
			                    <td></td>
			                    <td align="left">
			                        <form:button id="save" name="save">Save</form:button>
			                    </td>
			                </tr>
			            </table>
			        </form:form>
				</c:if>
				<c:if test="${empty selectedCinema}" >
            		Not selected cinema
				</c:if>
            </div>
      </div>
    </div>
</div>