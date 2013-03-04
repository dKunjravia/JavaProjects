package com.fdm.webpages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.Controllers.CurrentUserDataController;
import com.fdm.DatabaseClasses.DatabaseConnection;

public class AdminPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			Connection connection = new DatabaseConnection().getDbConnection();
			CurrentUserDataController currentUsers= new CurrentUserDataController();
			String choice = request.getParameter("adminActionChoice");
			String username = request.getParameter("usenameTextBox");
			if (!choice.equals("logOff")) {
				try {
//					if(choice.equals("addUser"))
//						currentUsers.addUserToDatabase(user)
					if(choice.equals("deleteUser"))
						currentUsers.deleteUserFromDatabase(username);
					RequestDispatcher view = request
							.getRequestDispatcher("adminPage.jsp");
					view.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				RequestDispatcher view = request
						.getRequestDispatcher("loginPage.jsp");
				view.forward(request, response);
			}
			connection.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
