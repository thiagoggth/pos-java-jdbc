package connectionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

// Classe para estabelcer a conexao com o banco.
public class SingleConnection {

	// Dados para realizar a conexao com o banco.
	private static String url = "jdbc:mysql://localhost:3306/posjava";
	private static String password = "";
	private static String user = "root";

	// Variavel que ira receber a conexao com o banco.
	private static Connection connection = null;

	static {
		connect();
	}

	// O Construtor garante a criação da conexao quando o objeto for criado.
	public SingleConnection() {
		connect();
	}

	// Realiza a conexao se a mesma nao tiver sido criada anteriormente.
	private static void connect() {
		try {
			if (connection == null) {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}

		} catch (Exception e) {

		}
	}

	// Função publica que retorna a cocexao com o banco.
	public static Connection getConnection() {
		return connection;
	}

}
