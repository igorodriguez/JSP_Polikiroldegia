package modelo.util;

import java.util.Comparator;

import modelo.bean.Usuario;

public class EremuaComparator implements Comparator <Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		
		return o1.getNombreApellido().compareToIgnoreCase(o2.getDni());
	}

}
