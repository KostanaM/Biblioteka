package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		// adresa gde se nalazi baza sa kojom zelimo da se povezemo
		// korisnicko ime servera kome prestupam
		// lozinka servera kome pristupamo

		String url = "jdbc:mysql://localhost:3306/bibliotekapraksa";
		String username = "root";
		String password = "";

		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("Uspesna konekcija ka bazi");

			String sqlinsert = "INSERT INTO autori(imeAutora, prezimeAutora)values(?, ?)";

			PreparedStatement ps = conn.prepareStatement(sqlinsert);
			ps.setString(1, "Lav");
			ps.setString(2, "Tolstoj");

			int unetPodatak = ps.executeUpdate();
			if (unetPodatak > 0)

				System.out.println("Podatak je upisan");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
