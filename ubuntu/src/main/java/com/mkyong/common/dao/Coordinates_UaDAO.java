package com.mkyong.common.dao;


	import java.util.List;

	import org.springframework.transaction.annotation.Transactional;

	import com.mkyong.common.form.Coordinates_Ua;
	@Transactional
	public interface Coordinates_UaDAO {
		public List<Coordinates_Ua> listSeti(int lazyLoadLevel);   
	    public Coordinates_Ua getSeti(Integer id, int lazyLoadLevel);
	    public List<Coordinates_Ua> getSetiByCriteria(double x, double y, double r);
		List<Coordinates_Ua> geNullByCriteria();
		
	}
