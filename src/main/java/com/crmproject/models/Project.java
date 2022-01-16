package com.crmproject.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_projeto")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="nome_projeto")
	@NotNull(message = "O atributo nome do projeto é obrigatório!")
	@Size(min = 3, max = 15)
	private String nameProject;
	
	@Column(name="qtd_dias")
	@NotNull(message = "O qtd de dias é obrigatório!")
    private int amountTime;
	

    private Date deadline;
	
	@Column(name="orcamento")
	@NotNull(message="O atributo budget é obrigatório!")
	private BigDecimal budget;
	
	@Column(name="nivel_prioridade")
	@NotNull(message="O atributo prioridade é obrigatório!")
	private int priority;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public int getAmountTime() {
		return amountTime;
	}

	public void setAmountTime(int amountTime) {
		this.amountTime = amountTime;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public BigDecimal getBudget() {
		return budget;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}
