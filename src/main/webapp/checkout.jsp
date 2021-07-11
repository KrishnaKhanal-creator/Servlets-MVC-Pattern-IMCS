<%@page import="java.util.*, com.kk.onlinestore.domain.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background-color: #60a3bc">
	<div class="d-flex justify-content-center mt-3">
		<form method="post" action="/kk-online-store/mc">
			<input type="hidden" name="page" value="checkout" />
			<div>
				<button type="submit" name="action" class="btn btn-info" value="help">Help</button>
				<button type="submit" name="action" class="btn btn-danger" value="logout">Logout</button>
			</div>
			<table class="table">
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Total Price</th>
				</tr>
				<%
				List<Item> cart = (List<Item>) session.getAttribute("cart");
				float total = 0;
				for (Item item : cart) {
					float cost = item.getPrice() * (float) item.getQuantity();
					total = total + cost;
				%>

				<tr>
					<td><%=item.getName()%></td>
					<td><%=item.getPrice()%></td>
					<td><%=item.getQuantity()%></td>
					<td><%=cost%></td>

				</tr>

				<%
				}
				%>
				<tr>
					<td>Grand Total</td>
					<td></td>
					<td></td>
					<td>$<%=total%></td>

				</tr>

			</table>
			<hr>

			<button type="submit" name="action" class="btn btn-primary" value="backTOCart">Back
				to Cart</button>


			<button type="submit" name="action" class="btn btn-success" value="checkout">Checkout</button>

		</form>
	</div>


</body>
</html>