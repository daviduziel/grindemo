package com.grinexample.grindemo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "scooters", schema = "grindemo")
public class Scooters implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_scooter")
	String idScooter;
	@Column(name = "user")
	String user;
	@JoinColumn(name = "scooter_state")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	ScootersStates scooterState;

}
