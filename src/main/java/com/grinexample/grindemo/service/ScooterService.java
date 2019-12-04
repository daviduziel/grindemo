package com.grinexample.grindemo.service;

import java.util.Optional;

import com.grinexample.grindemo.model.ScooterRequest;
import com.grinexample.grindemo.model.Scooters;
import com.grinexample.grindemo.model.StaticScooterStates;
import com.grinexample.grindemo.util.GrinDemoException;

public interface ScooterService {
	String updateScooterState(ScooterRequest scooter, StaticScooterStates state) throws GrinDemoException;

	Optional<Scooters> getScooter(String idScooter);

	String createScooter(ScooterRequest request);
}
