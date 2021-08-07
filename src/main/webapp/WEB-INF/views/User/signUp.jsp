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
<!-- Internal JS files -->

<!-- Input field CSS to be Applied all over the project -->
<link type="text/css" href="<c:url value="/CSS/Header/inputField.css"/>"
	rel="stylesheet">
<link type="text/css" href="<c:url value="/CSS/Header/loader.css"/>" 
	rel="stylesheet">
<link type="text/css" href="<c:url value="/CSS/Header/Buttons.css"/>"
	rel="stylesheet">

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
			<div class="col-sm-2 p-3">
				<a href="#" class="navbar-brand ml-10 ml-sm-20"> <span
					class="d-none d-sm-flex brandName">IndoEra</span>
				</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid mt-2">
		<div class="card signUpCard shadow-lg">


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

			<div class="toast" id="epictoast" role="alert" aria-live="assertive"
				aria-atomic="true"
				style="position: absolute; top: 20px; right: 20px;"></div>

			<div class="card-body">
				<h2 class="card-title text-center">Register</h2>
				<hr>

				<form name="registerUser" method="POST"
					class="formClass register-form">

					<div class="row m-1">
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="firstName" name="firstName" required="required" placeholder="">
								 	<label	for="" class="inputlab">First Name</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="lastName" name="lastName" required="required" placeholder=""> 
									<label for="" class="inputlab">Last Name</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="date" class="inputTxt" id="dateOfBirth" name="dateOfBirth" required="required" placeholder="">
									<label for="" class="inputlab">Date of Birth</label>
							</div>
						</div>
					</div>

					<div class="row m-1">
						<div class="col-md-6">
							<div class="input_div  input_div_m">
								<input type="email" class="inputTxt" id="email" name="email" onchange="checkEmail();" required="required" placeholder="">
									<label for="" class="inputlab">Email</label>
							</div>
						</div>
						<div class="col-md-6">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="userName" name="userName" onchange="checkUserName();" required="required" placeholder=""> 
									<label for="" class="inputlab">User Name</label>
							</div>
						</div>
					</div>

					<div class="row m-1">
						<div class="col-md-4 ">
							<div class="input_div country input_div_m">
								
							</div>

						</div>
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="state" name="state"
									required="required" placeholder=""> <label for=""
									class="inputlab">State</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="city" name="city" required="required" placeholder=""> 
								<label for="" class="inputlab">City</label>
							</div>
						</div>
					</div>

					<div class="row m-1">
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="zipCode" name="zipCode" required="required" placeholder=""> 
								<label for="" class="inputlab">Zip code/Postal Code</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input_div  input_div_m">
								<input type="text" class="inputTxt" id="address" name="address" required="required" placeholder=""> 
								<label for="" class="inputlab">Address</label>
							</div>
						</div>
						<div class="col-md-4">
							<div class="input_div phonediv input_div_m">
								<input type="tel" class="inputTxt" id="phoneNumber" maxlength="15" name="phoneNumber" required="required" placeholder="">
									 <label for="" class="inputlab">Phone Number</label>
							</div>
						</div>
					</div>

					<div class="row m-1">

						<div class="col-md-3">
							<!-- Horizontally stacked radio buttons -->
							<label class="checkLabel">Gender: </label>
							<div class="custom-radio d-inline-block mr-10">
								<input type="radio" name="user" id="user" value="${maleUser}">
								<label class="checkLabel" for="user">Male</label>
							</div>
							<div class="custom-radio d-inline-block">
								<input type="radio" name="user" id="femaleUser"
									value="${feMaleUser}"> <label class="checkLabel"
									for="femaleUser">Female</label>
							</div>
							<div class="custom-radio d-inline-block ml-2">
								<input type="radio" name="user" id="otherUser"
									value="${otherUser}"> <label class="checkLabel"
									for="otherUser">Others</label>
							</div>
						</div>

						<div class="col-md-3"></div>
						<div class="col-md-6">
							<div class="buttonsDiv">

								<input type="button" id="loginButton"
									class="btn-register float-right" onclick="sendMailverification();"
									value="Register"> <input type="button"
									class="btn-Cancel float-right" onclick="callPopup();"
									id="liveToastBtn" value="Cancel">
							</div>
						</div>
					</div>

					<hr>

					<div class="row m-2">
						<div class="col-md-6">
							<p>
								Already a user? <a href="/Indoera/home">login</a> here
							</p>
						</div>
						<div class="col-md-6">
							<p>SignUp using These platforms</p>
						</div>
					</div>
				</form>

			</div>
			<!-- CardBody -->
		</div>
		<!-- Card -->
	</div>
	<!-- Cointainer -->

<script>

//loader
function toggleSpinnerOn(){    
	console.log("IAM CALLLLED::::::::::::::::::::::::")
		$(".signUpCard").css("opacity","0.5");
		$(".processingLoader").show();
}
function toggleSpinnerOff(){
		$(".processingLoader").hide();	    
		$(".signUpCard").css("opacity","1");
}

</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>