package controller.strategy.impl.credit_card;

import controller.strategy.IStrategy;
import domain.client.CreditCard;
import domain.client.DomainEntity;

public class ValidateCreditCardData implements IStrategy {

	public String process(DomainEntity entity) {
		CreditCard creditCard = (CreditCard) entity;
		
		if (null == creditCard.getNumber() || creditCard.getNumber().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == creditCard.getExpirationDate() || creditCard.getExpirationDate().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == creditCard.getSecurityCode() || creditCard.getSecurityCode().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == creditCard.getPrintedName() || creditCard.getPrintedName().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
		return null;
	}


}


