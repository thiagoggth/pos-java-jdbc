package Model;

public class Secretario extends Pessoa {

	private String registro;
	private String nivelCargo;
	private String experiencia;

	private String login;
	private String senha;

	public Secretario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public Secretario() {
		// TODO Auto-generate constructor stub.
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
