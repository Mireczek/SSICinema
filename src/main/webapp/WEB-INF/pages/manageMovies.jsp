<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Manage movies</h2>
        </header>
		<form:form id="movieForm" modelAttribute="movie" action="movieAddProcess" method="post">
			            <table align="center">
			                <tr>
			                    <td>
			                        <form:label path="description">description: </form:label>
			                    </td>
			                    <td>
			                        <form:input path="description" name="description" id="description"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="name">name:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="name" name="name" id="name"/>
			                    </td>
			                </tr>
			                 <tr>
			                    <td></td>
			                    <td align="left">
			                        <form:button id="register" name="register">Update</form:button>
			                    </td>
			                </tr>
			            </table>
			        </form:form>       
    </div>
</div>