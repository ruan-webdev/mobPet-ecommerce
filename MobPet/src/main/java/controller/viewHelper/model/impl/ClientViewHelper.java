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
import domain.client.Result;
import domain.client.User;
import domain.client.UserType;

public class ClientViewHelper implements IViewHelper {

	public DomainEntity getEntity(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String operation = request.getParameter("operation");
		System.out.println("operacao = "+operation);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		if (null != operation) {
			if (operation.equals("save")) {
				String nome = null;
				if (null != request.getParameter("nome")) {
					try {
						nome = request.getParameter("nome");
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

				LocalDate dataNasc = null;
				if (null != request.getParameter("dataNascimento")) {
					try {
						dataNasc = LocalDate.parse(request.getParameter("dataNascimento"), dateTimeFormatter);
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
				
				String genero = null;
				if (null != request.getParameter("genero")) {
					try {
						genero = request.getParameter("genero");
					} catch (Exception ex) {
					}
				}
				

				String telefone = null;
				if (null != request.getParameter("telefone")) {
					try {
						telefone = request.getParameter("telefone");
					} catch (Exception ex) {
					}
				}

				String senha = null;
				if (null != request.getParameter("senha")) {
					try {
						senha = request.getParameter("senha");
					} catch (Exception ex) {
					}
				}

				String confirmarSenha = null;
				if (null != request.getParameter("confirmarSenha")) {
					try {
						confirmarSenha = request.getParameter("confirmarSenha");
					} catch (Exception ex) {
					}
				}

				Client cliente = new Client();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setDataNascimento(dataNasc);
				cliente.setGenero(genero);
				cliente.setTelefone(telefone);

				User usuario = new User();
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setConfirmarSenha(confirmarSenha);
				usuario.setTipoUsuario(UserType.CLIENT);
				usuario.setActive(true);

				cliente.setUsuario(usuario);

				return cliente;
			} else if (operation.equals("consult")) {
				int clientUserId = 0;
				if (null != request.getParameter("userId")) {
					try {
						clientUserId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(clientUserId);

				cliente.setUsuario(usuario);

				return cliente;

			} else if (operation.equals("update")) {
				String nome = null;
				if (null != request.getParameter("nome")) {
					try {
						nome = request.getParameter("nome");
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

				LocalDate dataNasc = null;
				if (null != request.getParameter("dataNascimento")) {
					try {
						dataNasc = LocalDate.parse(request.getParameter("dataNascimento"), dateTimeFormatter);
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

				String senha = null;
				if (null != request.getParameter("senha")) {
					try {
						senha = request.getParameter("senha");
					} catch (Exception ex) {
					}
				}

				String confirmarSenha = null;
				if (null != request.getParameter("confirmarSenha")) {
					try {
						confirmarSenha = request.getParameter("confirmarSenha");
					} catch (Exception ex) {
					}
				}

				String genero = null;
				if (null != request.getParameter("genero")) {
					try {
						genero = request.getParameter("genero");
					} catch (Exception ex) {

					}

				}
				Client cliente = new Client();

				cliente.setNome(nome);
				cliente.setCpf(cpf);
				cliente.setDataNascimento(dataNasc);

				User usuario = new User();
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setConfirmarSenha(confirmarSenha);
				usuario.setTipoUsuario(UserType.CLIENT);
				usuario.setActive(true);

				cliente.setUsuario(usuario);
				cliente.setGenero(genero);

				return cliente;
			}
		}

		return null;
	}

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			Client cliente = (Client) result.getEntities().get(0);
			request.setAttribute("client", cliente);
			if (null == cliente) {
				return;
			}
			if (null == result.getMessage()) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				for(String message: messages){
					System.out.println(message);
				}
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			Client cliente = (Client) result.getEntities().get(0);
			request.setAttribute("client", cliente);
			if (null == cliente) {
				return;
			}

			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (operation.equals("update")) {
			Client cliente = (Client) result.getEntities().get(0);
			request.setAttribute("client", cliente);
			if (null == cliente) {
				return;
			}
			if (null == result.getMessage()) {
				request.getSession().setAttribute("loggedUser", cliente.getUsuario());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}