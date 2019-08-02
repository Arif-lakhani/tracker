package com.tracker.Repository;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tracker.Entity.Alert;
import com.tracker.Entity.HighAlerts;
@Repository
public class AlerRepoImpl implements AlertRepo{
	@PersistenceContext
	private EntityManager em;
	
	public List<HighAlerts> findAll() {
		// TODO Auto-generated method stub
		//TypedQuery<HighAlerts> query=em.createNamedQuery("Alert.findbyVin",HighAlerts.class);

				
				 List<HighAlerts> l =em.createQuery(
					        "SELECT a.vin, a.priority,count(a.vin) as CountofAlerts FROM Alert a "
							        + "WHERE a.timestamp > ( now() - 7200 ) and a.priority='High' GROUP BY a.vin ORDER BY CountofAlerts DESC")
							        .getResultList();
				 
			
		return l;
	}

	
	public List<Alert> findOnebyVin(String vin) {
		// TODO Auto-generated method stub
		TypedQuery<Alert> query=em.createNamedQuery("Alert.findbyVin",Alert.class);
		query.setParameter("vin", vin);
		//System.out.println(query.getResultList());
		return query.getResultList();
	}
	@Transactional
	
	public Alert addAlert(Alert a) {
		// TODO Auto-generated method stub
		em.persist(a);
		return a;
	}
}

