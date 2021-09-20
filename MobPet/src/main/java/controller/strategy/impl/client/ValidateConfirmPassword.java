package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateConfirmPassword implements IStrategy {

	public String process(DomainEntity entity) {
		Client client = (Client) entity;

		if (null != client.getUser().getPassword() && !client.getUser().getPassword().trim().isEmpty()
				&& null != client.getUser().getConfirmPassword() && !client.getUser().getConfirmPassword().trim().isEmpty()) {
			if (!client.getUser().getPassword().trim().equals(client.getUser().getConfirmPassword().trim())) {
				return "As senhas não se coincidem";
			}
		}

		return null;
	}
		
}
