package com.mkyong.common.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mkyong.common.form.Seti;
@Transactional
public interface SetiDAO{
	public List<Seti> listSeti(int lazyLoadLevel);   
    public Seti getSeti(Integer id, int lazyLoadLevel);
    public List<Seti> getSetiByCriteria(String field, String value, int lazyLoadLevel);
	
}
