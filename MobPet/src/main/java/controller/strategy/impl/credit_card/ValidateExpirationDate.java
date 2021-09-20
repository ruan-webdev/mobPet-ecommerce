package controller.strategy.impl.credit_card;

import java.time.LocalDate;
import java.time.LocalDateTime;

import controller.strategy.IStrategy;
import domain.client.CreditCard;
import domain.client.DomainEntity;

public class ValidateExpirationDate implements IStrategy {

	public String process(DomainEntity entity) {
		CreditCard creditCard = (CreditCard) entity;
		
		LocalDateTime now = LocalDate.now().atStartOfDay();
				
		if (creditCard.getExpirationDate().atStartOfDay().isBefore(now)) {
			return "Cartão vencido";
		}
		
		return null;
	}

}
