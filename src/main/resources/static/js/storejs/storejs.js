/**
 * 
 */
function storeAddForm(){
	getStoreProductCategoryList();
	let storeForm = `
							<div class="row" style="padding: 3px;">
							<div class="col-md-12">
								<div class="row">
								<div class="col-md-4">
									<h3
										style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
										Add New Store</h3>
								</div>
								<div class="col-md-8">
									<button type="button" onclick="saveStore();" class="btn btn-primary float-right" >
										Save Store
									  </button>
									  <button type="button" class="btn  float-right">
										Cancel
									  </button>
								</div>
							</div>
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-6">
								<div class="card shadow p-3 mb-5 bg-white rounded" style="padding: inherit;">
									<h5 class="form-card-head" style="padding: 1%;">Store Details</h5>
								
									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeName"
													name="storeName" required="required" placeholder="" maxlength="50">
												<label for="" class="inputlab">Store Name</label>
											</div>
										</div>
										<div class="col-md-6" id="productCategoryListInput">
											
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="email" class="inputTxt" id="storeEmail"
													name="storeEmail" required="required" placeholder="" maxlength="50">
												<label for="" class="inputlab">Store Email</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" rows="4" cols="50" class="inputTxt" id="storeDescrption"
													name="storeDescrption" required="required" placeholder="" maxlength="200">
												<label for="" class="inputlab">More about Store</label>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="card shadow p-3 mb-5 bg-white rounded" style="padding: inherit;">
									<h5 class="form-card-head" style="padding: 1%;">Address Details</h5>
									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storePinCode"
													name="storePinCode" required="required" placeholder="" maxlength="12" onchange=\"verifyPinCode();\">
												<label for="" class="inputlab">Store Pincode</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeAddress"
													name="storeAddress" required="required" placeholder="" maxlength="100">
												<label for="" class="inputlab">Store Address</label>
											</div>
										</div>
									</div>
									<div class="row" id="storeAdressDetails">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeState"
													name="storeState" required="required" placeholder="" disabled readonly>
												<label for="" class="inputlab">State</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeCity"
													name="storeCity" required="required" placeholder="" disabled readonly>
												<label for="" class="inputlab">City</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="card shadow p-3 mb-5 bg-white rounded" style="padding: inherit;">
									<h5 class="form-card-head" style="padding: 1%;">Legal Details</h5>
									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="StoreOwnerPan"
													name="StoreOwnerPan" required="required" placeholder="" onchange="checkPan ()" maxlength="20">
												<label for="" class="inputlab">Owner Pan Number</label>
												
											</div>
<button type="button" class="fa fa-info-circle" data-toggle="tooltip" data-html="true" title="PAN is an electronic system through which, all tax related information for a person/company is recorded against a single PAN number. This acts as the primary key for storage of information and is shared across the country. Hence no two tax paying entities can have the same PAN. For example: QWERT1234Q"></button>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="StoreGSTIN"
													name="StoreGSTIN" required="required" onchange="checkGstNumber()" placeholder="">
												<label for="" class="inputlab">GST Number</label>
											</div>
<button type="button" class="fa fa-info-circle" data-toggle="tooltip" data-html="true" title="For example: 37AADCS0472N1Z1"></button>
											
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="mb-3">
												<label for="formFile" class="form-label">Store Logo</label>
												<input class="form-control" type="file" id="logoURL">
											  </div>
										</div>
			</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="card shadow p-3 mb-5 bg-white rounded" style="padding: inherit;">
									<h5 class="form-card-head" style="padding: 1%;">Bank Details</h5>
									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="accountHolderName"
													name="accountHolderName" required="required" placeholder="" maxlength="50">
												<label for="" class="inputlab">Account Holder Name</label>
											</div>
										</div>
										<div class="col-md-6" id="accountypeInputField">
	<select style="max-height: 7vh;padding: 11px;max-width: 18vw;margin-left: 11px;" id="accountType" class="inputTxt" required="required" >
							<option value="-1">Account Type</option>
		<option value="${_bankAccountTypes.savings_account}">Savings Account</option>
		<option value="${_bankAccountTypes.current_account}">Current Account</option>
		<option value="${_bankAccountTypes.recurring_account}">Recurring Account</option>
		</select>
										</div>
									</div>
									<div class="row">
									<div class="col-md-6">
											<div class="input_div">
												<input type="password" class="inputTxt" id="storeOwnerAccountNumber"
													name="storeOwnerAccountNumber" required="required" placeholder="" maxlength="20">
												<label for="" class="inputlab">Account Number</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="confirmStoreOwnerAccNumber"
													name="confirmStoreOwnerAccNumber" required="required" placeholder="" onchange="passwordMatcher()"; maxlength="20">
												<label for="" class="inputlab">Confirm Account Number</label>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						</div>`;
	
	document.getElementById("workSpace").innerHTML = storeForm;
}

