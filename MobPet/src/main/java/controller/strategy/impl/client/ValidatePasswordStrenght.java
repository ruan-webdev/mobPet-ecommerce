package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidatePasswordStrenght implements IStrategy {

		
		public String process(DomainEntity entity) {
			String passwordRegex = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
			Client client = (Client) entity;

			String password = client.getUser().getPassword();

			if (null == password || password.trim().isEmpty()) {
				return "A senha não está dentro dos requisitos";
			}

			if (!password.matches(passwordRegex)) {
				return "A senha não está dentro dos requisitos";
			}

			return null;
		}

}
