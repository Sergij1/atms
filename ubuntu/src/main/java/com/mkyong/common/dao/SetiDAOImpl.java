package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mkyong.common.form.Seti;

@Repository
 
public class SetiDAOImpl implements SetiDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Seti> listSeti(int lazyLoadLevel) {
		List<Seti> result;
		try {
			result = sessionFactory.getCurrentSession().createCriteria(Seti.class).list();
			try {
				switch (lazyLoadLevel) {
					case 3: 
						for (int i = 0; i < result.size(); i++) {
							for (int j = 0; j < result.get(i).getBanks().size(); j++) {
								for (int k = 0; k < result.get(i).getBanks().get(j).getAtms_info_ua().size(); k++) {
									Hibernate.initialize(( result.get(i).getBanks()).get(j).getAtms_info_ua().get(k).getCoordinates_ua());
								}
							}
						}
						break;
					case 2: 
						for (int i = 0; i < result.size(); i++) {
							for(int j = 0; j < result.get(i).getBanks().size(); j++) {
								Hibernate.initialize((  result.get(i).getBanks()).get(j).getAtms_info_ua());
							}
						}
						break;
					case 1:
						for (int i = 0; i < result.size(); i++) {
							Hibernate.initialize(result.get(i).getBanks());
						}
						break;		
				}
			} catch (Exception ex) {
				
			}	
		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result;	
	}
	
	public Seti getSeti(Integer id, int lazyLoadLevel) {		
		Seti result;
		try {
			result = (Seti)sessionFactory.getCurrentSession().get(Seti.class, id);
			try {
				switch (lazyLoadLevel) {
					case 3: 				
						for (int j = 0; j < result.getBanks().size(); j++) {
							for (int k = 0; k < result.getBanks().get(j).getAtms_info_ua().size(); k++) {
								Hibernate.initialize(result.getBanks().get(j).getAtms_info_ua().get(k).getCoordinates_ua());
							}
						}
						break;
					case 2: 						
						for(int j = 0; j < result.getBanks().size(); j++) {
							Hibernate.initialize(result.getBanks().get(j).getAtms_info_ua());
						}		
						break;
					case 1:
						Hibernate.initialize(result.getBanks());
						break;			
				}
			} catch (Exception ex) { 
				
			}
		} catch (Exception ex) {
			result = null;
		}
		return result;    
	}
	  
	@SuppressWarnings("unchecked")
	public List<Seti> getSetiByCriteria(String field, String value, int lazyLoadLevel) {		
		List<Seti> result;
		try {
			switch (field) {
				case "seti": 					
				case "country":
					result = sessionFactory.getCurrentSession().createCriteria(Seti.class).add(Restrictions.eq(field, value)).list();
					break;
				case "id":
					result = sessionFactory.getCurrentSession().createCriteria(Seti.class).add(Restrictions.eq(field, Integer.parseInt(value))).list();
					break;
				default: 
					result = new ArrayList<Seti>(0);
					break;
			}	
			try {
				switch (lazyLoadLevel) {
					case 3: 
						for (int i = 0; i < result.size(); i++) {
							for (int j = 0; j < result.get(i).getBanks().size(); j++) {
								for (int k = 0; k < result.get(i).getBanks().get(j).getAtms_info_ua().size(); k++) {
									Hibernate.initialize(result.get(i).getBanks().get(j).getAtms_info_ua().get(k).getCoordinates_ua());
								}
							}
						}
						break;
					case 2: 
						for (int i = 0; i < result.size(); i++) {
							for(int j = 0; j < result.get(i).getBanks().size(); j++) {
								Hibernate.initialize(result.get(i).getBanks().get(j).getAtms_info_ua());
							}
						}
						break;
					case 1:
						for (int i = 0; i < result.size(); i++) {
							Hibernate.initialize(result.get(i).getBanks());
						}
						break;		
				}
			} catch (Exception ex) {
				
			}	
		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result; 		
	}
}
