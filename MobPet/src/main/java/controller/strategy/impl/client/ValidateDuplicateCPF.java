package controller.strategy.impl.client;

import java.util.ArrayList;
import java.util.List;

import controller.strategy.IStrategy;
import dao.impl.ClientDAO;
import domain.client.Client;
import domain.client.DomainEntity;

public class ValidateDuplicateCPF implements IStrategy {

		public String process(DomainEntity entity) {
			Client cliente = (Client) entity;

			List<DomainEntity> consultList = new ArrayList<DomainEntity>();

			Client clientToConsult = new Client();
			clientToConsult.setCpf(cliente.getCpf());

			consultList = new ClientDAO().consult(clientToConsult);

			if (!consultList.isEmpty()) {
				return "CPF já cadastrado";
			}

			return null;
	}

}
