package controller.strategy.impl.adress;

import controller.strategy.IStrategy;
import domain.client.Address;
import domain.client.DomainEntity;

public class ValidateAdressData implements IStrategy {

	public String process(DomainEntity entity) {
		// TODO Auto-generated method stub
		Address address = (Address) entity;
		
		if (null == address.getCep() || address.getCep().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getPublicPlace() || address.getPublicPlace().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getNumber() || address.getNumber().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getNeighbourhood() || address.getNeighbourhood().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getType() || address.getType().toString().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getCity() || address.getCity().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == address.getState() || address.getState().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
		return null;
	}


}
