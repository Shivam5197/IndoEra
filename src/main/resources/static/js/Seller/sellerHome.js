function storesListUI() {
    listOfSellersStore()

}

function listOfSellersStore() {
    //	alert("List OF SELLER STORES ")
    var ajaxObject = new MasterAjax();
    ajaxObject.requestType = "POST";
    ajaxObject.url = "seller/yourStores";
    ajaxObject.contentType = false;
    ajaxObject.enctype = false;
    ajaxObject.requestData(function(responseData) {

        if (responseData.status == "OK") {
            var data = JSON.parse(responseData.data);
            if (data.length != 0) {

                var listUI =
                    `<div class="row">
	<div class="col-md-12">
		<div class="card">

			<button onclick="storeAddForm();" class="btn btn-primary"
				style="width: 10%;">New Store</button>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="listofStores" id="listofStores" style="margin-top: 1vh;">
		<div class="card storeListCard" id="storeListCard">
		
			
	<table  id="storeListUser" class="display table">
					<thead class="thead-dark">
						<tr>
							<th></th>
							<th>Store Name</th>
							<th>Product Category</th>
							<th>Store Description</th>
							<th>Store Address</th>
							<th>GSTIN Number</th>
							<th>Status</th>
							<th>Actions</th>		
						</tr>
					 
					<tbody>`;
                for (var i = 0; i < data.length; i++) {

                    list = data[i];
                    //				console.log(data[i]);
                    listUI += `<tr>
							<td><img src="${data[i].logoURL}" class="store_logo" alt="No img"></td>						
							<td><a href="#">${data[i].storeName}</a></td>
							<td>${data[i].productSellCategory.categoryName}</td>
							<td>${data[i].storeDescription}</td>
							<td>${data[i].address}</td>
							<td>${data[i].gstinNumber}</td>`

                    if (data[i].storeStatus == 0) {
                        listUI += `<td><button class="btn btn-success" disabled>Active</button></td>`
                    } else {
                        listUI += `<td><button class="btn btn-dange" disabled>De-activated</button></td>`

                    }

						 listUI += `<td class="align-right"> 
						 				<select class="form-select" id="storeAction">
												<option onclick="storeAddForm(${data[i].id});" value="edit">Edit</option>
 								   				<option onclick="deleteStore(${data[i].id});" value="delete">Delete</option>
										</select>
									</td>

							</tr>`
                }
                listUI += `</tbody>
				</table>		
			</div>
			</div>
		</div>
	</div>`;

            } else {
                listUI = `    <div class="no-data">
        <div class="logo"><i class="fas fa-store fa-10x storered"></i></div>
        <div class="content" style="    padding: 28px;">
            <h2> No Stores found for you!! </h2>
            <p> Create a new Store </p>

            <div class="create-buton">
                <button class="btn btn btn-outline-info" onclick="storeAddForm();">New Store</button>
            </div>
        </div>
    </div>
`;
            }
            document.getElementById("workSpace").innerHTML = listUI;

        } else {
                listUI = `    <div class="no-data">
        <div class="logo"><i class="fas fa-store fa-10x storered"></i></div>
        <div class="content" style="    padding: 28px;">
            <h2> Somthing went Wrong !! We are trying to Fix it please try after sometime "</h2>

        </div>
    </div>
`
        }
    });
}


/*===================================Store Creation Related Code =============================================================*/


/**
 * 
 */
