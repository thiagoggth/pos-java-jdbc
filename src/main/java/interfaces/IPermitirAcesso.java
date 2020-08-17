package interfaces;

//In the interface only the method signature is implemented.
public interface IPermitirAcesso {
	
	public boolean Autenticar();
	public boolean Autenticar(String login, String senha);

}
