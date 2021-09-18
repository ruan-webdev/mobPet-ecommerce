package dao;

import java.util.List;

import domain.client.DomainEntity;

public interface IDAO {

	public int save(DomainEntity entity);

	public void remove(DomainEntity entity);

	public void update(DomainEntity entity);

	public List<DomainEntity> consult(DomainEntity entity);

}