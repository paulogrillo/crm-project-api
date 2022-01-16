package com.crmproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_admin")
public class UserAdmin {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@ApiModelProperty(example = "email@email.com.br")
	@Column(name="email")
	@NotNull(message = "O atributo email é obrigatório!")
	private String emailClient;
}
