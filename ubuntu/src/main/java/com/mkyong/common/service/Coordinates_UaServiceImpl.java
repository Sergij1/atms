package com.mkyong.common.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.mkyong.common.dao.Coordinates_UaDAO;
import com.mkyong.common.form.Coordinates_Ua;

	@Service
	public class Coordinates_UaServiceImpl implements CoordinatesService {

		@Autowired
	    private Coordinates_UaDAO coorDAO;
		
		public List<Coordinates_Ua> listSeti(int lazyLoadLevel) {
			return coorDAO.listSeti(lazyLoadLevel);
		}

		public Coordinates_Ua getCoordinates_ua(Integer id, int lazyLoadLevel) {
			return coorDAO.getSeti(id, lazyLoadLevel);
		}
		
		public List<Coordinates_Ua> getSetiByCriteria(double x, double y, double r) {
			return coorDAO.getSetiByCriteria(x,y,r);
		}

		public List<Coordinates_Ua> geNullByCriteria(){
			return coorDAO.geNullByCriteria();
		}

	}

