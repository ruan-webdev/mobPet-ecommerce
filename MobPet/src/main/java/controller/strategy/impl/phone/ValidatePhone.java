package controller.strategy.impl.phone;

import controller.strategy.IStrategy;
import domain.client.DomainEntity;
import domain.client.Phone;

public class ValidatePhone implements IStrategy {
	public String process(DomainEntity entity) {
		Phone phone = (Phone) entity;
		
		String number = phone.getNumber();

		if (null == number || number.trim().isEmpty()) {
			return "Número de telefone inválido";
		}
		
		String phoneRegex = "\\(\\d{2,}\\) \\d{4,}\\-\\d{4}";
		
		return number.matches(phoneRegex) ? null : "Número de telefone inválido";
	}
}
