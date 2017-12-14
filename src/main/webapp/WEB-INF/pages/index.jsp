<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/style.css" type="text/css">
    <link rel="stylesheet" href="resources/CSS/Main.css" type="text/css">
    <style>
    	.scrollable {
		    flex: 1 1 0; 
		    display: flex;
		    flex-direction: column;
		    overflow-y: scroll;
		}
		.horizontalScrollList
		{
		    overflow-x:scroll;
		    overflow-y:hidden;
		    height:50px;
		    width:100%;
		    padding: 0 15px;
		}
		
		.horizontalScrollItem
		{
		    border:1px solid black;
		    padding:0;
		    height:50px;
		    width:80px;
		}
		
		.list-inline {
		  white-space:nowrap;
		}
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="resources/JS/bootstrap.js" type="text/javascript"></script>
   
</head>

<body>
<jsp:include page="navigationHeader.jsp" />
<c:choose>
    <c:when test="${content!= null && content != ''}">
       <jsp:include page="${content}.jsp" />
    </c:when>    
    <c:otherwise>
       <jsp:include page="home.jsp" />
    </c:otherwise>
</c:choose>

<jsp:include page="footer.jsp" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>

</html>