package com.grinexample.grindemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grinexample.grindemo.model.Scooters;

@Repository
public interface ScooterDAO extends JpaRepository<Scooters, String>{
}