function storeAddForm(storeid){
	let storeForm = "";
	if(storeid == null || storeid ==""){
	
	getStoreProductCategoryList();
	storeForm += `<div class="row" style="padding: 3px;">
							<div class="col-md-12">
								<div class="row">
								<div class="col-md-4">
									<h3
										style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
										Add New Store</h3>
								</div>
								<div class="col-md-8">
									<button type="button" onclick="saveStore();" class="btn btn-primary float-right" >
										Save
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
	
	}// This is for the Edit page
	else{
    var ajaxObject = new MasterAjax();
    ajaxObject.requestType = "POST";
    ajaxObject.url = "seller/editStorePage/"+storeid+"";
    ajaxObject.contentType = false;
    ajaxObject.enctype = false;
    ajaxObject.requestData(function(responseData) {
        if (responseData.status == "OK") {
var data = JSON.parse( responseData.data );
	
	var updateStoreForm  = `<div class="row" style="padding: 3px;">
							<div class="col-md-12">
								<div class="row">
								<div class="col-md-4">
									<h3
										style="font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
										Add New Store</h3>
								</div>
								<div class="col-md-8">
									<button type="button" onclick="saveStore(${data.id});" class="btn btn-primary float-right" >
										Save
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
													name="storeName" required="required" value="${data.storeName}" placeholder="" maxlength="50" disabled>
												<label for="" class="inputlab">Store Name</label>
											</div>
										</div>
										<div class="col-md-6" id="productCategoryListInput">
											<div class="input_div">
									<select style="max-height: 7vh;padding: 11px;max-width: 18vw;" id="productCategory" class="inputTxt" required="required" disabled>
							<option value="${data.productSellCategory.productCatId}">${data.productSellCategory.categoryName}</option>
								</select>
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-6">
											<div class="input_div">
												<input type="email" class="inputTxt" id="storeEmail"
													name="storeEmail" value="${data.storeEmail}" required="required" placeholder="" maxlength="50">
												<label for="" class="inputlab">Store Email</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" rows="4" cols="50" class="inputTxt" id="storeDescrption"
													name="storeDescrption" value="${data.storeDescription}" required="required" placeholder="" maxlength="200">
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
													name="storePinCode" required="required" placeholder="" value="${data.zipCode}" maxlength="12" onchange=\"verifyPinCode();\">
												<label for="" class="inputlab">Store Pincode</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeAddress"
													name="storeAddress" required="required" value="${data.address}" placeholder="" maxlength="100">
												<label for="" class="inputlab">Store Address</label>
											</div>
										</div>
									</div>
									<div class="row" id="storeAdressDetails">
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeState"
													name="storeState" required="required"  value="${data.state}"  placeholder="" disabled readonly>
												<label for="" class="inputlab">State</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="storeCity"
													name="storeCity" required="required" value="${data.city}" placeholder="" disabled readonly>
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
													name="StoreOwnerPan" required="required" placeholder="" value="${data.sellerPanNumber}" maxlength="20">
												<label for="" class="inputlab">Owner Pan Number</label>
												
											</div>
<button type="button" class="fa fa-info-circle" data-toggle="tooltip" data-html="true" title="PAN is an electronic system through which, all tax related information for a person/company is recorded against a single PAN number. This acts as the primary key for storage of information and is shared across the country. Hence no two tax paying entities can have the same PAN. For example: QWERT1234Q"></button>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="StoreGSTIN"
													name="StoreGSTIN" required="required" value="${data.gstinNumber}" placeholder="">
												<label for="" class="inputlab">GST Number</label>
											</div>
<button type="button" class="fa fa-info-circle" data-toggle="tooltip" data-html="true" title="For example: 37AADCS0472N1Z1"></button>
											
										</div>
									</div>
									<div class="row">
										<div class="col-md-6">
											<div class="mb-3">
											<img src="${data.logoURL}" class="store_logo" alt="No img">		
											  </div>
									<div class="mb-3">
												<label for="formFile" class="form-label">Update Store Logo</label>
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
													name="accountHolderName" required="required" value="${data.storeAccountHolderName}" placeholder="" maxlength="50">
												<label for="" class="inputlab">Account Holder Name</label>
											</div>
										</div>
										<div class="col-md-6" id="accountypeInputField">
								<div class="input_div">
												<input type="text" class="inputTxt" id="accountType"
													name="accountType" required="required" value="${data.bankAccountType}" placeholder="" maxlength="50" disabled>
												<label for="" class="inputlab">Account type</label>
											</div>
										</div>
									</div>
									<div class="row">
									<div class="col-md-6">
											<div class="input_div">
												<input type="password" class="inputTxt" id="storeOwnerAccountNumber"
													name="storeOwnerAccountNumber" value="${data.storeAccountNumber}" required="required" placeholder="" maxlength="20">
												<label for="" class="inputlab">Account Number</label>
											</div>
										</div>
										<div class="col-md-6">
											<div class="input_div">
												<input type="text" class="inputTxt" id="confirmStoreOwnerAccNumber"
													name="confirmStoreOwnerAccNumber" value="${data.storeAccountNumber}" required="required" placeholder="" onchange="passwordMatcher()"; maxlength="20">
												<label for="" class="inputlab">Confirm Account Number</label>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						</div>`;
	
//		console.log(updateStoreForm)
	document.getElementById("workSpace").innerHTML = updateStoreForm;

		}
        });
		
	}
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


function saveStore(storeId){
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
if(storeId ==null || storeId ==""){
	obj.url = "store/saveStore";
}else{
	obj.url = "store/updateStore/"+storeId+"";
} 
	obj.data = formData;
	obj.enctype ="multipart/form-data";   
	obj.contentType = false;
    obj.processData = false;
	obj.dataType= "json";
	
	obj.requestData(function(responseData){
		console.log(responseData);
		if(responseData.status == "OK" || responseData.status == "ok"){
		swal({
				  title: "Congrats !",
  				  text: responseData.message,
  				  icon: "success",
 				  button: "OK",
		});	
			}else{
swal({
				  title: "Failed !",
  				  text: responseData.message,
  				  icon: "warning",
 			   	 dangerMode: true,	
				  button: "OK",
		});			}
	});	
	}
}