package com.crmproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	

	@NotNull(message = "O atributo Usuário é Obrigatório!")
	private String username;
	
	@NotNull(message = "Senha nao pode estar vazio")
	//@Size(min = 4, max = 8, message = "Minimo 4 caracteres maximo 8")
	@Column(name = "Senha")
	private String password;
	
	
	private String avatar;
	

	
//	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	 @JsonIgnoreProperties("user")
//	 private List<Post> post;
	 

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Post> getPost() {
//		return post;
//	}
//
//	public void setPost(List<Post> post) {
//		this.post = post;
//	}
	
}
