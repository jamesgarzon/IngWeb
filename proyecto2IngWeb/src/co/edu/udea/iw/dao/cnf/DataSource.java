package co.edu.udea.iw.dao.cnf;
import co.edu.udea.iw.exception.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public Connection getConnection() throws MyException{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase","root","root");
		} catch (ClassNotFoundException e) {
			throw new MyException("No se ha cargado el driver de la base de datos",e);
		} catch (SQLException e) {
			throw new MyException(e);
		}
		return con;
	}
}
