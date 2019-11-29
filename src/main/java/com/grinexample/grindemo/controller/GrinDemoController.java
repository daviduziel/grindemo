package com.grinexample.grindemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grinexample.grindemo.model.ScooterRequest;
import com.grinexample.grindemo.util.GrinRequestValidator;

@RestController
public class GrinDemoController {

	@GetMapping("/")
	public String defaultRequest() {
		return "GrinDemo";
	}

	@GetMapping("/health")
	public String health() {
		return "OK";
	}

	@GetMapping("/scooter")
	public String getScooterState(@RequestBody ScooterRequest scooter) {
		String response = "";
		if (GrinRequestValidator.validateidScooter(scooter.getIdScooter())) {
			System.out.println("here");
		} else {
			response = "id de Scooter Inválido";
		}
		return response;
	}

	@PostMapping("/scooter/{idScooter}")
	public String createScooter(@PathVariable String idScooter) {
		String response = "";
		if (GrinRequestValidator.validateidScooter(idScooter)) {

		} else {
			response = "id de Scooter Inválido";
		}
		return response;
	}

	@PostMapping("/scooter/setup/{idScooter}")
	public String setupScooter(@PathVariable String idScooter) {
		return "Hello World";
	}

	@PatchMapping("/scooter/repair/{idScooter}")
	public String repairScooter(@PathVariable String idScooter) {
		return "Hello World";
	}

	@PatchMapping("/scooter/place/{idScooter}")
	public String placeScooter(@PathVariable String idScooter) {
		return "Hello World";
	}

	@PatchMapping("/scooter/take/{idScooter}")
	public String useScooter(@PathVariable String idScooter) {
		return "Hello World";
	}

}
