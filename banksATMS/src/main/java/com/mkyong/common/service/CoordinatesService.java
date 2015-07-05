package com.mkyong.common.service;


	import java.util.List;

import com.mkyong.common.form.Coordinates_Ua;

	public interface CoordinatesService {
		public List<Coordinates_Ua> listSeti(int lazyLoadLevel);   
	    public Coordinates_Ua getCoordinates_ua(Integer id,int lazyLoadLevel);
	    public List<Coordinates_Ua> getSetiByCriteria(double x, double y, double r);
	    public  List<Coordinates_Ua> geNullByCriteria();
	}


