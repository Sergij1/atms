package com.mkyong.common.service;

import java.util.List;

import com.mkyong.common.form.Seti;

public interface SetiService {
	public List<Seti> listSeti(int lazyLoadLevel);   
    public Seti getSeti(Integer id,int lazyLoadLevel);
    public List<Seti> getSetiByCriteria(String field, String value, int lazyLoadLevel);
}
