package com.tracker.Repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tracker.Entity.*;

@Repository
public class VehicleRepoImpl  implements VehicleRepo{
@PersistenceContext
private EntityManager em;
	public List<Vehicles> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Vehicles> query=em.createNamedQuery("Vehicles.findAll",Vehicles.class); 
		return query.getResultList();
	}
	@Transactional
	public Vehicles[] insertNupdate(Vehicles[] v) {
		// TODO Auto-generated method stub
		for(int i=0;i<v.length;i++)
				em.merge(v[i]);
				return v;
	}
	public Vehicles findOne(String vin) {
	/*	TypedQuery<Vehicles> query= em.createNamedQuery("Vehicles.findOne",Vehicles.class);
			query.setParameter("vin", vin);
			List<Vehicles> vehicles= query.getResultList();*/
		return  em.find(Vehicles.class, vin);
	}

}
