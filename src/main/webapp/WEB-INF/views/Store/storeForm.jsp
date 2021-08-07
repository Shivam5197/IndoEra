<%@include file="/WEB-INF/views/Store/StoreTemplet/Header.jsp"%>

<%-- <script src="<c:url value="/resources/js/testEstimation/TestEstimationPhases.js"/>"></script> --%>
<script type="text/javascript" charset="utf8"
	src="<c:url value="/js/storejs/storejs.js"/>"></script>

<!-- Content wrapper start -->
<div class="content-wrapper">

	<div class="card myCard align-middle">
		<h1 class=" header" style="text-align: center;">Add New Store</h1>
		<form name="storeForms" method="POST" enctype="multipart/form-data">
			<!-- Hidden For Update employee  -->
			<input type="hidden" />
			<!-- First row -->
			<div class="formformating">
				<div class="input_div">
					<input type="text" class="inputTxt" id="storeName" name="storeName"
						required="required" placeholder=""> <label for=""
						class="inputlab">Store Name</label>
				</div>
			</div>

			<div class="formformating">
				<div class="input_div">
					<textarea type="text" style="padding: 15px 0;" class="inputTxt"
						id="storeDescription" name="storeDescription" placeholder=""></textarea>
					<label for="" class="inputlab">Store Description</label>
				</div>
			</div>

			<div class=" row formformating">
				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="country" name="country"
						placeholder=""> <label for="" class="inputlab">Country</label>
				</div>

				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="city" name="city"
						placeholder=""> <label for="" class="inputlab">City</label>
				</div>
			</div>

			<div class=" row formformating">
				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="street" name="street"
						placeholder=""> <label for="" class="inputlab">Street</label>
				</div>

				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="address" name="address"
						placeholder=""> <label for="" class="inputlab">Address</label>
				</div>
			</div>
			<div class=" row formformating">
				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="zipCode" name="zipCode"
						placeholder=""> <label for="" class="inputlab">Zip
						Code</label>
				</div>

				<div class="input_div_fifty">
					<input type="text" class="inputTxt" id="storeOpenTime"
						name="storeOpenTime" placeholder=""> <label for=""
						class="inputlab">Store Timings</label>
				</div>
			</div>
			<input type="file" id="logoURL" name="file" />

			<!-- Submit button container -->
			<div class="text-right">
				<!-- text-right = text-align: right -->
				<input class="btn btn-primary" type="button" onclick="saveStore()"
					value="Add Store">
			</div>
		</form>

	</div>









</div>
<!-- Content wrapper end -->

<%@include file="/WEB-INF/views/Store/StoreTemplet/Footer.jsp"%>