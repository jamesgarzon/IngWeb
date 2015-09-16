package co.udea.edu.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import co.edu.udea.iw.dao.CiudadDao;
import co.edu.udea.iw.dao.cnf.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;

public class CiudadDaoImp implements CiudadDao {

	@Override
	public List<Ciudad> obtener() throws MyException{
		Connection con = null;
		DataSource ds = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		
		try {
			ds = new DataSource();
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM Ciudades");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				ciudades.add(ciudad);
			}
		} catch (SQLException e) {
			throw new MyException("Error con la sentencia SQL",e);
		}finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
		}
		return ciudades;
	}
	
	@Override
	public Ciudad obtener(int codigo) throws MyException{
		Connection con = null;
		DataSource ds = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		Ciudad ciudad = null;		
		try {
			ds = new DataSource();
			con = ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM Ciudades where codigo=?");
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()){
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
			}	

		} catch (SQLException e) {
			throw new MyException("Error con la sentencia SQL",e);
		}finally{
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
			if (con != null){
				try {
					con.close();
				} catch (SQLException e) {
					throw new MyException(e);
				}
			}
			
		}
		return ciudad;
	}

}
