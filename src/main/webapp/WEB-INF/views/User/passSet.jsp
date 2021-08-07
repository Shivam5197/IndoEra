<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<script src="https://use.fontawesome.com/4803dd6473.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>

<%@include file="/WEB-INF/views/Utils/toIncludeConstant.jsp"%>

<%-- Sweet Alert CDN --%>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@7.12.15/dist/sweetalert2.min.css'></link> 
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<%-- Sweet Alert CDN --%>

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
.card{
width: 39%;
margin-left: 31%;
margin-top: 10%;
}
.homeNave {
	background-color: #3c4799;
	height: 10vh;
	width: 100%;
}

.resetForm{
box-sizing: border-box;
width: 100%;
margin-top: 12%;
}

#togglePassword{
    margin-right: 66%;
    margin-top: 14%;
}
body  {
  background-image: url("/img/homeStatic/PassImage.jpg");
  background-repeat: no-repeat;
  background-size: cover;  
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


	<div class="container">
	
				<div class="toast" id="epictoast" role="alert" aria-live="assertive"
				aria-atomic="true"
				style="position: absolute; top: 50px; right: 20px;"></div>
	
	
		<div class="card shadow-lg text-center ">
			<div class="card-header">Reset Your Password</div>
			<div class="card-body">

				<form class="resetForm">
					<div class="row">
						<div class="col-md-12">
							<div class="input_div ">
								<input type="password" class="inputTxt" id="newPassword"
									name="newPassword" required="required" placeholder="">
								<label for="" class="inputlab">New Password</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="input_div">
								<!-- style="margin-top: 11%;" -->
								<input type="text" class="inputTxt" id="confirmPass"
									name="confirmPass" required="required"
									onchange="passwordMatcher();" placeholder=""> <label
									for="" class="inputlab">Confirm Password</label>
							</div>
						</div>
					</div>

					<div class="buot">
						<button type="button" class="btn float-right" disabled>Reset
							Password</button>
					</div>
				</form>

			</div>
			<div class="card-footer text-muted">-------</div>
		</div>
	</div>



<script>

function passwordMatcher(){
	  if (document.getElementById('newPassword').value ==
		    document.getElementById('confirmPass').value){
		  displaySuccessToast("Success","Passwords matched");
		  button = "<button type=\"button\" onclick=\"setPass();\" class=\"btn btn-primary float-right\" >Reset Password</button>";
			$(".buot").html(button);
	  }else{
		  displayFailedToast("Failed","New Password Not Matched with Confirm Password");
	  }
 } 

function setPass(){
	
	var pass= document.getElementById("confirmPass").value;
	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/saveUser";
	obj.data = pass;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){
//			  displaySuccessToast("Success","Saved Successfully");
			loginredirectPopup(responseData.message);
				
		}else{
			console.log(responseData)
//			displayFailedToast("Failed",responseData.message)
			swal({
				  title: "Failed !",
				  text: responseData.message,
				  icon: "warning",
			   	 dangerMode: true,	
				  button: "OK",
		});	

		}
	});	


	function loginredirectPopup(message){
		let header = "Success";
		let data = message;
		let footer = "<button type=\"submit\" onclick=\"redirect();\" class=\"btn btn-primary\">Login</button>";
	
	    let popUp = new MainPopUpModal(header,data,footer);
	    popUp.show();

	}	
}

function redirect(){
	window.location = '/Indoera/home';
}

</script>


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>