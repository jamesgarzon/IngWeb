package co.edu.udea.iw.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.HibernateSessionFactory;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDaoImp implements CiudadDao {

	@Override
	public List<Ciudad> obtener() throws MyException {
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		Session session= null;
		try {
			session = HibernateSessionFactory.getInstance().getSession();
			Criteria criteria = session.createCriteria(Ciudad.class);
			ciudades =criteria.list();
		} catch (Exception e) {
			throw new MyException(e);
		}finally{
			if (session!=null) {
				try {
					session.close();
				} catch (HibernateException e) {
					throw new MyException(e);
				}
			}
		}
		
		return ciudades;
	}

	@Override
	public Ciudad obtener(int codigo) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

}
