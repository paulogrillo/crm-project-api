package com.crmproject.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_funcionarios")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome_funcionario")
	@NotNull(message = "O nome é obrigatório!")
	@Size(min = 3, max = 15)
	private String nameEmployee;
	
	@Column(name="email_funcionario")
	@NotNull(message = "O atributo email é obrigatório!")
	@Email(message = "O atributo email deve ser um email válido!")
	@Size(min = 3, max = 40)
	private String emailEmployee;
	
	@Column(name="tel_funcionario")
	@NotNull(message = "O atributo telefone é obrigatório!")
	@Size(min = 8, max = 20)
	private String telEmployee;
	
	@Column(name="foto_funcionario")
	@NotNull(message = "O atributo avatar é obrigatório!")
	@Size(min = 8, max = 80)
	private String avatarEmployee;
	
	@Column(name="salario_funcionario")
	@NotNull(message = "O atributo remuneração é obrigatório!")
	@Size(min = 8, max = 80)
	private BigDecimal remunerationEmployee;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}

	public String getEmailEmployee() {
		return emailEmployee;
	}

	public void setEmailEmployee(String emailEmployee) {
		this.emailEmployee = emailEmployee;
	}

	public String getTelEmployee() {
		return telEmployee;
	}

	public void setTelEmployee(String telEmployee) {
		this.telEmployee = telEmployee;
	}

	public String getAvatarEmployee() {
		return avatarEmployee;
	}

	public void setAvatarEmployee(String avatarEmployee) {
		this.avatarEmployee = avatarEmployee;
	}

	public BigDecimal getRemunerationEmployee() {
		return remunerationEmployee;
	}

	public void setRemunerationEmployee(BigDecimal remunerationEmployee) {
		this.remunerationEmployee = remunerationEmployee;
	}
	
	
	
}
