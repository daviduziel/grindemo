package com.grinexample.grindemo.dao;

import org.springframework.stereotype.Repository;

import com.grinexample.grindemo.model.Scooters;

public interface ScooterDAO {
	void createScooter(Scooters scooter);
}
