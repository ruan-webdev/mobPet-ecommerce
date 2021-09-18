package controller.command;


import domain.client.DomainEntity;

import domain.client.Result;

public interface ICommand {

	public Result execute(DomainEntity entity);
}