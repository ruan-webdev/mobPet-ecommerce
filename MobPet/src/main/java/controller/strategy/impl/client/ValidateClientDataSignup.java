package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateClientDataSignup implements IStrategy {

		
	public String process(DomainEntity entity) {
		Client client = (Client) entity;

		if (null == client.getName() || client.getName().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getCpf() || client.getCpf().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getDateOfBirth() || client.getDateOfBirth().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getUser().getEmail() || client.getUser().getEmail().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getUser().getPassword() || client.getUser().getPassword().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getUser().getConfirmPassword() || client.getUser().getConfirmPassword().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == client.getGender() || client.getGender().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}

		return null;
	}
}
