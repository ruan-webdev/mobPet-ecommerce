package controller.strategy.impl.phone;

import controller.strategy.IStrategy;
import domain.client.DomainEntity;
import domain.client.Phone;

public class ValidatePhoneData implements IStrategy {
	
	public String process(DomainEntity entity) {
		Phone phone = (Phone) entity;

		if (null == phone.getNumber() || phone.getNumber().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
		return null;
	}
}
