package com.grinexample.grindemo.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.grinexample.grindemo.model.ScooterRequest;
import com.grinexample.grindemo.model.Scooters;
import com.grinexample.grindemo.model.StaticScooterStates;
import com.grinexample.grindemo.service.ScooterService;
import com.grinexample.grindemo.util.GrinDemoException;
import com.grinexample.grindemo.util.GrinRequestValidator;

@RestController
public class GrinDemoController {

	final static String GRIN_DEMO_ERROR_ID_INVALIDO = "id de Scooter Inválido";
	final static String GRIN_DEMO_OK_MESSAGE = "Succesfull updated";
	final static String GRIN_DEMO_HEALT_OK_MESSAGE = "OK";
	@Autowired
	ScooterService scooterService;

	@GetMapping("/")
	public String defaultRequest() {
		return "GrinDemo";
	}

	@GetMapping("/health")
	public String health() {
		return GRIN_DEMO_HEALT_OK_MESSAGE;
	}

	@GetMapping("/scooter/{idScooter}")
	public @ResponseBody Scooters getScooterState(@PathVariable String idScooter) {
		Optional<Scooters> response;
		Scooters responseScooter;
		if (GrinRequestValidator.validateidScooter(idScooter)) {
			response = scooterService.getScooter(idScooter);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
		}
		try {
			responseScooter = response.get();
			return responseScooter;
		} catch (NoSuchElementException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
		}
	}

	@PostMapping("/scooter/")
	public @ResponseBody String createScooter(@RequestBody ScooterRequest scooter) {
		String response = "";

		if (GrinRequestValidator.validateidScooter(scooter.getIdScooter())) {
			scooterService.createScooter(scooter);
			response = GRIN_DEMO_OK_MESSAGE;

		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
		}
		return response;
	}

	@PostMapping("/scooter/setup/{idScooter}")
	public String setupScooter(@PathVariable String idScooter, @RequestBody ScooterRequest scooter) {
		String response = "";

		try {
			if (GrinRequestValidator.validateidScooter(idScooter)) {
				scooter.setIdScooter(idScooter);
				scooterService.updateScooterState(scooter, StaticScooterStates.MAINTENANCE);
				response = GRIN_DEMO_OK_MESSAGE;

			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
			}
		} catch (GrinDemoException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return response;
	}

	@PatchMapping("/scooter/repair/{idScooter}")
	public String repairScooter(@PathVariable String idScooter, @RequestBody ScooterRequest scooter) {
		String response = "";

		try {
			if (GrinRequestValidator.validateidScooter(idScooter)) {
				scooter.setIdScooter(idScooter);
				scooterService.updateScooterState(scooter, StaticScooterStates.DISTRIBUTING);
				response = GRIN_DEMO_OK_MESSAGE;

			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
			}
		} catch (GrinDemoException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return response;
	}

	@PatchMapping("/scooter/place/{idScooter}")
	public String placeScooter(@PathVariable String idScooter, @RequestBody ScooterRequest scooter) {
		String response = "";

		try {
			if (GrinRequestValidator.validateidScooter(idScooter)) {
				scooter.setIdScooter(idScooter);
				scooterService.updateScooterState(scooter, StaticScooterStates.ON_STREET);
				response = GRIN_DEMO_OK_MESSAGE;
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
			}
		} catch (GrinDemoException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return response;
	}

	@PatchMapping("/scooter/take/{idScooter}")
	public String useScooter(@PathVariable String idScooter, @RequestBody ScooterRequest scooter) {
		String response = "";
		try {
			if (GrinRequestValidator.validateidScooter(idScooter)) {
				scooter.setIdScooter(idScooter);
				scooterService.updateScooterState(scooter, StaticScooterStates.DISTRIBUTING);
				response = GRIN_DEMO_OK_MESSAGE;
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, GRIN_DEMO_ERROR_ID_INVALIDO);
			}
		} catch (GrinDemoException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
		return response;
	}

}
