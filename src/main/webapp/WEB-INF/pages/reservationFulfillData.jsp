<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="py-5 bg-dark text-white">
    <div class="container">
        <div class="row">
         <div class="col-md-3 text-center align-self-center" style=""></div>
			 <div class="col-md-9 text-center align-self-center" style="">
				 <form:form id="finalizeReservationForm" modelAttribute="reservationData" action="finalizeReservationProcess" method="post">
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
			                        <form:label path="email">email:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="email" name="email" id="email"/>
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
			 </div>
      	</div>
    </div>
</div>