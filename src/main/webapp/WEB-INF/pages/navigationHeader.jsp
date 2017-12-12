<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-md navbar-dark sticky-top banner">
    <div class="container">
        <a class="navbar-brand logo" href="#">
            <img style="max-height: 60px" src="resources/Images/logo.png">
            Cinema Smile
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbar2SupportedContent" aria-controls="navbar2SupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse text-center justify-content-end" id="navbar2SupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">CINEMA</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">REPERTUAR</i>
                        <br> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">PROMO</a>
                </li>
                 <sec:authorize access="isAuthenticated()">
	                 <li class="dropdown nav-item">
	                    <a class="dropdown-toggle nav-link text-white" data-toggle="dropdown" href="#">MANAGE</a>
	                    <span class="caret"></span></a>
				        <ul class="dropdown-menu">
				          <li><a href="manageUsers">MANAGE USERS</a></li>
				          <li><a href="manageCinema">MANAGE CINEMAS</a></li>
				        </ul>
	              	 </li>
                 </sec:authorize>
            </ul>
            <sec:authorize access="isAuthenticated()">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h2>
						User : ${pageContext.request.userPrincipal.name} | 
					</h2>
				</c:if>
				<a class="btn navbar-btn ml-2 text-white btn-secondary" href="logoutProcess"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Log out</a>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
          	  <a class="btn navbar-btn ml-2 text-white btn-secondary" data-toggle="modal" data-target="#loginPopUp"><i class="fa d-inline fa-lg fa-user-circle-o"></i>Sign in</a>
            </sec:authorize>
        </div>
    </div>
</nav>
<div class="modal fade" id="loginPopUp" role="dialog">
   <div class="modal-dialog modal-sm">
     <div class="modal-content">
     	<jsp:include page="login.jsp" flush="true"/>
     </div>
   </div>
 </div>