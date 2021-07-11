<%@page import="java.util.*, com.kk.onlinestore.domain.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available items</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body style="background-color:#60a3bc !important">
	<div class="d-flex justify-content-center">
		<form method="post" action="/kk-online-store/mc">
			<div>
				<input type="hidden" name="page" value="items" />
			</div>
			<div class=" justify-content-center">
				<button type="submit" name="action" class="btn btn-info"
					value="help">Help</button>

				<button type="submit" name="action" class="btn btn-danger"
					value="logout">Logout</button>
			</div>
			<table class="table">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Unit Price</th>
					<th scope="col">Quantity</th>
				</tr>
				<%
				Collection<Item> items = (Collection<Item>) request.getAttribute("items");
				for (Item item : items) {
				%>
				<tr>
					<td><input type="checkbox" name="itemId"
						value="<%=item.getId()%>"></td>
					<td><%=item.getName()%></td>
					<td><%=item.getPrice()%></td>
					<td><input type="text" name="itemQuantity<%=item.getId()%>" /></td>
				</tr>
				<%
				}
				%>
			</table>
			<hr>

			<button type="submit" name="action" class="btn btn-primary"
				value="cart btn">Add to Cart</button>


			<button type="submit" name="action" class="btn btn-success"
				value="checkout btn">Checkout</button>

		</form>
	</div>


</body>
</html>