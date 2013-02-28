package com.fdm.webpages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.Controllers.WebPageController;

public class StartPage extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		WebPageController pageController = new WebPageController();
		String choice = request.getParameter("loginChoice");
		if (choice.equals("login")) {
			List inputs = new ArrayList();
			inputs.add(request.getParameter("usernameTextBox"));
			inputs.add(request.getParameter("passwordTextBox"));
			String result = pageController.getUserType(choice, inputs);
			inputs.clear();
			if (result.equals("Admin")) {
				request.setAttribute("styles", result);
				RequestDispatcher view = request
						.getRequestDispatcher("adminPage.jsp");
				view.forward(request, response);
			} else {
				request.setAttribute("styles", result);
				RequestDispatcher view = request
						.getRequestDispatcher("loginPage.jsp");
				view.forward(request, response);
			}
		}
		pageController.closeConnection();
	}
}
