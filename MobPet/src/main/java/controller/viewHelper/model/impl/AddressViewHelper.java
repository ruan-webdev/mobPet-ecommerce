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

		if (null != operation) {
			if (operation.equals("save")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
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
				
				String publicPlace = "";
				if (null != request.getParameter("publicPlace")) {
					try {
						publicPlace = request.getParameter("publicPlace");
					} catch (Exception ex) {
					}
				}
				
				String state = "";
				if (null != request.getParameter("state")) {
					try {
						state = request.getParameter("state");
					} catch (Exception ex) {
					}
				}
				
				String city = "";
				if (null != request.getParameter("city")) {
					try {
						city = request.getParameter("city");
					} catch (Exception ex) {
					}
				}
				
				String neighbourhood = "";
				if (null != request.getParameter("neighbourhood")) {
					try {
						neighbourhood = request.getParameter("neighbourhood");
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
				
				String complement = "";
				if (null != request.getParameter("complement")) {
					try {
						complement = request.getParameter("complement");
					} catch (Exception ex) {
					}
				}
				
				String type = "";
				if (null != request.getParameter("type")) {
					try {
						type = request.getParameter("type");
					} catch (Exception ex) {
					}
				}
				
				Address address = new Address();
				address.setCep(cep);
				address.setPublicPlace(publicPlace);
				address.setState(state);
				address.setCity(city);
				address.setNeighbourhood(neighbourhood);
				address.setNumber(number);
				address.setComplement(complement);
				if (type.equals("shipping")) {
					address.setType(AddressType.SHIPPING);
				} else if (type.equals("billing")) {
					address.setType(AddressType.BILLING);
				} else if (type.equals("shipping_and_billing")) {
					address.setType(AddressType.SHIPPING_AND_BILLING);
				}
				address.setActive(true);
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				address.setClient(client);
				
				return address;
			} else if (operation.equals("consult")) {
				int userId = 0;
				if (null != request.getParameter("userId")) {
					try {
						userId = Integer.valueOf(request.getParameter("userId"));
					} catch (Exception ex) {
					}
				}
				
				Address address = new Address();
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				address.setClient(client);
				
				return address;
			} else if (operation.equals("remove")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}
				
				Address address = new Address();
				
				address.setId(id);
				
				return address;
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
			
				String cep = "";
				if (null != request.getParameter("cep")) {
					try {
						cep = request.getParameter("cep");
					} catch (Exception ex) {
					}
				}
				
				String publicPlace = "";
				if (null != request.getParameter("publicPlace")) {
					try {
						publicPlace = request.getParameter("publicPlace");
					} catch (Exception ex) {
					}
				}
				
				String state = "";
				if (null != request.getParameter("state")) {
					try {
						state = request.getParameter("state");
					} catch (Exception ex) {
					}
				}
				
				String city = "";
				if (null != request.getParameter("city")) {
					try {
						city = request.getParameter("city");
					} catch (Exception ex) {
					}
				}
				
				String neighbourhood = "";
				if (null != request.getParameter("neighbourhood")) {
					try {
						neighbourhood = request.getParameter("neighbourhood");
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
				
				String complement = "";
				if (null != request.getParameter("complement")) {
					try {
						complement = request.getParameter("complement");
					} catch (Exception ex) {
					}
				}
				
				String type = "";
				if (null != request.getParameter("type")) {
					try {
						type = request.getParameter("type");
					} catch (Exception ex) {
					}
				}
				
				Address address = new Address();
				
				address.setId(id);
				address.setCep(cep);
				address.setPublicPlace(publicPlace);
				address.setState(state);
				address.setCity(city);
				address.setNeighbourhood(neighbourhood);
				address.setNumber(number);
				address.setComplement(complement);
				if (type.equals("shipping")) {
					address.setType(AddressType.SHIPPING);
				} else if (type.equals("billing")) {
					address.setType(AddressType.BILLING);
				} else if (type.equals("shipping_and_billing")) {
					address.setType(AddressType.SHIPPING_AND_BILLING);
				}
				address.setActive(true);
				
				Client client = new Client();
				
				User user = new User();
				user.setId(userId);
				
				client.setUser(user);
				
				address.setClient(client);
				
				address.setActive(true);
				
				return address;
			} else if (operation.equals("prepareUpdate")) {
				int id = 0;
				if (null != request.getParameter("id")) {
					try {
						id = Integer.valueOf(request.getParameter("id"));
					} catch (Exception ex) {
					}
				}
				
				Address address = new Address();
				
				address.setId(id);
				
				return address;
			}
		}
		
		return null;
	}

	public void setView(Result result, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String operation = request.getParameter("operation");

		if (operation.equals("save")) {
			Address address = (Address) result.getEntities().get(0);
			request.setAttribute("address", address);
			if (null == address) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("ecommerce/adicionarEndereco.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("ecommerce/adicionarEndereco.jsp").forward(request, response);
			}
		} else if (operation.equals("consult")) {
			List<DomainEntity> adresses = (List<DomainEntity>) result.getEntities();
			request.setAttribute("adresses", adresses);

			if (null == adresses) {
				return;
			}

			request.getRequestDispatcher("ecommerce/adicionarEndereco.jsp").forward(request, response);
		} else if (operation.equals("remove")) {
			Address address = (Address) result.getEntities().get(0);

			if (null == address) {
				return;
			}

			response.sendRedirect("ecommerce/adicionarEndereco.jsp");
		} else if (operation.equals("update")) {
			Address address = (Address) result.getEntities().get(0);
			request.setAttribute("address", address);
			if (null == address) {
				return;
			}
			if (null == result.getMessage()) {
				response.sendRedirect("ecommerce/adicionarEndereco.jsp");
			} else {
				String[] messages = result.getMessage().trim().split("\n");
				request.setAttribute("messages", messages);
				request.getRequestDispatcher("ecommerce/adicionarEndereco.jsp").forward(request, response);
			}
		} else if (operation.equals("prepareUpdate")) {
			Address address = (Address) result.getEntities().get(0);

			if (null == address) {
				return;
			}
			
			request.setAttribute("address", address);

			request.getRequestDispatcher("ecommerce/adicionarEndereco.jsp").forward(request, response);
		}
	}

}
