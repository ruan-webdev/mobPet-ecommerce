package controller.viewHelper.model.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.viewHelper.model.IViewHelper;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Gender;
import domain.client.Result;
import domain.client.User;
import domain.client.UserRole;

public class ClientViewHelper implements IViewHelper {

	public DomainEntity getEntity(HttpServletRequest request) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String operation = request.getParameter("operation");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (null != operation) {
			if (operation.equals("save")) {
				String name = null;
				if (null != request.getParameter("name")) {
					try {
						name = request.getParameter("name");
					} catch (Exception ex) {
					}
				}

				String cpf = null;
				if (null != request.getParameter("cpf")) {
					try {
						cpf = request.getParameter("cpf").replaceAll("\\.", "").replaceAll("-", "");
					} catch (Exception ex) {
					}
				}

				LocalDate dateOfBirth = null;
				if (null != request.getParameter("dateOfBirth")) {
					try {
						dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), dateTimeFormatter);
					} catch (Exception ex) {
					}
				}

				String email = null;
				if (null != request.getParameter("email")) {
					try {
						email = request.getParameter("email");
					} catch (Exception ex) {
					}
				}

				String password = null;
				if (null != request.getParameter("password")) {
					try {
						password = request.getParameter("password");
					} catch (Exception ex) {
					}
				}

				String confirmPassword = null;
				if (null != request.getParameter("confirmPassword")) {
					try {
						confirmPassword = request.getParameter("confirmPassword");
					} catch (Exception ex) {
					}
				}

				Gender gender = null;
				if (null != request.getParameter("gender")) {
					try {
						if (request.getParameter("gender").charAt(0) == 'm') {
							gender = Gender.MALE;
						} else if (request.getParameter("gender").charAt(0) == 'f') {
							gender = Gender.FEMALE;
						}
					} catch (Exception ex) {
					}
				}

				Client client = new Client();
				client.setName(name);
				client.setCpf(cpf);
				client.setDateOfBirth(dateOfBirth);

				User user = new User();
				user.setEmail(email);
				user.setPassword(password);
				user.setConfirmPassword(confirmPassword);
				user.setRole(UserRole.CLIENT);
				user.setActive(true);

				client.setUser(user);
				client.setGender(gender);

				return client;
			} else if (operation.equals("consult")) {
				int clientUserId = 0;
				if (null != request.getParameter("userId")) {
					try {
						clientUserId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}

				Client client = new Client();

				User user = new User();
				user.setId(clientUserId);

				client.setUser(user);

				return client;
			} else if (operation.equals("update")) {
				String name = null;
				if (null != request.getParameter("name")) {
					try {
						name = request.getParameter("name");
					} catch (Exception ex) {
					}
				}

				String cpf = null;
				if (null != request.getParameter("cpf")) {
					try {
						cpf = request.getParameter("cpf").replaceAll("\\.", "").replaceAll("-", "");
					} catch (Exception ex) {
					}
				}

				LocalDate dateOfBirth = null;
				if (null != request.getParameter("dateOfBirth")) {
					try {
						dateOfBirth = LocalDate.parse(request.getParameter("dateOfBirth"), dateTimeFormatter);
					} catch (Exception ex) {
					}
				}

				String email = null;
				if (null != request.getParameter("email")) {
					try {
						email = request.getParameter("email");
					} catch (Exception ex) {
					}
				}

				String password = null;
				if (null != request.getParameter("password")) {
					try {
						password = request.getParameter("password");
					} catch (Exception ex) {
					}
				}

				String confirmPassword = null;
				if (null != request.getParameter("confirmPassword")) {
					try {
						confirmPassword = request.getParameter("confirmPassword");
					} catch (Exception ex) {
					}
				}

				Gender gender = null;
				if (null != request.getParameter("gender")) {
					try {
						if (request.getParameter("gender").charAt(0) == 'm') {
							gender = Gender.MALE;
						} else if (request.getParameter("gender").charAt(0) == 'f') {
							gender = Gender.FEMALE;
						}
					} catch (Exception ex) {
					}
				}

				int clientUserId = 0;
				if (null != request.getParameter("clientUserId")) {
					try {
						clientUserId = Integer.valueOf(request.getParameter("clientUserId"));
					} catch (Exception ex) {
					}
				}

				int clientId = 0;
				if (null != request.getParameter("clientId")) {
					try {
						clientId = Integer.valueOf(request.getParameter("clientId"));
					} catch (Exception ex) {
					}
				}

				Client client = new Client();
				client.setId(clientId);
				client.setName(name);
				client.setCpf(cpf);
				client.setDateOfBirth(dateOfBirth);

				User user = new User();
				user.setId(clientUserId);
				user.setEmail(email);
				user.setPassword(password);
				user.setConfirmPassword(confirmPassword);
				user.setRole(UserRole.CLIENT);
				user.setActive(true);

				client.setUser(user);
				client.setGender(gender);

				return client;
			}
		}

		return null;

	}

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			Client client = (Client) result.getEntities().get(0);
			request.setAttribute("client", client);
			if (null == client) {
				return;
			}
			if (null == result.getMessage()) {
				request.getRequestDispatcher("ecommerce/login.jsp").forward(request, response);
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("ecommerce/cadastro.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			Client client = (Client) result.getEntities().get(0);
			request.setAttribute("client", client);
			if (null == client) {
				return;
			}

			request.getRequestDispatcher("ecommerce/perfilCliente.jsp").forward(request, response);
		} else if (operation.equals("update")) {
			Client client = (Client) result.getEntities().get(0);
			request.setAttribute("client", client);
			if (null == client) {
				return;
			}
			if (null == result.getMessage()) {
				request.getSession().setAttribute("loggedUser", client.getUser());
				request.getRequestDispatcher("ecommerce/perfilCliente.jsp").forward(request, response);
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("ecommerce/perfilCliente.jsp").forward(request, response);
			}
		}
	}

}