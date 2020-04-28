package modelo.bean;

public class MiUsuario extends Usuario{
	
	public boolean validateUsuario(){
		 if(super.getCodigo().length() == 4 && super.getDni().length() == 8) {
			 return true;
		 }
		return false;
		
	}
}



