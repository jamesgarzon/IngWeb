package proyecto1IngWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clase {

	public static void main(String[] args) {

		String valor = "4";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root", "");
			PreparedStatement ps = con.prepareStatement("select * from ciudades where codigoArea=?");
			ps.setString(1, valor);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Ciudad: " + rs.getString("Nombre"));
			}
			rs.close();
			ps.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
