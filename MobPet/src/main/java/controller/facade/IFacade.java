package controller.facade;


import domain.client.DomainEntity;
import domain.client.Result;

public interface IFacade {

		public Result save(DomainEntity entity);
		public Result remove(DomainEntity entity);

		public Result update(DomainEntity entity);

		public Result consult(DomainEntity entity);

}