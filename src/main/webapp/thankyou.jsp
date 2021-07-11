<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank you Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body  style="background-color: #60a3bc">
	<form action="/kk-online-store/mc" method="post">
		<div>
			<div class="d-flex justify-content-center mt-3">
				<button type="submit" name="action" class="btn btn-info" value="help">Help</button>
				<button type="submit" name="action" class="btn btn-danger" value="logout">Logout</button>
			</div>
			<div class="jumbotron text-center">
				<h1 class="display-3">Thank You!</h1>
				<p class="lead">
					<strong>Please check your email</strong> for further instructions
					on how to complete your account setup.
				</p>
				<hr>
				<p>
					Having trouble? <a href="">Contact us</a>
				</p>
				<p class="lead">
					<a class="btn btn-primary btn-sm" href="#" role="button">Continue
						to homepage</a>
				</p>
			</div>
		</div>
		<input type="hidden" name="page" value="thankyou" />
	</form>
</body>
</html>