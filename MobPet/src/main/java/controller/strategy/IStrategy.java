package controller.strategy;

import domain.client.DomainEntity;

public interface IStrategy {
	public String process(DomainEntity entity);
}
