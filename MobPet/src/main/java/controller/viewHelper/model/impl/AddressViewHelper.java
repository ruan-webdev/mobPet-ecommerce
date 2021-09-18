package controller.viewHelper.model.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.viewHelper.model.IViewHelper;
import domain.client.Address;
import domain.client.AddressType;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Result;
import domain.client.User;

public class AddressViewHelper implements IViewHelper {

	public DomainEntity getEntity(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String operation = request.getParameter("operation");
		System.out.println("operacao = "+operation);

		if (null != operation) {
			if (operation.equals("save")) {
				
				String estado = "";
				if (null != request.getParameter("estado")) {
					try {
						estado = request.getParameter("estado");
					} catch (Exception ex) {
					}
				}

				String cep = "";
				if (null != request.getParameter("cep")) {
					try {
						cep = request.getParameter("cep");
					} catch (Exception ex) {
					}
				}

				String cidade = "";
				if (null != request.getParameter("cidade")) {
					try {
						cidade = request.getParameter("cidade");
					} catch (Exception ex) {
					}
				}

				String bairro = "";
				if (null != request.getParameter("bairro")) {
					try {
						bairro = request.getParameter("bairro");
					} catch (Exception ex) {
					}
				}

				String logradouro = "";
				if (null != request.getParameter("logradouro")) {
					try {
						logradouro = request.getParameter("logradouro");
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

				String complemento = "";
				if (null != request.getParameter("complemento")) {
					try {
						complemento = request.getParameter("complemento");
					} catch (Exception ex) {
					}
				}

				String tipo = "";
				if (null != request.getParameter("tipo")) {
					try {
						tipo = request.getParameter("tipo");
					} catch (Exception ex) {
					}
				}

				String nomePerso = "";
				if (null != request.getParameter("nomePerso")) {
					try {
						nomePerso = request.getParameter("nomePerso");
					} catch (Exception ex) {
					}
				}

				Address endereco = new Address();
				endereco.setEstado(estado);
				endereco.setCep(cep);
				endereco.setCidade(cidade);
				endereco.setBairro(bairro);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(num);
				endereco.setComplemento(complemento);
				endereco.setApelido(nomePerso);
				if (tipo.equals("entrega")) {
					endereco.setTipoEndereco(AddressType.ENTREGA);
				} else if (tipo.equals("cobranca")) {
					endereco.setTipoEndereco(AddressType.COBRANCA);
				} else if (tipo.equals("cobranca_entrega")) {
					endereco.setTipoEndereco(AddressType.COBRANCA_ENTREGA);
				}

				Client cliente = new Client();

				User usuario = new User();
			
				cliente.setUsuario(usuario);

				endereco.setCliente(cliente);

				return endereco;

			} else if (operation.equals("consult")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}

				Address endereco = new Address();

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(userId);

				cliente.setUsuario(usuario);

				endereco.setCliente(cliente);

				return endereco;

			} else if (operation.equals("remove")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}

				Address endereco = new Address();

				endereco.setId(id);

				return endereco;

			} else if (operation.equals("update")) {

				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}

			
				String estado = "";
				if (null != request.getParameter("estado")) {
					try {
						estado = request.getParameter("estado");
					} catch (Exception ex) {
					}
				}

				String cep = "";
				if (null != request.getParameter("cep")) {
					try {
						cep = request.getParameter("cep");
					} catch (Exception ex) {
					}
				}

				String cidade = "";
				if (null != request.getParameter("cidade")) {
					try {
						cidade = request.getParameter("cidade");
					} catch (Exception ex) {
					}
				}

				String bairro = "";
				if (null != request.getParameter("bairro")) {
					try {
						bairro = request.getParameter("bairro");
					} catch (Exception ex) {
					}
				}

				String logradouro = "";
				if (null != request.getParameter("logradouro")) {
					try {
						bairro = request.getParameter("logradouro");
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

				String complemento = "";
				if (null != request.getParameter("complemento")) {
					try {
						complemento = request.getParameter("complemento");
					} catch (Exception ex) {
					}
				}

				String tipo = "";
				if (null != request.getParameter("tipo")) {
					try {
						tipo = request.getParameter("tipo");
					} catch (Exception ex) {
					}
				}

				String nomePerso = "";
				if (null != request.getParameter("nomePerso")) {
					try {
						nomePerso = request.getParameter("nomePerso");
					} catch (Exception ex) {
					}
				}

				Address endereco = new Address();
				endereco.setEstado(estado);
				endereco.setCep(cep);
				endereco.setCidade(cidade);
				endereco.setBairro(bairro);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(num);
				endereco.setComplemento(complemento);
				endereco.setApelido(nomePerso);
				if (tipo.equals("entrega")) {
					endereco.setTipoEndereco(AddressType.ENTREGA);
				} else if (tipo.equals("cobranca")) {
					endereco.setTipoEndereco(AddressType.COBRANCA);
				} else if (tipo.equals("cobranca_entrega")) {
					endereco.setTipoEndereco(AddressType.COBRANCA_ENTREGA);
				}

				Client cliente = new Client();

				User usuario = new User();
				usuario.setId(userId);

				cliente.setUsuario(usuario);

				endereco.setCliente(cliente);

				return endereco;

			} else if (operation.equals("prepareUpdate")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}

				Address endereco = new Address();

				endereco.setId(id);

				return endereco;
			}
		}

		return null;
	}

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			Address endereco = (Address) result.getEntities().get(0);
			request.setAttribute("address", endereco);
			if (null == endereco) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("adicionarEndereco.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("adicionarEndereco.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			List<DomainEntity> adresses = (List<DomainEntity>) result.getEntities();
			request.setAttribute("adresses", adresses);

			if (null == adresses) {
				return;
			}

			request.getRequestDispatcher("adicionarEndereco.jsp").forward(request, response);
		} else if (operation.equals("remove")) {
			Address endereco = (Address) result.getEntities().get(0);

			if (null == endereco) {
				return;
			}

			response.sendRedirect("adicionarEndereco.jsp");
		} else if (operation.equals("update")) {
			Address endereco = (Address) result.getEntities().get(0);
			request.setAttribute("address", endereco);
			if (null == endereco) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("adicionarEndereco.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("adicionarEndereco.jsp").forward(request, response);
			}
		} else if (operation.equals("prepareUpdate")) {
			Address endereco = (Address) result.getEntities().get(0);

			if (null == endereco) {
				return;
			}

			request.setAttribute("endereco", endereco);

			request.getRequestDispatcher("adicionarEndereco.jsp").forward(request, response);
		}
	}

}
