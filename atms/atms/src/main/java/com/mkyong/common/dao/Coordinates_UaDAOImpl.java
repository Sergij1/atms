package  com.mkyong.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.common.form.Coordinates_Ua;
import com.mkyong.common.radius.Coordinate;
import com.mkyong.common.radius.Radius;






@Repository
public class Coordinates_UaDAOImpl implements Coordinates_UaDAO  {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Coordinates_Ua> listSeti(int lazyLoadLevel){
		return null;
	}   
    public Coordinates_Ua getSeti(Integer id, int lazyLoadLevel){
		return null;}
    @Override
	@SuppressWarnings("unchecked")
	public List<Coordinates_Ua> getSetiByCriteria(double x_latitude, double y_longitude, double radius  ) {		
		List<Coordinates_Ua> result;
		Coordinate coord = Radius.coorRad(x_latitude,y_longitude, radius);
	
		Double x1 = coord.getX1();
		Double x2 = coord.getX2();
		Double y1 = coord.getY1();
		Double y2 = coord.getY2();
		//System.out.println(x1+"\t"+x2);
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coordinates_Ua.class);
			criteria.add(Restrictions.between("x_latitude",x1,x2));
			criteria.add(Restrictions.between("y_longitude",y1,y2));
			 result = criteria.list();
			
			 }	
			
				
		catch (Exception ex) {
			result = new ArrayList<Coordinates_Ua>(0);
			Coordinates_Ua cor = new Coordinates_Ua();
			cor.setId(1);
			cor.setX_latitude(49.00);
			cor.setY_longitude(55.00);
			result.add(cor);
		}
		return result; 		
	}
	


@Override
	@SuppressWarnings({ "unchecked" })
	public List<Coordinates_Ua> geNullByCriteria( ) {		
		List<Coordinates_Ua> result;
		
		double c = 44.9205757;
	
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Coordinates_Ua.class);
			criteria.add(Restrictions.le("x_latitude", new Double(c)));
			//criteria.add(Restrictions.ge("x_latitude", x2));
			result = criteria.list();
				
			}	
			
				
		catch (Exception ex) {
			result = new ArrayList<Coordinates_Ua>(0);
		}
		return result; 		
	}
	
}
