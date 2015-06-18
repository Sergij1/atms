package com.mkyong.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.common.dao.SetiDAO;
import com.mkyong.common.form.Seti;

@Service
public class SetiServiceImpl implements SetiService {

	@Autowired
    private SetiDAO setiDAO;
	
	public List<Seti> listSeti(int lazyLoadLevel) {
		return setiDAO.listSeti(lazyLoadLevel);
	}

	public Seti getSeti(Integer id, int lazyLoadLevel) {
		return setiDAO.getSeti(id, lazyLoadLevel);
	}
	
	public List<Seti> getSetiByCriteria(String field, String value, int lazyLoadLevel) {
		return setiDAO.getSetiByCriteria(field, value, lazyLoadLevel);
	}

}
