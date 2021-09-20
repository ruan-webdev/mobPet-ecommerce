package controller.viewHelper.model.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.viewHelper.model.IViewHelper;
import domain.client.Client;
import domain.client.CreditCard;
import domain.client.DomainEntity;
import domain.client.Result;
import domain.client.User;

public class CreditCardViewHelper implements IViewHelper {


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

					LocalDate expirationDate = null;
					if (null != request.getParameter("expirationDate")) {
						try {
							expirationDate = LocalDate.parse(request.getParameter("expirationDate"), dateTimeFormatter);
						} catch (Exception ex) {
						}
					}

					String securityCode = "";
					if (null != request.getParameter("securityCode")) {
						try {
							securityCode = request.getParameter("securityCode");
						} catch (Exception ex) {
						}
					}

					String printedName = "";
					if (null != request.getParameter("printedName")) {
						try {
							printedName = request.getParameter("printedName");
						} catch (Exception ex) {
						}
					}

					CreditCard creditCard = new CreditCard();

					creditCard.setNumber(number);
					creditCard.setExpirationDate(expirationDate);
					creditCard.setSecurityCode(securityCode);
					creditCard.setPrintedName(printedName);

					Client client = new Client();

					User user = new User();
					user.setId(userId);

					client.setUser(user);

					creditCard.setClient(client);
					creditCard.setActive(true);

					return creditCard;
				} else if (operation.equals("consult")) {
					int userId = 0;
					if (null != request.getParameter("userId")) {
						try {
							userId = Integer.valueOf(request.getParameter("userId"));
						} catch (Exception ex) {
						}
					}

					CreditCard creditCard = new CreditCard();

					Client client = new Client();

					User user = new User();
					user.setId(userId);

					client.setUser(user);

					creditCard.setClient(client);

					return creditCard;
				} else if (operation.equals("remove")) {
					int id = 0;
					if (null != request.getParameter("id")) {
						try {
							id = Integer.valueOf(request.getParameter("id"));
						} catch (Exception ex) {
						}
					}

					CreditCard creditCard = new CreditCard();

					creditCard.setId(id);

					return creditCard;
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

					LocalDate expirationDate = null;
					if (null != request.getParameter("expirationDate")) {
						try {
							expirationDate = LocalDate.parse(request.getParameter("expirationDate"), dateTimeFormatter);
						} catch (Exception ex) {
						}
					}

					String securityCode = "";
					if (null != request.getParameter("securityCode")) {
						try {
							securityCode = request.getParameter("securityCode");
						} catch (Exception ex) {
						}
					}

					String printedName = "";
					if (null != request.getParameter("printedName")) {
						try {
							printedName = request.getParameter("printedName");
						} catch (Exception ex) {
						}
					}

					CreditCard creditCard = new CreditCard();

					creditCard.setId(id);
					creditCard.setNumber(number);
					creditCard.setExpirationDate(expirationDate);
					creditCard.setSecurityCode(securityCode);
					creditCard.setPrintedName(printedName);

					Client client = new Client();

					User user = new User();
					user.setId(userId);

					client.setUser(user);

					creditCard.setClient(client);

					creditCard.setActive(true);

					return creditCard;
				} else if (operation.equals("prepareUpdate")) {
					int id = 0;
					if (null != request.getParameter("id")) {
						try {
							id = Integer.valueOf(request.getParameter("id"));
						} catch (Exception ex) {
						}
					}

					CreditCard creditCard = new CreditCard();

					creditCard.setId(id);

					return creditCard;
				}
			}

			return null;
		}

	
		public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			String operation = request.getParameter("operation");

			if (operation.equals("save")) {
				CreditCard creditCard = (CreditCard) result.getEntities().get(0);
				request.setAttribute("creditCard", creditCard);
				if (null == creditCard) {
					return;
				}
				if (null == result.getMessage()) {
					response.sendRedirect("new-credit-card-success.jsp");
				} else {
					String[] messages = result.getMessage().trim().split("\n");
					request.setAttribute("messages", messages);
					request.getRequestDispatcher("new-credit-card.jsp").forward(request, response);
				}
			} else if (operation.equals("consult")) {
				List<DomainEntity> creditCards = (List<DomainEntity>) result.getEntities();
				request.setAttribute("creditCards", creditCards);

				if (null == creditCards) {
					return;
				}

				request.getRequestDispatcher("account-credit-cards.jsp").forward(request, response);
			} else if (operation.equals("remove")) {
				CreditCard creditCards = (CreditCard) result.getEntities().get(0);

				if (null == creditCards) {
					return;
				}

				response.sendRedirect("remove-credit-card-success.jsp");
			} else if (operation.equals("update")) {
				CreditCard creditCard = (CreditCard) result.getEntities().get(0);
				request.setAttribute("creditCard", creditCard);
				if (null == creditCard) {
					return;
				}
				if (null == result.getMessage()) {
					response.sendRedirect("update-credit-card-success.jsp");
				} else {
					String[] messages = result.getMessage().trim().split("\n");
					request.setAttribute("messages", messages);
					request.getRequestDispatcher("update-credit-card.jsp").forward(request, response);
				}
			} else if (operation.equals("prepareUpdate")) {
				CreditCard creditCard = (CreditCard) result.getEntities().get(0);

				if (null == creditCard) {
					return;
				}

				request.setAttribute("creditCard", creditCard);

				request.getRequestDispatcher("update-credit-card.jsp").forward(request, response);
			}
		}

}
