package connectionjdbc;

import java.util.ArrayList;

import org.junit.Test;

import Model.Secretario;
import dao.SecretarioDAO;

//Classe para testar o funcionamento das funcionalidades da classe Secretario.
public class TestSecretarioDAO {

	// Testes para criação de novo secretario.
	// @Test
	public void createSecretario() {
		Secretario secretario = new Secretario();

		secretario.setNome("Thiago Augusto");
		secretario.setIdade(22);
		secretario.setRegistroGeral("35165135");
		secretario.setNumeroCpf("07728308190");
		secretario.setNomePai("Unilson de paula");
		secretario.setNomeMae("Lidiane Cristina");
		secretario.setRegistro("4168463816");
		secretario.setNivelCargo("alto");
		secretario.setExperiencia("muita");
		secretario.setLogin("thiagoggth");
		secretario.setSenha("123");

		SecretarioDAO secretarioDAO = new SecretarioDAO();

		secretarioDAO.create(secretario);
	}

	// Testes de autenticação de secretario.
	//@Test
	public void autenticar() {

		SecretarioDAO secretarioDAO = new SecretarioDAO();

		System.out.println("===== Testes de login =====");
		for (int i = 0; i <= 3; i++) {
			Secretario secretario = new Secretario();

			System.out.print("Teste com ");

			// Testes de login diferentes.
			switch (i) {
			case 0:
				secretario.setLogin("thiagoggth");
				secretario.setSenha("123");
				System.out.print("usuario e senha corretos: ");
				break;
			case 1:
				secretario.setLogin("thiagoggth");
				secretario.setSenha("1234");
				System.out.print("senha errada: ");
				break;
			case 2:
				secretario.setLogin("thiagoggthg");
				secretario.setSenha("123");
				System.out.print("usuario errado: ");
				break;
			case 3:
				secretario.setLogin("thiagoggthgg");
				secretario.setSenha("1234");
				System.out.print("usuario e senha errados: ");
				break;
			default:
				break;
			}
			boolean isTrue = secretarioDAO.autenticar(secretario);

			System.out.println(isTrue);
		}

	}
}
