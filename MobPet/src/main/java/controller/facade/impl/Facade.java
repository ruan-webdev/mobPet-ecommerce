package controller.facade.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.facade.IFacade;
import controller.strategy.IStrategy;
import controller.strategy.impl.adress.ValidateAdressData;
import controller.strategy.impl.client.ValidateCPF;
import controller.strategy.impl.client.ValidateClientDataSignup;
import controller.strategy.impl.client.ValidateClienteDataUpdate;
import controller.strategy.impl.client.ValidateConfirmPassword;
import controller.strategy.impl.client.ValidateDateOfBirth;
import controller.strategy.impl.client.ValidateDuplicateCPF;
import controller.strategy.impl.client.ValidateDuplicateEmail;
import controller.strategy.impl.client.ValidateEmail;
import controller.strategy.impl.client.ValidatePasswordStrenght;
import controller.strategy.impl.credit_card.ValidateCreditCardData;
import controller.strategy.impl.credit_card.ValidateExpirationDate;
import controller.strategy.impl.phone.ValidateDuplicatePhone;
import controller.strategy.impl.phone.ValidatePhone;
import controller.strategy.impl.phone.ValidatePhoneData;
import dao.IDAO;
import dao.impl.AddressDAO;
import dao.impl.ClientDAO;
import dao.impl.CreditCardDAO;
import dao.impl.PhoneDAO;
import dao.impl.UserDAO;
import domain.client.Address;
import domain.client.Client;
import domain.client.CreditCard;
import domain.client.DomainEntity;
import domain.client.Phone;
import domain.client.Result;
import domain.client.User;

public class Facade implements IFacade {
	

	private Map<String, Map<String, List<IStrategy>>> businessRulesMap;
	private Map<String, IDAO> daosMap;
	private Result result;
	private StringBuilder stringBuilder;

	public Facade() {
		stringBuilder = new StringBuilder();

		daosMap = new HashMap<String, IDAO>();
		daosMap.put(Client.class.getName(), new ClientDAO());
		daosMap.put(User.class.getName(), new UserDAO());
		daosMap.put(Phone.class.getName(), new PhoneDAO());
		daosMap.put(CreditCard.class.getName(), new CreditCardDAO());
		daosMap.put(Address.class.getName(), new AddressDAO());

		businessRulesMap = new HashMap<String, Map<String, List<IStrategy>>>();

		// Client
		Map<String, List<IStrategy>> businessRulesClientMap = new HashMap<String, List<IStrategy>>();

		List<IStrategy> businessRulesSaveClient = new ArrayList<IStrategy>();
		businessRulesSaveClient.add(new ValidateClientDataSignup());
		businessRulesSaveClient.add(new ValidateCPF());
		businessRulesSaveClient.add(new ValidateEmail());
		businessRulesSaveClient.add(new ValidateDateOfBirth());
		businessRulesSaveClient.add(new ValidateConfirmPassword());
		businessRulesSaveClient.add(new ValidatePasswordStrenght());
		businessRulesSaveClient.add(new ValidateDuplicateCPF());
		businessRulesSaveClient.add(new ValidateDuplicateEmail());

		List<IStrategy> businessRulesUpdateClient = new ArrayList<IStrategy>();
		businessRulesUpdateClient.add(new ValidateClienteDataUpdate());
		businessRulesUpdateClient.add(new ValidateDateOfBirth());
		businessRulesUpdateClient.add(new ValidatePasswordStrenght());
		businessRulesUpdateClient.add(new ValidateConfirmPassword());

		businessRulesClientMap.put("save", businessRulesSaveClient);
		businessRulesClientMap.put("update", businessRulesUpdateClient);

		// Adress
		Map<String, List<IStrategy>> businessRulesAdressMap = new HashMap<String, List<IStrategy>>();

		List<IStrategy> businessRulesSaveAdress = new ArrayList<IStrategy>();
		businessRulesSaveAdress.add(new ValidateAdressData());

		List<IStrategy> businessRulesUpdateAdress = new ArrayList<IStrategy>();
		businessRulesUpdateAdress.add(new ValidateAdressData());

		businessRulesAdressMap.put("save", businessRulesSaveAdress);
		businessRulesAdressMap.put("update", businessRulesUpdateAdress);

		// Phone
		Map<String, List<IStrategy>> businessRulesPhoneMap = new HashMap<String, List<IStrategy>>();

		List<IStrategy> businessRulesSavePhone = new ArrayList<IStrategy>();
		businessRulesSavePhone.add(new ValidatePhoneData());
		businessRulesSavePhone.add(new ValidatePhone());
		businessRulesSavePhone.add(new ValidateDuplicatePhone());

		List<IStrategy> businessRulesUpdatePhone = new ArrayList<IStrategy>();
		businessRulesUpdatePhone.add(new ValidatePhoneData());
		businessRulesUpdatePhone.add(new ValidatePhone());
		businessRulesUpdatePhone.add(new ValidateDuplicatePhone());

		businessRulesPhoneMap.put("save", businessRulesSavePhone);
		businessRulesPhoneMap.put("update", businessRulesUpdatePhone);

		// Credit card
		Map<String, List<IStrategy>> businessRulesCreditCardMap = new HashMap<String, List<IStrategy>>();

		List<IStrategy> businessRulesSaveCreditCard = new ArrayList<IStrategy>();
		businessRulesSaveCreditCard.add(new ValidateCreditCardData());
		businessRulesSaveCreditCard.add(new ValidateExpirationDate());

		List<IStrategy> businessRulesUpdateCreditCard = new ArrayList<IStrategy>();
		businessRulesUpdateCreditCard.add(new ValidateCreditCardData());
		businessRulesUpdateCreditCard.add(new ValidateExpirationDate());

		businessRulesCreditCardMap.put("save", businessRulesSaveCreditCard);
		businessRulesCreditCardMap.put("update", businessRulesSaveCreditCard);

		businessRulesMap.put(Client.class.getName(), businessRulesClientMap);
		businessRulesMap.put(Address.class.getName(), businessRulesAdressMap);
		businessRulesMap.put(Phone.class.getName(), businessRulesPhoneMap);
		businessRulesMap.put(CreditCard.class.getName(), businessRulesCreditCardMap);
	}

