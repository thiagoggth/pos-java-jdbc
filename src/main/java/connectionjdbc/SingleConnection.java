package connectionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:mysql://localhost:3306/posjava";
	private static String password = "";
	private static String user = "root";
	private static Connection connection = null;

	static {
		connect();
	}

	public SingleConnection() {
		connect();
	}

	private static void connect() {
		try {
			if (connection == null) {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("success connected!!!");
			}

		} catch (Exception e) {

		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