function verifyPinCode(){
    let zipCode = document.getElementById("storePinCode").value;

    if (zipCode !== null && zipCode !== '') {
        var obj = new MasterAjax();
        obj.requestType = "POST";
        obj.url = "verifyZip";
        obj.data = zipCode;
        obj.contentType = false;
        obj.processData = false;
        obj.dataType = "application/json";
        obj.requestData(function(responseData) {
            if (responseData.status == "OK" || responseData.status == "ok") {
				validatePinCodes(JSON.parse(responseData.data));
//                displaySuccessToast("Success !", responseData.message);
            } else {
                displayFailedToast("Failed", responseData.message)
                console.log(responseData)
            }
        });
    } else {
        displayFailedToast("Failed", "Please Enter Correct Zip Code");
    }
}

        
function checkPan () {  
	console.log("PAN CHECKED");
var inputvalues = $("#StoreOwnerPan").val();      
  var regex = /[A-Z]{5}[0-9]{4}[A-Z]{1}$/;    
  if(!regex.test(inputvalues)){      
  $(".pan").val("");    
//displayFailedToast("Failed", "Please Enter Correct Pan Number");
	alert("Invalid Pan Number"); 
 return regex.test(inputvalues);    
  }    
}      
    

function checkGstNumber(){
	             var inputvalues = $("#StoreGSTIN").val();    
                var gstinformat = new RegExp('^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$');    
                if (gstinformat.test(inputvalues)) {    
                  return true;    
                } else {    
                alert('Please Enter Valid GSTIN Number');    
               $(".gst").val('');    
               $(".gst").focus();    
                }  	
	}


function validatePinCodes(zipDetails) {
  var rv = {};
  var Division = {};
  var State = {};
  for (var i = 0; i < zipDetails.length; i++) {
    rv = zipDetails[i];

	if(rv.PostOffice == null){
	swal({
				  title: "We are Sorry !!",
  				  text: "We can not pickup from this Zip code !! ",
  				  icon: "warning",
 				  button: "OK",
		});	

}else{
	 for (var i = 0; i < rv.PostOffice.length; i++) {
      Division = rv.PostOffice[2].District;
	 State= rv.PostOffice[2].Circle;
	StoreAddressformFull(Division,State);
    		}
		}
  	}
}

function StoreAddressformFull(Division,State){
	
	var storeDetails = `<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeState"
													name="storeState" required="required" value=${State} placeholder="" disabled>
												<label for="" class="inputlab">State</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeCity"
													name="storeCity" required="required" value=${Division} placeholder="" disabled readonly>
												<label for="" class="inputlab">City</label>
											</div>
										</div>`;
			document.getElementById("storeAdressDetails").innerHTML = storeDetails;
}


function getStoreProductCategoryList(){
	var ajaxObject = new MasterAjax();
	ajaxObject.requestType = "POST";
	ajaxObject.url = "products/getProductCategoryList";
	ajaxObject.contentType = false;
	ajaxObject.data = null;
	ajaxObject.requestData(function(responseData) {
		if (responseData.status == "OK") {
			productCategoryList = JSON.parse(responseData.data);
			let content = "<select style=\"max-height: 7vh;padding: 11px;max-width: 18vw;margin-left: 11px;\" id=\"productCategory\" class=\"inputTxt\" required=\"required\" >" +
							"<option value=\"-1\"> Select Products </option>";
			for(let k=0;k<productCategoryList.length;k++){
				content += "<option value="+productCategoryList[k].productCatId+">"+productCategoryList[k].categoryName+"</option>";
			}
			content += "</select>";
			$("#productCategoryListInput").html(content);
			
		} else {
			//NO Product Category LIST RECEIVED
		}
	});

}


function passwordMatcher(){
	  if (document.getElementById('storeOwnerAccountNumber').value ==
		    document.getElementById('confirmStoreOwnerAccNumber').value){
//		  displaySuccessToast("Success","Account Numbers matched");
	  }else{
	swal({
				  title: "We are Sorry !!",
  				  text: "We can't let you proceed further as your account number is not matched please confirm account number and try again!!'",
  				  icon: "warning",
 				  button: "OK",
		});	
storeAddForm();
	  }
 } 


$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})


function saveStore(){
 
let formData = new FormData();

var file = $("#logoURL").val();
	if(file == undefined || file=="" || file ==null){
		console.log("File is Empty if")
		var error= "Please Enter logo Image";
		var head = "Failed to Save"
		displayFailedToast(head,error);
	}else{
	formData.append("storeName", $("#storeName").val());
	formData.append("productCategory", $("#productCategory").val());
	formData.append("storeEmail", $("#storeEmail").val());
	formData.append("storeDescription", $("#storeDescrption").val());
	formData.append("zipCode", $("#storePinCode").val());
	formData.append("address", $("#storeAddress").val());
	formData.append("state", $("#storeState").val());
	formData.append("city", $("#storeCity").val());
	formData.append("sellerPanNumber", $("#StoreOwnerPan").val());
	formData.append("gstinNumber", $("#StoreGSTIN").val());
	formData.append("StoreAccountHolderName", $("#accountHolderName").val());
	formData.append("accountType", $("#accountType").val());
	formData.append("storeAccountNumber", $("#storeOwnerAccountNumber").val());
	formData.append('logoFile', $('input[type=file]')[0].files[0]);

	var obj = new MasterAjax();
	obj.requestType = "POST";
	obj.url = "store/saveStore";
	obj.data = formData;
	obj.enctype ="multipart/form-data";   
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "json";
	obj.requestData(function(responseData){
		console.log(responseData);
		if(responseData.status == "OK" || responseData.status == "ok"){
		displaySuccessToast("Success",responseData.message);
			console.log(responseData)
		}else{
		displayFailedToast("Failed",responseData.message);
			console.log(responseData)
		}
	});	
	}
}