package com.tracker.Repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tracker.Entity.Readings;
@Repository
public class ReadingsRepoImpl implements ReadingsRepo{
	@PersistenceContext
	private EntityManager em;
	@Transactional
	public Readings createrNupdate(Readings r) {
		// TODO Auto-generated method stub
		em.persist(r);
		return r;
	}
	public List<Readings> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Readings> query= em.createNamedQuery("Readings.findALL",Readings.class);
		return query.getResultList();
	}
	public List<Readings> findOnebyVin(String vin) {
		// TODO Auto-generated method stub
		TypedQuery<Readings> query = em.createNamedQuery("Readings.findOnebyVin",Readings.class);
		query.setParameter("vin", vin);
		List<Readings> reading= query.getResultList();
		return reading;
	}
	public List<Readings> plotSignal(String vin, float time) {
		// TODO Auto-generated method stub
		float t=time;
		Timestamp timestamp1 = new Timestamp((long) (System.currentTimeMillis()-t*60*1000));
        //System.out.println(timestamp1);
		Query p = em.createQuery(
		        "SELECT rdn FROM Readings rdn WHERE rdn.timestamp > :timestamp1 "
		        + "AND rdn.vin = :v").setParameter("v", vin).setParameter("timestamp1", timestamp1);
	 List<Readings> m =p.getResultList();
	
		
		return  m;
	}

}
