/**
 * 
 */


function storeForm(){
	let storeForm = ``;
	
	document.getElementById("workSpace").innerHTML = storeForm;

}

function saveStore(){
 
let formData = new FormData();

var file = $("#logoURL").val();
	if(file == undefined || file=="" || file ==null){
		console.log("File is Empty if")
		var error= "Please Enter logo Image";
		var head = "Failed to Save"
//		toastDangerAlert(head,error);
		displayFailedToast(head,error);

	}else{
//	console.log("FILE:::::::::::::::::::: " + file)
	formData.append("storeName", $("#storeName").val());
	formData.append("address", $("#address").val());
	formData.append("storeDescription", $("#storeDescription").val());
	formData.append("storeOpenTime", $("#storeOpenTime").val());
	formData.append('logoFile', $('input[type=file]')[0].files[0]);
//	formData.append('logoFile', $("#logoURL").val());

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
//			toastSuccessAlert(responseData.message);
			displaySuccessToast("Success",responseData.message);
			console.log(responseData)
		}else{
//			toastDangerAlert("Failed",responseData.message)
		displayFailedToast("Failed",responseData.message);
			console.log(responseData)
		}
	});	
	}
}