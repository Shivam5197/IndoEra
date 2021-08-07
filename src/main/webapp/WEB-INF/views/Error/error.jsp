<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ErrorOccured</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css"
	rel="stylesheet" />
</head>
<body>
	<h1 class="funny">Ohh No..........</h1>

	<div class="container-fluid">
		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<div class="w-400 mw-full">
					<!-- w-400 = width: 40rem (400px), mw-full = max-width: 100% -->
					<div class="card">
						<h2 class="card-title">Error Occured</h2>
						<h3>Hmmm....</h3>
						<p class="text-muted" style="color: red;">It looks like the
							developer fell asleep...</p>
						<div class="text-right">
							<!-- text-right = text-align: right -->
<button onclick="goBack()" class="btn">Go Back</button>

						</div>
					</div>
				</div>
			</div>
			<div class="col-4"></div>

		</div>
	</div>


	<hr>
	<hr>

 
<script>
function goBack() {
  window.history.back();
}
</script> 

</body>
</html>