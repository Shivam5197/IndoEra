/**
 * 
 */


//.myCheck

$(document).ready(function(){
	
	var ajaxObject = new MasterAjax();
	ajaxObject.requestType = "POST";
	ajaxObject.url = "Indoera/getUser";
	ajaxObject.contentType = false;
	ajaxObject.enctype = false;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK") {
//			console.log(responseData)
		let user = JSON.parse(responseData.data);		
			checkUser(user);
		} else {
			console.log(responseData);
			checkUser(null);
		}
	});

});

function checkUser(user){
		console.log("Check USer");
		console.log(user);
		let nav ="";
		if(user !=null){
	 nav = `<div class="col-sm-2 p-3">
				<a href="#" class="navbar-brand ml-10 ml-sm-20"> <span
					class="d-none d-sm-flex brandName">IndoEra</span>
				</a>
			</div>
			<div class="col-sm-6 p-3">
				<form class="d-flex" action="#">
					<input class="form-control me-2" type="search"
						placeholder="Search for Brands,Products and More"
						aria-label="Search">
					<button class="btn searchSubmitButton" type="submit">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</form>
			</div>
			<div class="col-sm-4 p-3">
				<div class="d-flex flex-row-reverse">
		<div class="navbar-header navbar-right pull-right">
    			<ul class="nav pull-left">
            		<a href="#" data-toggle="dropdown" id="user-dropdown" class="dropdown-toggle">
						${user.firstName} <span class="glyphicon glyphicon-user"></span>
                	<b class="caret"></b>
            	</a>
            <ul class="dropdown-menu">
                <li class="navbar-link">
                    <a href="/users/id" title="Profile">Profile</a>
                </li>
                <li>
                    <a href="/indoUser/logout" title="Logout">Logout </a>
                </li>
            </ul>
        </li>
    </ul>
    <button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle"> Hello
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
</div>
				
	</div>
			</div>`;		

		}else{
	 nav = `<div class="col-sm-2 p-3">
				<a href="#" class="navbar-brand ml-10 ml-sm-20"> <span
					class="d-none d-sm-flex brandName">IndoEra</span>
				</a>
			</div>
			<div class="col-sm-6 p-3">
				<form class="d-flex" action="#">
					<input class="form-control me-2" type="search"
						placeholder="Search for Brands,Products and More"
						aria-label="Search">
					<button class="btn searchSubmitButton" type="submit">
						<i class="fa fa-search" aria-hidden="true"></i>
					</button>
				</form>
			</div>
			<div class="col-sm-4 p-3">
				<div class="d-flex flex-row-reverse">
					<button type="button" data-toggle="modal" data-target="#signUp" onclick="loginForm();" data-whatever="@getbootstrap" class="btn loginSignupbuttons"> Login </button> 
					<a type="button" href="/indoUser/showSignupForm" class="btn loginSignupbuttons"> Signup </a> 
				</div>
			</div>`;		
	}
$(".miniNav").html(nav);
	
}



function showCarousl(){
	var carousl = "Hello World";

$(".mainCointainer").html(carousl);

}