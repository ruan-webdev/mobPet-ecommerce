package domain.client;


import java.time.LocalDate;
import java.util.List;


public class Client extends DomainEntity {


	private String nome;
	private String genero;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;
    private List <Address> endereco;
    private List <CreditCard> cartoesDeCredito;
    private User usuario;
    
    public Client() {

	}

	public Client(String nome, String cpf, LocalDate dataNascimento, String genero,
			List<Address> endereco, String telefone, List<CreditCard> cartoesDeCredito, User usuario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cartoesDeCredito = cartoesDeCredito;
		this.usuario = usuario;
	}

    

    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate localDate) {
		this.dataNascimento = localDate;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public List<Address> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Address> endereco) {
		this.endereco = endereco;
	}

	public List<CreditCard> getCartoesDeCredito() {
		return cartoesDeCredito;
	}

	public void setCartoesDeCredito(List<CreditCard> cartoesDeCredito) {
		this.cartoesDeCredito = cartoesDeCredito;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
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
    