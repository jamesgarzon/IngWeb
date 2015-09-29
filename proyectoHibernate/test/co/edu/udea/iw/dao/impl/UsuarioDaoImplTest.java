package co.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

public class UsuarioDaoImplTest {

	@Test
	public void testObtener() {
		UsuarioDaoImp dao= null;
        List<Usuario> lista = null;
        int total = 1;

        try {
            // Act
            dao = new UsuarioDaoImp();
            lista = dao.obtener();
            // Assert
           
            assertTrue(total <= lista.size());
        } catch (MyException e) {
            fail(e.getMessage());
        }
	}

//	@Test
	public void testObtenerString() {
		fail("Not yet implemented");
	}

//	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

//	@Test
	public void testActualizar() {
		fail("Not yet implemented");
	}

//	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