	private void processBusinessRules(DomainEntity entity, List<IStrategy> businessRulesEntity) {
		for (IStrategy businessRule : businessRulesEntity) {
			String message = businessRule.process(entity);
			if (null != message) {
				stringBuilder.append(message + '\n');
			}
		}
	}


	public Result save(DomainEntity entity) {
		result = new Result();
		stringBuilder.setLength(0);

		String entityName = entity.getClass().getName();

		Map<String, List<IStrategy>> businessRulesEntityMap = businessRulesMap.get(entityName);
		List<IStrategy> businessRulesSaveEntity = businessRulesEntityMap.get("save");

		processBusinessRules(entity, businessRulesSaveEntity);

		result.getEntities().add(entity);

		if (stringBuilder.length() == 0) {
			daosMap.get(entityName).save(entity);
		} else {
			result.setMessage(stringBuilder.toString());
		}

		return result;
	}

	public Result remove(DomainEntity entity) {
		result = new Result();
		
		String entityName = entity.getClass().getName();
		
		daosMap.get(entityName).remove(entity);
		
		result.getEntities().add(entity);
		
		return result;
	}


	public Result update(DomainEntity entity) {
		result = new Result();
		stringBuilder.setLength(0);

		String entityName = entity.getClass().getName();

		Map<String, List<IStrategy>> businessRulesEntityMap = businessRulesMap.get(entityName);
		List<IStrategy> businessRulesUpdateEntity = businessRulesEntityMap.get("update");

		processBusinessRules(entity, businessRulesUpdateEntity);

		result.getEntities().add(entity);

		if (stringBuilder.length() == 0) {
			daosMap.get(entityName).update(entity);
		} else {
			result.setMessage(stringBuilder.toString());
		}

		return result;
	}


	public Result consult(DomainEntity entity) {
		result = new Result();
		
		String entityName = entity.getClass().getName();
		
		List<DomainEntity> consultEntities = daosMap.get(entityName).consult(entity);
		
		result.setEntities(consultEntities);
		
		return result;
	}


}
