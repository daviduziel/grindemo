package com.grinexample.grindemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grinexample.grindemo.dao.ScooterDAO;
import com.grinexample.grindemo.model.ScooterRequest;
import com.grinexample.grindemo.model.ScooterStates;
import com.grinexample.grindemo.model.Scooters;
import com.grinexample.grindemo.model.StaticScooterStates;
import com.grinexample.grindemo.service.ScooterService;

@Service
public class ScooterServiceImpl implements ScooterService {

	@Autowired
	ScooterDAO scooterDAO;

	@Override
	public void updateScooterState(Scooters scooter) {

//		scooterDAO.save(scooter);
	}

	public String createScooter(ScooterRequest request) {
		Scooters scooter = new Scooters();
		ScooterStates state = new ScooterStates();
		state.setIdState(StaticScooterStates.CREATED.ordinal());
		scooter.setIdScooter(request.getIdScooter());
		scooter.setUser(scooter.getUser());
		scooter.setScooterState(state);
		scooterDAO.createScooter(scooter);
		return request.getIdScooter();
	}

}
