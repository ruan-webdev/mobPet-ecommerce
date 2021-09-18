package domain.product;

import java.util.List;

import domain.client.Address;
import domain.client.CreditCard;
import domain.client.DomainEntity;
import domain.client.User;

public class Product extends DomainEntity {
    private String nome;
    private String marca;
    private String categoria;
    private Double preco;
    private String desc;
    private String imagem;
    
    
    public Product() {
    	
    }
    
    public Product(String nome, String marca, String categoria, Double preco,
			String desc, String imagem) {
		//super();
		this.nome = nome;
		this.marca = marca;
		this.categoria = categoria;
		this.preco = preco;
		this.desc = desc;
		this.imagem = imagem;
	}
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public String getDescricao() {
        return desc;
    }

    public void setDescricao(String descricao) {
        this.desc = descricao;
    }
    
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}