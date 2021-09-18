package controller.strategy.impl.adress;

import controller.strategy.IStrategy;
import domain.client.Address;
import domain.client.DomainEntity;

public class ValidateAdressData implements IStrategy {

	public String process(DomainEntity entity) {
		// TODO Auto-generated method stub
		Address endereco = (Address) entity;
		
		
		System.out.println("validacao conjunta "+endereco);
		
		if (null == endereco.getCep() || endereco.getCep().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
	
		if (null == endereco.getLogradouro() || endereco.getLogradouro().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == endereco.getNumero() || endereco.getNumero().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == endereco.getBairro() || endereco.getBairro().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		System.out.println("validacao conjunta "+endereco);
		if (null == endereco.getCidade() || endereco.getCidade().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		System.out.println("validacao conjunta "+endereco);
		if (null == endereco.getEstado() || endereco.getEstado().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		
		
		return null;
	}

}
