package com.grinexample.grindemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ScooterStates implements Serializable{

	private static final long serialVersionUID = -7977812017732461132L;
	
	@Id
	@Column(name="id_state")
	Integer idState;
	@Column(name="desc_state")
	String descState;

}
