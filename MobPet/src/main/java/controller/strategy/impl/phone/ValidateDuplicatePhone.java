package controller.strategy.impl.phone;

import java.util.ArrayList;
import java.util.List;

import controller.strategy.IStrategy;
import dao.impl.PhoneDAO;
import domain.client.Client;
import domain.client.DomainEntity;
import domain.client.Phone;
import domain.client.User;

public class ValidateDuplicatePhone implements IStrategy {
	public String process(DomainEntity entity) {
		Phone phone = (Phone) entity;

		List<DomainEntity> consultList = new ArrayList<DomainEntity>();

		Phone phoneToConsult = new Phone();
		phoneToConsult.setNumber(phone.getNumber());

		Client client = new Client();

		User user = new User();
		user.setId(phone.getClient().getUser().getId());

		client.setUser(user);

		phoneToConsult.setClient(client);

		consultList = new PhoneDAO().consult(phoneToConsult);

		if (!consultList.isEmpty()) {
			return "Você já possui um telefone com esses dados";
		}

		return null;
	}
}
