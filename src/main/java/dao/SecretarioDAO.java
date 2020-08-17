package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Model.Secretario;
import connectionjdbc.SingleConnection;
import interfaces.IPermitirAcesso;

public class SecretarioDAO implements IPermitirAcesso {

	private Connection connection;

	public SecretarioDAO() {
		connection = SingleConnection.getConnection();
	}

	public void create(Secretario secretario) {
		try {
			String sql = "insert into secretario(nome, idade, registroGeral, numeroCpf, "
					+ "nomePai, nomeMae, registro, nivelCargo, experiencia, login, senha "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);

			insert.setNString(1, secretario.getNome());
			insert.setInt(2, secretario.getIdade());
			insert.setString(3, secretario.getRegistroGeral());
			insert.setString(4, secretario.getNumeroCpf());
			insert.setString(5, secretario.getNomePai());
			insert.setString(6, secretario.getNomeMae());
			insert.setNString(7, secretario.getRegistro());
			insert.setString(8, secretario.getNivelCargo());
			insert.setString(9, secretario.getExperiencia());
			insert.setString(10, secretario.getLogin());
			insert.setString(11, secretario.getSenha());

			insert.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	@Override
	public boolean Autenticar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Autenticar(String login, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

}
