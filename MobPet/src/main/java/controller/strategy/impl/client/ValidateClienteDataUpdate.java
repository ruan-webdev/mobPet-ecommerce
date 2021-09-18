package controller.strategy.impl.client;

import controller.strategy.IStrategy;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateClienteDataUpdate implements IStrategy {

	public String process(DomainEntity entity) {
		
		Client cliente = (Client) entity;

		if (null == cliente.getNome() || cliente.getNome().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cliente.getDataNascimento() || cliente.getDataNascimento().toString().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cliente.getUsuario().getSenha() || cliente.getUsuario().getSenha().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		if (null == cliente.getUsuario().getConfirmarSenha() || cliente.getUsuario().getConfirmarSenha().trim().isEmpty()) {
			return "Preencha todos os campos obrigatórios";
		}
		

		return null;
		
	}

}
