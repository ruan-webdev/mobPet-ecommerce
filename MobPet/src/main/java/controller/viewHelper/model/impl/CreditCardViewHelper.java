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

				String num = "";
				if (null != request.getParameter("num")) {
					try {
						num = request.getParameter("num");
					} catch (Exception ex) {
					}
				}

				LocalDate validade = null;
				if (null != request.getParameter("validade")) {
					try {
						validade = LocalDate.parse(request.getParameter("validade"), dateTimeFormatter);
					} catch (Exception ex) {
					}
				}

				String codigo = "";
				if (null != request.getParameter("codigo")) {
					try {
						codigo = request.getParameter("codigo");
					} catch (Exception ex) {
					}
				}

				String nome = "";
				if (null != request.getParameter("nome")) {
					try {
						nome = request.getParameter("nome");
					} catch (Exception ex) {
					}
				}

				CreditCard cartaoCredito = new CreditCard();

				cartaoCredito.setNum(num);
				cartaoCredito.setValidade(validade);
				cartaoCredito.setCodigo(codigo);
				cartaoCredito.setNome(nome);

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(userId);

				cliente.setUsuario(usuario);

				cartaoCredito.setCliente(cliente);
				//cartaoCredito.setActive(true);

				return cartaoCredito;
				
			} else if (operation.equals("consult")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}

				CreditCard cartaoCredito = new CreditCard();

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(userId);

				cliente.setUsuario(usuario);

				cartaoCredito.setCliente(cliente);

				return cartaoCredito;
				
			} else if (operation.equals("remove")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}

				CreditCard cartaoCredito = new CreditCard();

				cartaoCredito.setId(id);

				return cartaoCredito;
				
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

				String num = "";
				if (null != request.getParameter("num")) {
					try {
						num = request.getParameter("num");
					} catch (Exception ex) {
					}
				}

				LocalDate validade = null;
				if (null != request.getParameter("validade")) {
					try {
						validade = LocalDate.parse(request.getParameter("validade"), dateTimeFormatter);
					} catch (Exception ex) {
					}
				}

				String codigo = "";
				if (null != request.getParameter("codigo")) {
					try {
						codigo = request.getParameter("codigo");
					} catch (Exception ex) {
					}
				}

				String nome = "";
				if (null != request.getParameter("nome")) {
					try {
						nome = request.getParameter("nome");
					} catch (Exception ex) {
					}
				}

				CreditCard cartaoCredito = new CreditCard();

				cartaoCredito.setNum(num);
				cartaoCredito.setValidade(validade);
				cartaoCredito.setCodigo(codigo);
				cartaoCredito.setNome(nome);

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(userId);

				cliente.setUsuario(usuario);

				cartaoCredito.setCliente(cliente);

				//cartaoCredito.setActive(true);

				return cartaoCredito;
				
			} else if (operation.equals("prepareUpdate")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}

				CreditCard cartaoCredito = new CreditCard();

				cartaoCredito.setId(id);

				return cartaoCredito;
			}
		}

		return null;
	}

	
	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			CreditCard cartaoCredito = (CreditCard) result.getEntities().get(0);
			request.setAttribute("creditCard", cartaoCredito);
			if (null == cartaoCredito) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("adicionarCartao.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("adicionarCartao.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			List<DomainEntity> cartaoCredito = (List<DomainEntity>) result.getEntities();
			request.setAttribute("creditCards", cartaoCredito);

			if (null == cartaoCredito) {
				return;
			}

			request.getRequestDispatcher("adicionarCartao.jsp").forward(request, response);
		} else if (operation.equals("remove")) {
			CreditCard cartaoCredito = (CreditCard) result.getEntities().get(0);

			if (null == cartaoCredito) {
				return;
			}

			response.sendRedirect("adicionarCartao.jsp");
		} else if (operation.equals("update")) {
			CreditCard cartaoCredito = (CreditCard) result.getEntities().get(0);
			request.setAttribute("creditCard", cartaoCredito);
			if (null == cartaoCredito) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("adicionarCartao.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("adicionarCartao.jsp").forward(request, response);
			}
		} else if (operation.equals("prepareUpdate")) {
			CreditCard cartaoCredito = (CreditCard) result.getEntities().get(0);

			if (null == cartaoCredito) {
				return;
			}

			request.setAttribute("creditCard", cartaoCredito);

			request.getRequestDispatcher("adicionarCartao.jsp").forward(request, response);
		}
	}

}
