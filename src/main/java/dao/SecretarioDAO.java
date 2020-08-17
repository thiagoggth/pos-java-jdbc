package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Secretario;
import connectionjdbc.SingleConnection;
import interfaces.IPermitirAcesso;

public class SecretarioDAO implements IPermitirAcesso {

	private Connection connection;

	public SecretarioDAO() {
		connection = SingleConnection.getConnection();
	}

	// Função para inserir um novo secretario no banco de dados.
	public void create(Secretario secretario) {
		try {
			// Preparando a query.
			String sql = "insert into secretario(nome, idade, registroGeral, numeroCpf, "
					+ "nomePai, nomeMae, registro, nivelCargo, experiencia, login, senha) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			// Declarando os valores da query.
			insert.setString(1, secretario.getNome());
			insert.setInt(2, secretario.getIdade());
			insert.setString(3, secretario.getRegistroGeral());
			insert.setString(4, secretario.getNumeroCpf());
			insert.setString(5, secretario.getNomePai());
			insert.setString(6, secretario.getNomeMae());
			insert.setString(7, secretario.getRegistro());
			insert.setString(8, secretario.getNivelCargo());
			insert.setString(9, secretario.getExperiencia());
			insert.setString(10, secretario.getLogin());
			insert.setString(11, secretario.getSenha());

			// Executando a query.
			insert.execute();
			connection.commit();
		} catch (Exception e) {
			// Desfasendo as alterações e impromindo o erro no console.
			try {
				connection.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// Função para verificar se o usuario existe no banco de dados.
	@Override
	public boolean autenticar(Secretario secretario) {
		try {
			// Preparando a query.
			String sql = "select * from secretario where login = ? and senha = ?";
			PreparedStatement select = connection.prepareStatement(sql);

			// Inserindo os valores na query.
			select.setString(1, secretario.getLogin());
			select.setString(2, secretario.getSenha());

			// Executando a query.
			ResultSet result = select.executeQuery();

			// Inserindo os valores retorados no objeto de secretario.
			while (result.next()) {
				secretario.setId(result.getInt("id"));
			}

			// Se id = 0 o secretario existe no banco, autenticação verdadeira.
			if (secretario.getId() != 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
