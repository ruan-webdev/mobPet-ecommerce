package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateConfirmPassword implements IStrategy {

	public String process(DomainEntity entity) {

			Client cliente = (Client) entity;

			if (null != cliente.getUsuario().getSenha() && !cliente.getUsuario().getSenha().trim().isEmpty()
					&& null != cliente.getUsuario().getConfirmarSenha() && !cliente.getUsuario().getConfirmarSenha().trim().isEmpty()) {
				if (!cliente.getUsuario().getSenha().trim().equals(cliente.getUsuario().getConfirmarSenha().trim())) {
					return "As senhas não se coincidem";
				}
			}

			return null;
	}
		
}
