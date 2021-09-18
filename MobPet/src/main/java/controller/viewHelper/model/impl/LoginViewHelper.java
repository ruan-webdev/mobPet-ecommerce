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
import domain.client.UserType;

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

				String senha = "";
				if (null != request.getParameter("senha")) {
					try {
						senha = request.getParameter("senha");
					} catch (Exception ex) {
					}
				}

				User usuario = new User();
				usuario.setEmail(email);
				usuario.setSenha(senha);

				return usuario;
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
				
				if (resultUser.getTipoUsuario() == UserType.CLIENT) {
					response.sendRedirect("Mobpet/ecommerce/signed.jsp");
					return;
				} else {
					// TODO admin
					return;
				}
			} else {
				String message = "E-mail e/ou senha inválidos!";
				request.setAttribute("message", message);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}


}