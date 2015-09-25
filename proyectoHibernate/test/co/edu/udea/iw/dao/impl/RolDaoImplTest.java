package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.exception.MyException;

public class RolDaoImplTest {

	 @Test
	    public void testObtenerRoles() {
		 	RolDaoImp dao= null;
	        List<Rol> lista = null;
	        int total = 1;

	        try {
	            // Act
	            dao = new RolDaoImp();
	            lista = dao.obtener();
	            // Assert
	           
	            assertTrue(total <= lista.size());
	        } catch (MyException e) {
	            fail(e.getMessage());
	        }

	    }

	@Test
	public void testObtenerRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        int codigoCiudad = 1;
        try {
            // Act
            dao = new RolDaoImp();
            rol = dao.obtener(codigoCiudad);
            // Assert
           
            assertTrue(rol != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void testGuardarCiudad() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoCiudad = 1;
        try {
            // Act
            dao = new RolDaoImp();
            rol = new Rol();
            rol.setCodigo(9);
            rol.setNombre("Administrador");
            dao.guardar(rol);
            // Assert
            rolConsulta = dao.obtener(9);
            assertTrue(rolConsulta != null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void testActualizarCiudad() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoRol = 1;
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener(9);
            rol.setNombre("La Ceja del Tambo");
            dao.actualizar(rol);
            // Assert
            rolConsulta = dao.obtener(9);
            assertTrue(rolConsulta.getNombre().equals("La Ceja del Tambo"));
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}
	
	@Test
	public void testEliminarRol() {
		RolDaoImp dao= null;
        Rol rol = null;
        Rol rolConsulta = null;
        int codigoRol = 1;
        try {
            // Act
        	rol  = new Rol();
            dao = new RolDaoImp();
            rol =dao.obtener(9);
            dao.eliminar(rol);
            // Assert
            rolConsulta = dao.obtener(4);
            assertTrue(rolConsulta == null);
        } catch (MyException e) {
            fail(e.getMessage());
        }

	}

}
