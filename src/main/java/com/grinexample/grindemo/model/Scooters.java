package com.grinexample.grindemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Scooters implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_scooter")
	String idScooter;
	@Column(name = "user")
	String user;
	@Column(name = "scooter_state")
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ScooterStates scooterState;

}
