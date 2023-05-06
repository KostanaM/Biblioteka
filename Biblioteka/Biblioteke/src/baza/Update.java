package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

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

			String sqlupdate = "UPDATE autori SET imeAutora = ?, prezimeAutora = ? WHERE autorID = ? ";

			PreparedStatement ps = conn.prepareStatement(sqlupdate);
			ps.setString(1, "Laslo");
			ps.setString(2, "Kraus");

			ps.setString(3, "2"); // uslov

			int promenjenPodatak = ps.executeUpdate();

			if (promenjenPodatak > 0)
				System.out.println("Uspesno je izvrsena izmena!");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
