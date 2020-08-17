package interfaces;

import Model.Secretario;

//In the interface only the method signature is implemented.
public interface IPermitirAcesso {
	
	public boolean autenticar(Secretario secretario);

}
