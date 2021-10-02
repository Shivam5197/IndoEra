/**
 * 
 */

$(document).ready(function(){
	fetchAndDisplayCountryListOnSignUp();
});


function loginForm(){
    let header = "<h4>Login</h4>";
    let data = "<div class=\"row\">"
        + "<div class=\"col-md-12\">"
        + "<div class=\"input_div\">"
        + "<input type=\"text\" class=\"inputTxt\" id=\"userNameLog\" name=\"userNameLog\" required=\"required\" placeholder=\"\">"
        + "<label for=\"\" class=\"inputlab\">User Name</label>"
        + "</div>"
        + "</div>"
        + "<div class=\"col-md-12\">"
        + "<div class=\"input_div\">"
        + "<input type=\"password\" class=\"inputTxt\" id=\"passwordLog\" name=\"passwordLog\" required=\"required\" placeholder=\"\">"
        + "<label for=\"\" class=\"inputlab\">Password</label>"
        + "</div>"
        + "</div>"
        + "</div>"
        + "<div class=\"row\">"
        + "<div class=\"col-md-12\">"
        + "</div>"
        + "<div class=\"col-md-12 mt-1\">"
        + "<a onclick=\"\" class=\"anchor-link\"  style=\"cursor: pointer; color: blue;\">Forgot Password ??</a>"
        + "</div>"
        + "<div class=\"col-md-12 mt-1\">"
       	+ "<a class=\"font-weight-bold anchor-link\" href=\"/indoUser/showSignupForm \" style=\"cursor: pointer;\" >New to IndoEra? Create Account</a>"
        + "</div>"
        + "</div>";

    let footer =  "<a onclick=\"otpLogin()\" class=\"anchor-link\" style=\"cursor: pointer; margin-right: 14vw; color: blue;\">Login with OTP</a>"
    +"<button type=\"submit\" onclick=\"validateLogin();\" class=\"btn btn-login\">Login</button>";
    
    let popUp = new MainPopUpModal(header, data, footer);
    popUp.show();

}

function validateLogin(){
	console.log("Validate MEthod");
	let formData = new FormData();

	formData.append("userName", $("#userNameLog").val());
	formData.append("password", $("#passwordLog").val());
	
	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/validatelogin";
	obj.data = formData;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){
		let user = JSON.parse(responseData.data);
		swal({
				  title: "Congrats !",
  				  text: responseData.message,
  				  icon: "success",
 				  button: "OK",
		});	
	
		sleep(5000);
		if(user.role == _const_userRoles.slt_admin){
			window.location = '/indoUser/admin-indo';
		}else if(user.role == _const_userRoles.store_owner){
			window.location = '/indoUser/sales-indo';
		}else{
			window.location = '/Indoera/home';
		}
		}else{
			console.log(responseData)
		swal({
				  title: "Failed !",
  				  text: responseData.message,
  				  icon: "warning",
 			   	 dangerMode: true,	
				  button: "OK",
		});	
		}
	});	
}

function otpLogin(){
    resetPosition()
	fetchAndDisplayCountryListOnOTP();
    let header = "<h4>Login With OTP</h4>";
    let data = `<div class="row"> 
	<div class="alert alert-warning" role="alert">
	  Please Select your country To Help us find you easily
	</div>
	<div class="input_div country input_div_m">
	</div>

    <div class="col-md-9">
    <div class="input_div phoneDivOTP">
      <input type="tel" class="inputTxt" id="phoneNumber" name="phoneNumber" required="required" placeholder="">
          <label for="" class="inputlab">Phone Number</label>
          </div>
        </div>
        <div class="col-md-3">
          <button class="btn btn-outline-primary">Send OTP</button>
              </div>
    </div>
    <div class="row">
    <div class="col-md-5">
    <div class="input_div ">
      <input type="text" maxlength="6" class="inputTxt" id="otpRecieved" name="otpRecieved" required="required" placeholder="">
         <label for="" class="inputlab">OTP</label>
          </div>
        </div>
        <a onclick="" style="color: blue;">Not Recieved? Resend OTP</a>  
  </div>`;
    let footer = "<button type=\"submit\" class=\"btn btn-login\">Login</button>";

    let popUp = new MainPopUpModal(header, data,footer);
    popUp.show();
}


function fetchAndDisplayCountryListOnOTP(){
	console.log("fetchAndDisplayCountryListOnOTP")
	var ajaxObject = new MasterAjax();
	ajaxObject.requestType = "POST";
	ajaxObject.url = "getCountryList";
	ajaxObject.contentType = false;
	ajaxObject.data = null;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK") {
			countryList = JSON.parse(responseData.data);
			let content = "<select style=\"padding: 1px; width: 70%; margin-left: 14px;\"  id=\"leadCountryOTP\" onchange=\"displayISDCodeonOTP();\" class=\"inputTxt\" required=\"required\" >" +
							"<option style=\"max-width: 68%;\" value=\"-1\"> Country </option>";
			for(let k=0;k<countryList.length;k++){
				content += "<option style=\"width: 68%;\" value="+countryList[k].id+">"+countryList[k].countryName+"</option>";
			}
			content += "</select>";
			$(".country").html(content);
			
		} else {
			//NO COUNTRY LIST RECEIVED
		}
	});
}

