<%-- <head> 
<%@ page  isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body> --%>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">OnlineShopping.com</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<!-- each <li> </li> is one menu option -->
				<li class="active"><a href="home">Home</a></li>

				
				
				<c:forEach items="${categoryList}"  var="category">
				<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown"  	href="">${category.categoryName}<span  	class="caret"></span></a>

						<ul class="dropdown-menu">
						
							<c:forEach items="${category.subCatagory}" var="subCategory">
					<li><a	href="${pageContext.request.contextPath}/showProducts/${subCategory.subcategoryId}">${subCategory.subcategoryName}
										</a></li>
							</c:forEach>

						</ul>


					</li>
					</c:forEach>
					
					

			</ul>
			<ul class="nav navbar-nav navbar-right">
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<li><a href="${pageContext.request.contextPath}/Register"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
						</c:if>
		
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<div class="navbar-collapse collapse left" id="basket-overview">
						<li><a href="${pageContext.request.contextPath}/loginPage"
							class="btn btn-primary navbar-btn" style="font-size: 12px;">Login</a></li>
					</div>
				</c:if>
						
						
				<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
						</c:if>
										
			</ul>
		</div>
	</div>
</nav>

<div class="container">
<security:authorize access="hasRole('ROLE_ADMIN')">

					
  <a href="AdminManageProduct"><h3 align="center">Manage Product</h3></a> 
   </security:authorize>
  


</div>

<!-- </body> -->