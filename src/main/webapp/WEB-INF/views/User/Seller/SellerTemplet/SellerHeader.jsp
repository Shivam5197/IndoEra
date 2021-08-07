<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Tag files -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Tag files -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IndoEra</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<!-- Sweet Alert CDN -->
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link> 
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- Sweet Alert CDN -->


<script src="https://use.fontawesome.com/4803dd6473.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>

<%@include file="/WEB-INF/views/Utils/toIncludeConstant.jsp"%>



<!-- Internal JS files -->
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/UtilsJs/MasterAjax.js"/>"></script>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/loginSignup/loginSignup.js"/>"></script>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/UtilsJs/utils.js"/>"></script>


<script type="text/javascript" charset="utf8" src="<c:url value="/js/Seller/sellerHome.js"/>"></script>
<script type="text/javascript" charset="utf8" src="<c:url value="/js/Storejs/Storejs.js"/>"></script>


<%-- <script type="text/javascript" charset="utf8"
	src="<c:url value="/js/Seller/sellerRegister.js"/>"></script>
--%>	
<!-- Internal JS files -->

<!-- Input field CSS to be Applied all over the project -->
<link type="text/css" href="<c:url value="/CSS/Header/inputField.css"/>"
	rel="stylesheet">
<link type="text/css" href="<c:url value="/CSS/Header/loader.css"/>" 
	rel="stylesheet">
<link type="text/css" href="<c:url value="/CSS/Header/Buttons.css"/>"
	rel="stylesheet">
<link type="text/css" href="<c:url value="/CSS/seller/sellerHeader.css"/>" rel="stylesheet">
	

<script type="text/javascript">
	var global_contextPath = "${pageContext.request.contextPath}";
</script>

<style>
* {
	margin: 0;
	padding: 0;
}
.formClass {
	margin-top: 2%;
}

.input_div_m {
	margin: 2rem;
}

.checkLabel {
	font-size: initial;
	font-style: normal;
	font-weight: normal;
}

.sellerSignUpCard{
    margin-top: 6%;
    width: 64%;
    margin-left: 17%;
}

.brandName {
	color: white;
	font-size: x-large;
	font-style: italic;
	font-weight: bold;
}
.homeSearch {
	width: 72%;
}
.homeNave {
	background-color: #3c4799;
	height: 10vh;
	width: 100%;
	position: fixed;
	 z-index: 1;
}
.card-title {
	text-transform: uppercase;
	font-weight: 300px;
	font-family: "Gill Sans", sans-serif;
}

.register-form {
	margin-top: 1%;
	margin-right: 4%;
}
.gstin_label{
    margin-top: 19%;

}
.products_label{
    margin-top: 9%;
}

hr { background-color: white;
 height: 1px; 
 border: 0; 
 }

</style>
</head>

<body>
	<div class="modal fade rounded" onload="userDetailsForm();" id="main-model">
		<div class="modal-dialog ">
			<div class="modal-content">

				<!--  Modal Header     -->
				<div class="modal-header p-3">
					<h6 class="modal-title" id="main-model-title">
						<i class="fas fa-table text-primary"></i> Select Table Columns
					</h6>
<!-- 					<button type="button" class="close" data-dismiss="modal">&times;</button> -->
					<button style="color: #fff;" type="button" class="close"
						onclick="resetPosition()" data-dismiss="modal">
						<i class="fas fa-times"></i>
					</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body" id="main-model-body">Please wait.....
				</div>

				<!--  Modal footer -->
				<div class="modal-footer">
					<div id="main-modal-handler"></div>
					<button type="button" class="btn btn-secondary"
						onclick="resetPosition()" data-dismiss="modal">
						<span id="main-model-close-btn-text">Close</span>
					</button>
				</div>

			</div>
		</div>
	</div>


<div class="row">
<div class="col-md-12">
	<nav class="homeNave" id="myHeader">
		<div class="d-flex flex-row miniNav">
			<div class="col-sm-2 p-3">
				<a href="#" class="navbar-brand ml-10 ml-sm-20"> <span
					class="d-none d-sm-flex brandName">IndoEra</span>
				</a>
			</div>
		</div>
	</nav>
	</div>
</div>

	<div class="container-fluid">

		<div class="row" style="margin-top: 71px;">
			<div class="col-md-2">
				<div class="sidebar" id="sidebar"></div>
			</div>

			<div class="col-md-10">

				<div class="workSpace" id="workSpace">

