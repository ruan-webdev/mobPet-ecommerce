package domain.client;

public class User extends DomainEntity{
	
	private String email;
	private String password;
	private String confirmPassword;
	private UserRole role;
	private boolean active;

	public User() {

	}

	public User(String email, String password, String confirmPassword, UserRole role, boolean active) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean isActive) {
		this.active = isActive;
	}
}
