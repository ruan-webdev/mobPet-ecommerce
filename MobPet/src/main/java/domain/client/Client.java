package domain.client;


import java.time.LocalDate;
import java.util.List;


public class Client extends DomainEntity {


	private String name;
	private String cpf;
	private LocalDate dateOfBirth;
	private Gender gender;
	private List<Address> adresses;
	private List<Phone> phones;
	private List<CreditCard> creditCards;
	private User user;

	public Client() {

	}

	public Client(String name, String cpf, LocalDate dateOfBirth, Gender gender,
			List<Address> adresses, List<Phone> phones, List<CreditCard> creditCards, User user) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.adresses = adresses;
		this.phones = phones;
		this.creditCards = creditCards;
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDecoratedCpf() {
		String decoratedCpf = "";
		
		int count = 1;
		
		for (Character chr : cpf.toCharArray()) {
			decoratedCpf += chr;
			if (count % 3 == 0) {
				if (count == 9) {
					decoratedCpf += '-';
				} else {
					decoratedCpf += '.';
				}
			}
			count++;
		}
		
		return decoratedCpf;
	}
	
}
    