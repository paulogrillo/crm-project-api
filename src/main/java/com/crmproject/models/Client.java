package com.crmproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome")
	@NotNull(message = "O atributo nome do cliente é obrigatório!")
	@Size(min = 3, max = 15)
	private String nameClient;
	
	@Column(name="telefone")
	@NotNull(message = "O atributo telefone é obrigatório!")
	@Size(min = 8, max = 13)
	private String tellClient;
	
	@Column(name="email")
	@NotNull(message = "O atributo email é obrigatório!")
	private String emailClient;
	
	@Column(name="website")
	@NotNull(message = "O atributo website é obrigatório!")
	@Size(min = 5, max = 40)
	private String websiteClient;
	
	@Column(name="cnpj")
	@NotNull(message = "O atributo cnpj é obrigatório!")
	@Size(min = 5, max = 40)
	private String cnpjClient;
	
	@Column(name="avatar")
	@NotNull(message = "O atributo avatar é obrigatório!")
	@Size(min = 5, max = 80)
	private String avatarClient;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getTellClient() {
		return tellClient;
	}

	public void setTellClient(String tellClient) {
		this.tellClient = tellClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getWebsiteClient() {
		return websiteClient;
	}

	public void setWebsiteClient(String websiteClient) {
		this.websiteClient = websiteClient;
	}

	public String getCnpjClient() {
		return cnpjClient;
	}

	public void setCnpjClient(String cnpjClient) {
		this.cnpjClient = cnpjClient;
	}

	public String getAvatarClient() {
		return avatarClient;
	}

	public void setAvatarClient(String avatarClient) {
		this.avatarClient = avatarClient;
	}
	
	
	
}
