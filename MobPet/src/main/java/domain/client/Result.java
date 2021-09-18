package domain.client;

import java.util.ArrayList;
import java.util.List;

public class Result {
	private String message;
	private List<DomainEntity> entities;

	public Result() {
		entities = new ArrayList<DomainEntity>();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DomainEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<DomainEntity> entities) {
		this.entities = entities;
	}
}
