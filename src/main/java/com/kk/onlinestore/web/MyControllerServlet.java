package com.kk.onlinestore.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kk.onlinestore.domain.Item;
import com.kk.onlinestore.service.ItemService;
import com.kk.onlinestore.service.LoginService;

public class MyControllerServlet extends HttpServlet {

	private LoginService loginService;
	private ItemService itemService;
	private HttpSession session = null;

	public void init() throws ServletException {
		loginService = new LoginService();
		itemService = new ItemService();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/login.jsp";
		String page = request.getParameter("page");
		String action = request.getParameter("action");
		

		if (page != null) {
			if (page.equalsIgnoreCase("login")) {
				if (action != null && action.equalsIgnoreCase("Login here btn")) {
					String username = request.getParameter("username");
					String password = request.getParameter("password");

					if (loginService.authenticate(username, password)) {
						nextPage = "/items.jsp";
						request.setAttribute("items", itemService.displayallItems());
						session = request.getSession(true);
					} else {
						nextPage = "/login.jsp";
						request.setAttribute("loginError", "Incorrect username or password");// data binding
					}

				} 

			}else if (page.equalsIgnoreCase("items")) {
				if (page != null) {
					if (action != null && action.equalsIgnoreCase("help")) {
						nextPage = "/help.jsp";
					} else if (action != null && action.equalsIgnoreCase("logout")) {
						request.setAttribute("logoutMsg", "Logout sucessfully");
						nextPage = "/login.jsp";
						session.invalidate();
					} else if (action != null && action.equalsIgnoreCase("cart btn")) {
						
						String[] itemId = request.getParameterValues("itemId");
						
						List<Item> listOfItemInACart = new ArrayList<Item>();
						
						for(String id : itemId) {
							
							Map<Integer, Item> itemDB = itemService.getItemDB();
							
							Integer itemID = new Integer(id);
							String itemName = itemDB.get(itemID).getName();
							Float itemPrice = itemDB.get(itemID).getPrice();
							Integer quantity = new Integer(request.getParameter("itemQuantity" + id));

							listOfItemInACart.add(new Item(itemID, itemName, itemPrice, quantity));
							
						}
						session.setAttribute("cart", listOfItemInACart);
						
						request.setAttribute("items", itemService.displayallItems());
						nextPage = "/items.jsp";
					} else if (action != null && action.equalsIgnoreCase("checkout btn")) {
						nextPage = "/checkout.jsp";
					} else{
						nextPage = "/items.jsp";
					}
				}
				
				
			} else if (page.equalsIgnoreCase("checkout")) {
				if (page != null) {
					if (action != null && action.equalsIgnoreCase("help")) {
						nextPage = "/help.jsp";
					} else if (action != null && action.equalsIgnoreCase("logout")) {
						request.setAttribute("logoutMsg", "Logout sucessfully");
						nextPage = "/login.jsp";
						session.invalidate();
					} else if (action != null && action.equalsIgnoreCase("backTOCart")) {
						request.setAttribute("items", itemService.displayallItems());
						nextPage = "/items.jsp";
					} else if (action != null && action.equalsIgnoreCase("checkout")) {
						nextPage = "/thankyou.jsp";
					} else{
						nextPage = "/checkout.jsp";
					}
				}
				
			}else if (page.equalsIgnoreCase("thankyou")) {
				if (page != null) {
					if (action != null && action.equalsIgnoreCase("help")) {
						nextPage = "/help.jsp";
					} else if (action != null && action.equalsIgnoreCase("logout")) {
						request.setAttribute("logoutMsg", "Logout sucessfully");
						nextPage = "/login.jsp";
						//session.invalidate();
					} else{
						nextPage = "/thankyou.jsp";
					}
				}
				
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}
	
}
