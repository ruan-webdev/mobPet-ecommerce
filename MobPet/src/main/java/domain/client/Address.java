package domain.client;


public class Address extends DomainEntity {

	private String cep;
	private String publicPlace;
	private String number;
	private String complement;
	private String neighbourhood;
	private String city;
	private String state;
	private Client client;
	private AddressType type;
	private boolean active;

	public Address() {

	}

	public Address(String cep, String publicPlace, String number, String complement, String neighbourhood, String city,
			String state, Client client, AddressType type, boolean active) {
		this.cep = cep;
		this.publicPlace = publicPlace;
		this.number = number;
		this.complement = complement;
		this.neighbourhood = neighbourhood;
		this.city = city;
		this.state = state;
		this.client = client;
		this.type = type;
		this.active = active;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}

}