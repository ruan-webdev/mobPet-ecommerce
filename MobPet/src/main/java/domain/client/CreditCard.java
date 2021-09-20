package domain.client;

import java.sql.Date;
import java.time.LocalDate;

public class CreditCard extends DomainEntity {
  
	private String number;
	private LocalDate expirationDate;
	private String securityCode;
	private String printedName;
	private Client client;
	private boolean active;

	public CreditCard() {

	}

	public CreditCard(String number, LocalDate expirationDate, String securityCode, String printedName, Client client,
			boolean active) {
		this.number = number;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.printedName = printedName;
		this.client = client;
		this.active = active;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getPrintedName() {
		return printedName;
	}

	public void setPrintedName(String printedName) {
		this.printedName = printedName;
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

	public void setActive(boolean isActive) {
		this.active = isActive;
	}
	
	public Date getExpirationDateWithDateType() {
		return Date.valueOf(expirationDate);
	}

}