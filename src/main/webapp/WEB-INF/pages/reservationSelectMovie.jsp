<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="py-5 bg-dark text-white gradient-overlay">
    <div class="container">
        <div class="row">
            <div class="list-group scrollable">
            	<c:forEach items="${repertoire}" var="entry">
  				 	${entry.ketKey().getName()}
  				 	<c:forEach items="${repertoire.getValue()}" var="datesEntry">
  				 		${datesEntry}
  				 	</c:forEach>
				</c:forEach>
			</div>
      </div>
    </div>
</div>