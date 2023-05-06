package baza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

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

			String sqlselect = "SELECT * FROM autori";

			java.sql.Statement stmt = conn.createStatement();
			// objekat za komunikaciju sa bazom

			ResultSet result = stmt.executeQuery(sqlselect); // izvrsavanje (namena)

			while (result.next()) {
				String im = result.getString(2);
				String pr = result.getString(3);

				StringBuilder builder = new StringBuilder();
				builder.append("Ime autora: ");
				builder.append(im);
				builder.append("\nPrezime autora: ");
				builder.append(pr);

				System.out.println(builder.toString());
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
