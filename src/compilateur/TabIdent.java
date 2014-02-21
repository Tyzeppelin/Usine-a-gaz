package compilateur;

import java.util.HashMap;
import java.util.Map;

public class TabIdent {

	private Map<String, Ident> table;
	
	public TabIdent() {
		table = new HashMap<String, Ident>();
	}
	
	public Ident chercheIdent(String cle) {
		// Retourne null si cle non existante
		return table.get(cle);
	}
	
	public boolean existeIdent(String cle) {
		return table.containsKey(cle);
	}
	
	public void rangeIdent(String cle, Ident id) {
		table.put(cle, id);
	}	
}
