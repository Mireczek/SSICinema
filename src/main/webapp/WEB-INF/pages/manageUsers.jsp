<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <header>
            <h2>Manage Users</h2>
        </header>
        <div class="row">
            <div class="list-group scrollable">
            	<c:forEach items="${usersList}" var="entry">
  				 	<a href="manageUsers?item=${entry}" class="list-group-item">${entry}</a>
				</c:forEach>
			</div>
            <div class="col-md-9 text-center align-self-center" style="">
            	<c:if test="${not empty selectedUser}" >
	            	<form:form id="userForm" modelAttribute="user" action="userRegisterProcess" method="post">
			            <table align="center">
			                <tr>
			                    <td>
			                        <form:label path="email">email: </form:label>
			                    </td>
			                    <td>
			                        <form:input path="email" name="email" id="email" value="${selectedUser.email}" />
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="name">name:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="name" name="name" id="name" value="${selectedUser.name}"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="role">role:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="role" name="role" id="role" value="${selectedUser.role}"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="locked">locked:</form:label>
			                    </td>
			                    <td>
			                        <form:checkbox path="locked" name="locked" id="locked" value="${selectedUser.locked}"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="password">password:</form:label>
			                    </td>
			                    <td>
			                        <form:password path="password" name="password" id="password" value="${selectedUser.password}"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td></td>
			                    <td align="left">
			                        <form:button id="register" name="register">Update User</form:button>
			                    </td>
			                </tr>
			            </table>
			        </form:form>
				</c:if>
				<c:if test="${empty selectedUser}" >
            		<form:form id="userForm" modelAttribute="user" action="userRegisterProcess" method="post">
			            <table align="center">
			                <tr>
			                    <td>
			                        <form:label path="email">email: </form:label>
			                    </td>
			                    <td>
			                        <form:input path="email" name="email" id="email"/>
			                    </td>
			                </tr>
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
			                        <form:label path="role">role:</form:label>
			                    </td>
			                    <td>
			                        <form:input path="role" name="role" id="role"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="locked">locked:</form:label>
			                    </td>
			                    <td>
			                        <form:checkbox path="locked" name="locked" id="locked"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td>
			                        <form:label path="password">password:</form:label>
			                    </td>
			                    <td>
			                        <form:password path="password" name="password" id="password"/>
			                    </td>
			                </tr>
			                <tr>
			                    <td></td>
			                    <td align="left">
			                        <form:button id="register" name="register">Register</form:button>
			                    </td>
			                </tr>
			            </table>
			        </form:form>
				</c:if>
				 <table align="center">
		            <tr>
		                <td style="font-style: italic; color: red;">${message}</td>
		            </tr>
		        </table>
            </div>
      </div>
    </div>
</div>