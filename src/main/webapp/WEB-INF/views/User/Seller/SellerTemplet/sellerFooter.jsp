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

//loader
function toggleSpinnerOn(){    
		$(".signUpCard").css("opacity","0.5");
		$(".processingLoader").show();
}
function toggleSpinnerOff(){
		$(".processingLoader").hide();	    
		$(".signUpCard").css("opacity","1");
}

$(document).ready( function () {
    $('#myTable').DataTable();
} );

</script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>