package com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;


import java.util.Locale;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mkyong.common.form.Seti;

@Repository
public class SetiDAOImpl implements SetiDAO {
	private final static String COUNTRY_EN= "SELECT E.country_en FROM com.mkyong.common.form.Seti  E "
			+ " GROUP BY E.country_en ORDER BY E.country_en";
	
	
	 private final static String COUNTRY_RU = "SELECT E.country_ru FROM com.mkyong.common.form.Seti  E "
			+ " GROUP BY E.country_ru ORDER BY E.country_ru";

	@Autowired
	HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<Seti> listSeti() {
		List<Seti> result;
		try {
			result = (List<Seti>) hibernateTemplate.findByCriteria(
			        DetachedCriteria.forClass(Seti.class));

		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result;
	}

	public Seti getSeti(Integer id) {
		Seti result;
		try {
			result = (Seti)hibernateTemplate.findByCriteria(
			        DetachedCriteria.forClass(Seti.class).add(Restrictions.eq("id", id)));

		} catch (Exception ex) {
			result = null;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Seti> getSetiByCriteria(String field, String value) {
		ArrayList<Seti> result;
		try {
			switch (field) {
			case "seti":
			case "country":
				result = (ArrayList<Seti>) hibernateTemplate.findByCriteria(
				        DetachedCriteria.forClass(Seti.class)
						.add(Restrictions.eq(field, value)));
				break;
			case "id":
				result = (ArrayList<Seti>) hibernateTemplate.findByCriteria(
				        DetachedCriteria.forClass(Seti.class)
						.add(Restrictions.eq(field, Integer.parseInt(value))));
				break;
			default:
				result = new ArrayList<Seti>(0);
				break;
			}

		} catch (Exception ex) {
			result = new ArrayList<Seti>(0);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCountry(Locale locale) {
		ArrayList<String> country = null;
		if(locale.getLanguage()=="ru"){
			country  = (ArrayList<String>) hibernateTemplate.find(COUNTRY_RU);}
		else{
			country  = (ArrayList<String>) hibernateTemplate.find(COUNTRY_EN);
		}
		return country;
	}
}
