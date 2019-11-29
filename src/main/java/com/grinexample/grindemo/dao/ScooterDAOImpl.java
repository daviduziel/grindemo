package com.grinexample.grindemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.grinexample.grindemo.model.Scooters;

@Repository
public class ScooterDAOImpl implements ScooterDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public void createScooter(Scooters scooter) {
		hibernateTemplate.persist(scooter);
		hibernateTemplate.flush();
	}
}
