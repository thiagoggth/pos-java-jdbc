package connectionjdbc;

import org.junit.Test;

import Model.Secretario;
import dao.SecretarioDAO;

public class TestSecretarioDAO {
	
	@Test
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

}
