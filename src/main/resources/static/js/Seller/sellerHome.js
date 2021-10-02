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
            console.log(data);
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
                        listUI += `<td><button class="btn btn-success">Active</button></td>`
                    } else {
                        listUI += `<td><button class="btn btn-dange">De-activated</button></td>`

                    }
                   /*<td>${data[i].storeStatus}</td>*/

						 listUI += `<td class="align-right"><i class="fas fa-ellipsis-v"  data-bs-toggle="dropdown"></i></td>

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
            //			noStoreFoundUI();
        }
    });
}