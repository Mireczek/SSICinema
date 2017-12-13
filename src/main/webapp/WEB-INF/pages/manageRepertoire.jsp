<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Manage repertoires</h2>
        </header>
        <div class="row">
            <form:form id="repertoireForm" modelAttribute="repertoire" action="repertoireAddProcess" method="post">
			            <table align="center">
			                <tr>
			                    <td>
			                        <form:label path="room">room:</form:label>
			                    </td>
			                    <td>
			                        <form:select path="room">
							             <form:options items="${roomList}" itemValue="id" itemLabel="name" />
							        </form:select>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="movie">movie:</form:label>
			                    </td>
			                    <td>
			                        <form:select path="movie">
							             <form:options items="${movieList}" itemValue="id" itemLabel="name" />
							        </form:select>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="date">date:</form:label>
			                    </td>
			                    <td>
									<form:input type="text" path="date" class="date" name="date"/>
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