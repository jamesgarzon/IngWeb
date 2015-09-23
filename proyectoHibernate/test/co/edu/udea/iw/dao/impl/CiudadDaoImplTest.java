package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDaoImplTest {

	 @Test
	    public void testObtener() {
		 	CiudadDaoImp dao= null;
	        List<Ciudad> lista = null;
	        int total = 1;

	        try {
	            // Act
	            dao = new CiudadDaoImp();
	            lista = dao.obtener();
	            // Assert
	           
	            assertTrue(total <= lista.size());
	        } catch (MyException e) {
	            fail(e.getMessage());
	        }

	    }

//	@Test
//	public void testObtenerInt() {
//		fail("Not yet implemented");
//	}

}
