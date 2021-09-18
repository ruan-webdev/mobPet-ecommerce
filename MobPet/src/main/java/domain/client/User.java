package domain.client;

public class User extends DomainEntity{
	

	    private String email;
	    private String senha;
	    private String confirmarSenha;
	    private UserType tipoUsuario;
	    private UserRole role;
	    private boolean ativo;
	    
	    public User() {

		}

		public User(String email, String senha, String confirmarSenha, UserType tipoUsuario) {
			this.email = email;
			this.senha = senha;
			this.confirmarSenha = confirmarSenha;
			this.tipoUsuario = tipoUsuario;
		}
	
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	 
	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }

	    public String getConfirmarSenha() {
	        return confirmarSenha;
	    }

	    public void setConfirmarSenha(String confirmarSenha) {
	        this.confirmarSenha = confirmarSenha;
	    }

	    public UserType getTipoUsuario() {
	        return tipoUsuario;
	    }

	    public void setTipoUsuario(UserType tipoUsuario) {
	        this.tipoUsuario = tipoUsuario;
	    }

		public UserRole getRole() {
			return role;
		}

		public void setRole(UserRole role) {
			this.role = role;
		}

		public boolean isActive() {
			return ativo;
		}

		public void setActive(boolean ativo) {
			this.ativo = ativo;
		}

}
