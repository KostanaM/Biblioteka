package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		// adresa gde se nalazi baza sa kojom zelimo da se povezemo
		// korisnicko ime servera kome prestupam
		// lozinka servera kome pristupamo

		String url = "jdbc:mysql://localhost:3306/bibliotekapraksa";
		String username = "root";
		String password = "";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Uspesna konekcija ka bazi!");

			String sqldelete = "DELETE FROM autori WHERE autorID = ? ";

			PreparedStatement ps = conn.prepareStatement(sqldelete);

			ps.setString(1, "3"); // uslov

			int obrisanPodatak = ps.executeUpdate();

			if (obrisanPodatak > 0)
				System.out.println("Podatak je uspesno obrisan!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