function displayISDCodeonOTP(){
	let countryId = document.getElementById("leadCountryOTP").value;
	let isdCode = null;
		for (var i = 0; i < countryList.length; i++) {
		if(countryList[i].id == countryId){
			isdCode = 	countryList[i].countryPhoneCode;
		}
	}
	phoneContent= "<input type=\"tel\" class=\"inputTxt\" id=\"phoneNumberOTP\" value=+"+isdCode+"  maxlength=\"15\" name=\"phoneNumber\" required=\"required\" placeholder=\"\" >"+
		"<label for=\"\" class=\"inputlab\">Phone Number</label>";
	
		$(".phoneDivOTP").html(phoneContent);
}

function fetchAndDisplayCountryListOnSignUp(){
	console.log("fetchAndDisplayCountryListOnSignUp")
	var ajaxObject = new MasterAjax();
	ajaxObject.requestType = "POST";
	ajaxObject.url = "getCountryList";
	ajaxObject.contentType = false;
	ajaxObject.data = null;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK") {
			countryList = JSON.parse(responseData.data);
			let content = "<select style=\"padding: 0;\"  id=\"leadCountry\" onchange=\"displayISDCode();\" class=\"inputTxt\" required=\"required\" >" +
							"<option value=\"-1\"> Country </option>";
			for(let k=0;k<countryList.length;k++){
				content += "<option value="+countryList[k].id+">"+countryList[k].countryName+"</option>";
			}
			content += "</select>";
			$(".country").html(content);
			
		} else {
			//NO COUNTRY LIST RECEIVED
		}
	});
}

function displayISDCode(){
	let countryId = document.getElementById("leadCountry").value;
	let isdCode = null;
		for (var i = 0; i < countryList.length; i++) {
		if(countryList[i].id == countryId){
			isdCode = 	countryList[i].countryPhoneCode;
		}
	}
	phoneContent= "<input type=\"tel\" class=\"inputTxt\" id=\"phoneNumber\" value="+isdCode+"  maxlength=\"15\" onchange=\"checkPhoneNumber();\" name=\"phoneNumber\" required=\"required\" placeholder=\"\" >"+
		"<label for=\"\" class=\"inputlab\">Phone Number</label>";
	
		$(".phonediv").html(phoneContent);
}


function sendMailverification(){
	console.log("sendMailVerification MEthod");
	let formData = new FormData();

	formData.append("firstName", $("#firstName").val());
	formData.append("lastName", $("#lastName").val());
	formData.append("dateOfBirth", $("#dateOfBirth").val());
	formData.append("email", $("#email").val());
	formData.append("userName", $("#userName").val());
	formData.append("country", $("#leadCountry").val());
	formData.append("state", $("#state").val());
	formData.append("city", $("#city").val());
	formData.append("address", $("#address").val());
	formData.append("zipCode", $("#zipCode").val());
	formData.append("phoneNumber", $("#phoneNumber").val());
	formData.append("gender", $('input[name="user"]:checked').val());

	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/mailsend";
	obj.data = formData;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){

		swal({
				  title: "Congrats !",
  				  text: responseData.message,
  				  icon: "success",
 				  button: "OK",
		});

		}else{
			console.log(responseData)
			displayFailedToast("Failed",responseData.message)
		}
	});	
}

function sendSuccessMailPopup(responseData){
	let User = JSON.parse(responseData.data)
	
	let header = "<h4 style=\"color: rgb(76,187,23)\">Success<h4>";
	let data = "<div>"
        +"<p><b>"+User.email+"</b>"+responseData.message+"</p>"
    +"</div>";

	let popUp = new MainPopUpModal(header,data);
    popUp.show();
}

function checkPhoneNumber(){
	let phone = document.getElementById("phoneNumber").value;
	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/validate-phn";
	obj.data = phone;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){
		}else{
			console.log(responseData)
			displayFailedToast("Failed",responseData.message)
		}
	});	
}

function checkUserName(){
//	console.log("I am Called");
	let phone = document.getElementById("userName").value;
	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/validate-usNa";
	obj.data = phone;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){
		}else{
			console.log(responseData)
			displayFailedToast("Failed",responseData.message)
		}
	});	
}

function checkEmail(){
	let phone = document.getElementById("email").value;
	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "indoUser/validate-eml";
	obj.data = phone;
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "application/json";
	obj.requestData(function(responseData){
		if(responseData.status == "OK" || responseData.status == "ok"){
		}else{
			console.log(responseData)
			displayFailedToast("Failed",responseData.message)
		}
	});	
}





