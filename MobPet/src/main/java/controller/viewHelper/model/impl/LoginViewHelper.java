package controller.viewHelper.model.impl;

import java.util.List;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.viewHelper.model.IViewHelper;
import domain.client.DomainEntity;
import domain.client.Result;
import domain.client.User;
import domain.client.UserRole;


public class LoginViewHelper implements IViewHelper {
	
	public DomainEntity getEntity(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String operation = request.getParameter("operation");

		if (null != operation) {
			if (operation.equals("login")) {
				String email = "";
				if (null != request.getParameter("email")) {
					try {
						email = request.getParameter("email");
					} catch (Exception ex) {
					}
				}

				String password = "";
				if (null != request.getParameter("password")) {
					try {
						password = request.getParameter("password");
					} catch (Exception ex) {
					}
				}

				User user = new User();
				user.setEmail(email);
				user.setPassword(password);

				return user;
			}
		}

		return null;
	}

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String operation = request.getParameter("operation");

		if (operation.equals("login")) {
			List<DomainEntity> resultEntities = result.getEntities();

			if (null == resultEntities) {
				return;
			}

			if (resultEntities.size() > 0) {
				User resultUser = (User) resultEntities.get(0);
				
				request.getSession().setAttribute("loggedUser", resultUser);
				
				if (resultUser.getRole() == UserRole.CLIENT) {
					response.sendRedirect("ecommerce/signed.jsp");
					return;
				} else {
					// TODO admin
					return;
				}
			} else {
				String message = "E-mail e/ou senha inválidos!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/ecommerce/login.jsp").forward(request, response);
			}
		}
	}


}