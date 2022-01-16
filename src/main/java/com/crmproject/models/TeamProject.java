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
@Table(name = "tb_time_projeto")
public class TeamProject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome_time")
	@NotNull(message = "O nome do time é obrigatório!")
	@Size(min = 3, max = 15)
	private String nameOccupation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOccupation() {
		return nameOccupation;
	}

	public void setNameOccupation(String nameOccupation) {
		this.nameOccupation = nameOccupation;
	}
	
}
