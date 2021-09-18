package domain.client;

import java.sql.Date;
import java.time.LocalDate;

public class CreditCard extends DomainEntity {
    private String num;
    private String nomeImpresso;
    private String bandeira;
    private LocalDate validade;
    private String codigo;
    private String apelido;
    private Client cliente;

    
    
    public CreditCard() {
    	
    }
    
    
    public CreditCard(String num, String nomeImpresso, String bandeira, 
    		LocalDate validade, String codigo, String apelido) {
		this.num = num;
		this.nomeImpresso = nomeImpresso;
		this.bandeira = bandeira;
		this.validade = validade;
		this.codigo = codigo;
		this.apelido = apelido;
		
	}
    
    
    public String getNum() {
        return num;
    }

    public void setNum(String numCartao) {
        this.num = numCartao;
    }

    public String getNome() {
        return nomeImpresso;
    }

    public void setNome(String nomeImpresso) {
        this.nomeImpresso = nomeImpresso;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }


	public Client getCliente() {
		return cliente;
	}


	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
    
}