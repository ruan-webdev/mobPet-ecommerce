package controller;

import controller.command.*;
import controller.command.impl.UpdateCommand;
import controller.command.impl.ConsultCommand;
import controller.command.impl.RemoveCommand;
import controller.command.impl.SaveCommand;
import controller.viewHelper.model.IViewHelper;
import controller.viewHelper.model.impl.CreditCardViewHelper;
import controller.viewHelper.model.impl.LoginViewHelper;
import domain.client.DomainEntity;
import domain.client.Result;
import controller.viewHelper.model.impl.AddressViewHelper;
import controller.viewHelper.model.impl.ClientViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = { "/cadastro", "/login", "/ecommerce", "/signed", "/perfilCliente", "/alterarSenha", "/adicionarCartao", "/adicionarEndereco"})
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, ICommand> commandsMap;
	private Map<String, IViewHelper> viewHelpersMap;

	public Servlet() {
		commandsMap = new HashMap<String, ICommand>();
		commandsMap.put("save", new SaveCommand());
		commandsMap.put("update", new UpdateCommand());
		commandsMap.put("consult", new ConsultCommand());
		commandsMap.put("login", new ConsultCommand());
		commandsMap.put("remove", new RemoveCommand());
		commandsMap.put("prepareUpdate", new ConsultCommand());

		viewHelpersMap = new HashMap<String, IViewHelper>();
		
		// client

		viewHelpersMap.put("../login", new LoginViewHelper());
		viewHelpersMap.put("/ecommerce/cadastro", new ClientViewHelper());
		viewHelpersMap.put("/MobPet/ecommerce/perfilCliente", new ClientViewHelper());
		viewHelpersMap.put("/MobPet/ecommerce/alterarSenha", new ClientViewHelper());
		viewHelpersMap.put("/ecommerce/signed", new ClientViewHelper());

		// credit card
		viewHelpersMap.put("/MobPet/ecommerce/adicionarCartao", new CreditCardViewHelper());
	
		// address
		viewHelpersMap.put("/MobPet/ecommerce/adicionarEndereco", new AddressViewHelper());

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getRequestURI().equals("/MobPet/ecommerce/logout")) {
			if (null != request.getSession().getAttribute("loggedUser")) {
				request.getSession().removeAttribute("loggedUser");
			}
		}
		response.sendRedirect("/MobPet/ecommerce/signed.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String operation = request.getParameter("operation");
		
		ICommand command = commandsMap.get(operation);
		
		IViewHelper viewHelper = viewHelpersMap.get(request.getRequestURI());
		
		System.out.println(request.getRequestURI());
		
		DomainEntity entity = viewHelper.getEntity(request);
		
		if (null == entity) {
			return;
		}
		
		Result result = command.execute(entity);
		
		viewHelper.setView(result, request, response);
	}

}