					<!-- Loader DIV -->
					<div class="loader-background"></div>
					<div class="processingLoader text-center">
						<div class="showbox">
							<div class="loader">
								<svg class="circular" viewBox="25 25 50 50">
    <circle class="path" cx="50" cy="50" r="20" fill="none"
										stroke-width="2" stroke-miterlimit="10" />
    </svg>
							</div>
						</div>
					</div>
					<!-- Loader DIV -->

					<div class="toast" id="epictoast" role="alert"
						aria-live="assertive" aria-atomic="true"
						style="position: absolute; top: 20px; right: 20px;"></div>

				</div>
				<!-- WorKSPACE -->

			</div>
		</div>
	</div>
	<!-- Cointainer -->


<script>

function toggleSpinnerOn(){    
	$(".processingLoader").show();
	$("#workSpace").css("opacity","0.5");
}
function toggleSpinnerOff(){
	$(".processingLoader").hide();	    
	$("#workSpace").css("opacity","5");
}



$(document).ready( function () {  
	console.log("I am Data Table ");
    $('#storeListUser').DataTable();  
} )  


</script>


<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.2/js/jquery.dataTables.js"></script>

<!-- 	<script
		src="https://cdn.datatables.net/responsive/2.2.9/js/dataTables.responsive.min.js"></script>
 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>