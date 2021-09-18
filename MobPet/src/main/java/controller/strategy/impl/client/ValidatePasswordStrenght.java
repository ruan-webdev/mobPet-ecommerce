package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidatePasswordStrenght implements IStrategy {

	public String process(DomainEntity entity) {
		
		String passwordRegex = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		Client cliente = (Client) entity;

		String senha = cliente.getUsuario().getSenha();

		if (null == senha || senha.trim().isEmpty()) {
			return "A senha não está dentro dos requisitos";
		}

		if (!senha.matches(passwordRegex)) {
			return "A senha não está dentro dos requisitos";
		}

		return null;
	
	}

}
