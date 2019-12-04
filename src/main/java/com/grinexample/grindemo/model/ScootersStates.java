package com.grinexample.grindemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="scooters_states",schema = "grindemo")
public class ScootersStates implements Serializable{

	private static final long serialVersionUID = -7977812017732461132L;
	
	@Id
	@Column(name="id_state")
	Short idState;
	@Column(name="desc_state")
	String descState;

}
