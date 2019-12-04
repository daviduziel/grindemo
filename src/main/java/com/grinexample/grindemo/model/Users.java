package com.grinexample.grindemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users", schema = "grindemo")
public class Users implements Serializable {

	private static final long serialVersionUID = 3549641669015694094L;
	@Id
	@Column(name = "id_user")
	Long idUser;
	@Column(name = "user_email")
	String userEmail;
	@Column(name = "status")
	String Status;
}
