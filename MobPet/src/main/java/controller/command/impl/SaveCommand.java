package controller.command.impl;

import controller.command.AbstractCommand;
import domain.client.DomainEntity;
import domain.client.Result;

public class SaveCommand extends AbstractCommand{

	public Result execute(DomainEntity entity) {
		
		return facade.save(entity);
	}

 
}