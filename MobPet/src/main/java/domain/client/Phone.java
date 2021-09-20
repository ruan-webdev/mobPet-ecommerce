package domain.client;

public class Phone extends DomainEntity {

	private String number;
	private Client client;
	private boolean active;

	public Phone() {

	}

	public Phone(String number, Client client, boolean active) {
		this.number = number;
		this.client = client;
		this.active = active;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
