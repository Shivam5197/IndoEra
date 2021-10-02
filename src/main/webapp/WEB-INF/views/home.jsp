<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>IndoEra</title>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%@include file="/WEB-INF/views/Constants/Constatnt.jsp" %> --%>

<%-- <%@include file="/WEB-INF/views/Utils/toIncludeConstant.jsp" %> --%>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<%-- Sweet Alert CDN --%>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link> 
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<%-- Sweet Alert CDN --%>

<%@include file="/WEB-INF/views/Utils/toIncludeConstant.jsp"%>


<script src="https://use.fontawesome.com/4803dd6473.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>


<!-- Internal JS files -->
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/UtilsJs/MasterAjax.js"/>"></script>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/loginSignup/loginSignup.js"/>"></script>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/UtilsJs/utils.js"/>"></script>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/home/home.js"/>"></script>
<!-- Internal JS files -->

<!-- Input field CSS to be Applied all over the project -->
<link type="text/css" href="<s:url value="/CSS/Header/inputField.css"/>" rel="stylesheet">
<link type="text/css" href="<s:url value="/CSS/Header/Buttons.css"/>" rel="stylesheet">
<link type="text/css" href="<s:url value="/CSS/Header/loader.css"/>" rel="stylesheet">

<link type="text/css" href="<s:url value="/CSS/Header/header.css"/>" rel="stylesheet">


<script type="text/javascript">
	var global_contextPath = "${pageContext.request.contextPath}";
</script>

<style>
* {
	margin: 0;
	padding: 0;
}

.homeSearch {
	width: 72%;
}

.homeNave {
	background-color: #3c4799;
	height: 10vh;
	width: 100%;
}

.searchSubmitButton {
	background: white;
	padding: revert;
	margin-left: 5px;
	
}

.miniNav {
	max-height: 10vh;
}

.mainContent {
	width: 100%;
	height: max-content;
}

/* .MycorrusleClass {
	max-height: 89vh;
}

#carouselExampleCaptions{
max-height: 88vh;
}
 */
.corrusle-img{
max-height: 88vh;
}
 
.loginSignupbuttons{
background: white;
margin-right: 12px;
}

.footBody{
background-color: black;
color: white;
font-style: normal;
font-family: initial;
}

.footer-copyright{
    background-color: rgb(199, 199, 206);
    font-size: revert;
}
</style>

</head>
<body>

	<div class="modal fade rounded " id="main-model">
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



	<nav class="homeNave">
		<div class="d-flex flex-row miniNav">
		</div>
	</nav>

	<div class="container-lg">

<!-- Loader DIV -->
<div class="loader-background"></div>
<div class="processingLoader text-center">									
<div class="showbox">
  <div class="loader"> <svg class="circular" viewBox="25 25 50 50">
    <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"/>
    </svg> </div>
</div>
</div> 
<!-- Loader DIV -->


		<div class="row">
			<div class="col-md-2">
			
			</div>

			<div class="col-md-10">
				<div class="mainCointainer">
					<!-- The Container WHich will replace everything -->

 					<div id="carouselExampleSlidesOnly" class="carousel slide"
						data-bs-interval="2000" data-bs-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active" data-bs-interval="1000">
								<img src="<s:url value="/img/homeStatic/cloth.jpg"/>" title=""
									class="d-block corrusle-img w-100" alt="">
							</div>
							<div class="carousel-item active" data-bs-interval="1000">
								<img src="<s:url value="/img/homeStatic/shoe.jpg"/>" title=""
									class="d-block w-100 corrusle-img" alt="">
							</div>
							<div class="carousel-item ">
								<img src="<s:url value="/img/homeStatic/phones.jpg"/>" title=""
									class="d-block w-100 corrusle-img" alt="">
							</div>
						</div>
					</div>
 
		</div>
				<!-- This Div contians all the data in It -->
			</div>

		</div>
	</div>
	<!-- container-fluid -->


<!-- Footer -->
<footer class="page-footer font-small blue pt-4">

  <!-- Footer Links -->
  <div class="container-fluid text-center footBody text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-6 mt-md-0 mt-3">

        <!-- Content -->
        <h5 class="text-uppercase">Footer Content</h5>
        <p>Here you can use rows and columns to organize your footer content.</p>

      </div>
      <!-- Grid column -->

      <hr class="clearfix w-100 d-md-none pb-3">

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 class="text-uppercase">Links</h5>

        <ul class="list-unstyled">
          <li>
            <a href="/indoUser/register-Saller">Sell With IndoEra</a>
          </li>
          <li>
            <a href="#!">Link 2</a>
          </li>
          <li>
            <a href="#!">Link 3</a>
          </li>
          <li>
            <a href="#!">Link 4</a>
          </li>
        </ul>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 class="text-uppercase">Links</h5>

        <ul class="list-unstyled">
          <li>
           <a href="#!">Link 1</a>
          </li>
          <li>
            <a href="#!">Link 2</a>
          </li>
          <li>
            <a href="#!">Link 3</a>
          </li>
          <li>
            <a href="#!">Link 4</a>
          </li>
        </ul>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    <a href="#"> IndoEra</a>
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
		
</body>
</html>