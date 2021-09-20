package controller.strategy.impl.client;

import java.time.LocalDate;
import java.time.LocalDateTime;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateDateOfBirth implements IStrategy{

	public String process(DomainEntity entity) {
		Client client = (Client) entity;
		
		LocalDateTime now = LocalDate.now().atStartOfDay();
				
		if (!client.getDateOfBirth().atStartOfDay().isBefore(now)) {
			return "Data de nascimento inválida";
		}
		
		return null;
	}

}
