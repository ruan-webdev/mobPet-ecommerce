package controller.strategy.impl.client;

import java.util.ArrayList;
import java.util.List;

import controller.strategy.IStrategy;
import dao.impl.UserDAO;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.User;

public class ValidateDuplicateEmail implements IStrategy {

	public String process(DomainEntity entity) {
		
		Client cliente = (Client) entity;

		List<DomainEntity> consultList = new ArrayList<DomainEntity>();

		Client clientToConsult = new Client();
		
		User userToConsult = new User();
		userToConsult.setEmail(cliente.getUsuario().getEmail());
		
		clientToConsult.setUsuario(userToConsult);

		consultList = new UserDAO().consult(clientToConsult.getUsuario());

		if (!consultList.isEmpty()) {
			return "E-mail já cadastrado";
		}

		return null;
	}

}
