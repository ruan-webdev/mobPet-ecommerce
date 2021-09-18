package controller.strategy.impl.credit_card;

import controller.strategy.IStrategy;
import domain.client.CreditCard;
import domain.client.DomainEntity;

public class ValidateCreditCardData implements IStrategy {

	public String process(DomainEntity entity) {
		
		CreditCard cartaoDeCredito = (CreditCard) entity;
		
		if (null == cartaoDeCredito.getNum() || cartaoDeCredito.getNum().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cartaoDeCredito.getValidade() || cartaoDeCredito.getValidade().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cartaoDeCredito.getCodigo() || cartaoDeCredito.getCodigo().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cartaoDeCredito.getNome() || cartaoDeCredito.getNome().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
		return null;
	}

}


