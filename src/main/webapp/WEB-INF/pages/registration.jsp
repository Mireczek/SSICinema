<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
        <form:form id="registerForm" modelAttribute="user" action="registerProcess" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label path="email">Email: </form:label>
                    </td>
                    <td>
                        <form:input path="email" name="email" id="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="name">User name:</form:label>
                    </td>
                    <td>
                        <form:input path="name" name="name" id="name" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="role">Role:</form:label>
                    </td>
                    <td>
                        <form:input path="role" name="role" id="role" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="password">Password:</form:label>
                    </td>
                    <td>
                        <form:password path="password" name="password" id="password" />
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="login" name="login">Register User</form:button>
                    </td>
                </tr>
            </table>
        </form:form>
        <table align="center">
            <tr>
                <td style="font-style: italic; color: red;">${message}</td>
            </tr>
        </table>
    </body>
</html>