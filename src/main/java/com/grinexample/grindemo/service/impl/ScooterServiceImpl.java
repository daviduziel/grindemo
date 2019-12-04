package com.grinexample.grindemo.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grinexample.grindemo.dao.ScooterDAO;
import com.grinexample.grindemo.model.ScooterRequest;
import com.grinexample.grindemo.model.Scooters;
import com.grinexample.grindemo.model.ScootersStates;
import com.grinexample.grindemo.model.StaticScooterStates;
import com.grinexample.grindemo.service.ScooterService;
import com.grinexample.grindemo.util.GrinDemoException;

@Service
public class ScooterServiceImpl implements ScooterService {

	@Autowired
	ScooterDAO scooterDAO;

	@Override
	public String updateScooterState(ScooterRequest request, StaticScooterStates stateEnum) throws GrinDemoException {
		Scooters scooter = null;
		Optional<Scooters> scooterOpt = scooterDAO.findById(request.getIdScooter());

		try {
			scooter = scooterOpt.get();

			Integer actualState = scooter.getScooterState().getIdState() - 1;
			switch (actualState) {
			case 0: {
				if (stateEnum.ordinal() != 1) {
					throw new GrinDemoException("ESTADO INVÁLIDO");
				}
			}
			case 1: {
				if (stateEnum.ordinal() != 2) {
					throw new GrinDemoException("ESTADO INVÁLIDO");
				}
			}
			case 2: {
				if (stateEnum.ordinal() != 3) {
					throw new GrinDemoException("ESTADO INVÁLIDO");
				}
			}
			case 3: {
				if (stateEnum.ordinal() != 2 || stateEnum.ordinal() != 1) {
					throw new GrinDemoException("ESTADO INVÁLIDO");
				}
			}

			}

			ScootersStates state = new ScootersStates();
			state.setIdState((short) (stateEnum.ordinal() + 1));
			scooter.setUser(request.getUsuario());
			scooter.setScooterState(state);
			scooterDAO.save(scooter);
		} catch (NoSuchElementException ex) {
			throw new GrinDemoException("Error al intentar salvar el estado, la información es inválida");
		}
		return scooter.getIdScooter();
	}

	@Override
	public String createScooter(ScooterRequest request) {
		Scooters scooter = new Scooters();
		ScootersStates state = new ScootersStates();
		state.setIdState((short) (StaticScooterStates.CREATED.ordinal() + 1));
		scooter.setIdScooter(request.getIdScooter());
		scooter.setUser(request.getUsuario());
		scooter.setScooterState(state);
		scooterDAO.save(scooter);
		return request.getIdScooter();
	}

	@Override
	public Optional<Scooters> getScooter(String idScooter) {
		Scooters scooter = new Scooters();
		scooter.setIdScooter(idScooter);
		return scooterDAO.findById(idScooter);
	}

}
