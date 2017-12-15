<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="py-5 bg-dark text-white">
    <div class="container">
        <header>
            <h2>Generate report</h2>
        </header>
        <form:form id="reportForm" modelAttribute="report" action="generateReport" method="post">
            <table align="center">
                <tr>
                    <td>
                        <form:label  path="cinema">cinema: </form:label>
                    </td>
                    <td>
                        <form:input path="cinema" name="cinema" id="cinema"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="movie">movie:</form:label>
                    </td>
                    <td>
                        <form:input path="movie" name="movie" id="movie"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="year">year:</form:label>
                    </td>
                    <td>
                        <form:input path="year" name="year" id="year"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="month">month:</form:label>
                    </td>
                    <td>
                        <form:select path="month" name="month" id="month">
                            <form:option value="1"/>
                            <form:option value="2"/>
                            <form:option value="3"/>
                            <form:option value="4"/>
                            <form:option value="5"/>
                            <form:option value="6"/>
                            <form:option value="7"/>
                            <form:option value="8"/>
                            <form:option value="9"/>
                            <form:option value="10"/>
                            <form:option value="11"/>
                            <form:option value="12"/>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="day">day:</form:label>
                    </td>
                    <td>
                        <form:input path="day" name="day" id="day"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="generate" name="generate">Generate</form:button>
                    </td>
                </tr>
            </table>
        </form:form>
        <c:if test="${not empty reservations}" >
            <table>
                <tr>
                    <td>Cinema</td><td>Movie</td><td>Date</td><td>Reservations</td>
                </tr>
                <c:forEach items="${reservations}" var="entry">
                    <tr>
                        <td>
                            ${entry.getCinema()}
                        </td>
                        <td>
                            ${entry.getMovie()}
                        </td>
                        <td>
                            ${entry.getDayString()}
                        </td>
                        <td>
                            ${entry.getTickets()}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>