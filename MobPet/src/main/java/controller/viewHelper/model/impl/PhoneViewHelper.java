package controller.viewHelper.model.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.viewHelper.model.IViewHelper;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Phone;
import domain.client.Result;
import domain.client.User;

public class PhoneViewHelper implements IViewHelper {
	public DomainEntity getEntity(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String operation = request.getParameter("operation");

		if (null != operation) {
			if (operation.equals("save")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}
				
				String number = "";
				if (null != request.getParameter("number")) {
					try {
						number = request.getParameter("number");
					} catch (Exception ex) {
					}
				}
				
				Phone phone = new Phone();
				phone.setNumber(number);
				phone.setActive(true);
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				phone.setClient(client);
				
				return phone;
			} else if (operation.equals("consult")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}
				
				Phone phone = new Phone();
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				phone.setClient(client);
				
				return phone;
			} else if (operation.equals("remove")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}
			
				String number = "";
				if (null != request.getParameter("number")) {
					try {
						number = request.getParameter("number");
					} catch (Exception ex) {
					}
				}
				
				Phone phone = new Phone();
				
				phone.setId(id);
				phone.setNumber(number);
				
				return phone;
			} else if (operation.equals("update")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}
				
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}
			
				String number = "";
				if (null != request.getParameter("number")) {
					try {
						number = request.getParameter("number");
					} catch (Exception ex) {
					}
				}
				
				Phone phone = new Phone();
				
				phone.setId(id);
				phone.setNumber(number);
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				phone.setClient(client);
				
				phone.setActive(true);
				
				return phone;
			} else if (operation.equals("prepareUpdate")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}
				
				Phone phone = new Phone();
				
				phone.setId(id);
				
				return phone;
			}
		} 
		
		return null;
	}

	
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			Phone phone = (Phone) result.getEntities().get(0);
			request.setAttribute("phone", phone);
			if (null == phone) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("new-phone-success.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("new-phone.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			List<DomainEntity> phones = (List<DomainEntity>) result.getEntities();
			request.setAttribute("phones", phones);

			if (null == phones) {
				return;
			}

			request.getRequestDispatcher("account-phones.jsp").forward(request, response);
		} else if (operation.equals("remove")) {
			Phone phone = (Phone) result.getEntities().get(0);

			if (null == phone) {
				return;
			}

			response.sendRedirect("remove-phone-success.jsp");
		} else if (operation.equals("update")) {
			Phone phone = (Phone) result.getEntities().get(0);
			request.setAttribute("phone", phone);
			if (null == phone) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("update-phone-success.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("update-phone.jsp").forward(request, response);
			}
		} else if (operation.equals("prepareUpdate")) {
			Phone phone = (Phone) result.getEntities().get(0);

			if (null == phone) {
				return;
			}
			
			request.setAttribute("phone", phone);

			request.getRequestDispatcher("update-phone.jsp").forward(request, response);
		}
	}
}
