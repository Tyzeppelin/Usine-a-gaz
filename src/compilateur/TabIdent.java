package compilateur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exceptions.IdentDoesNotExistException;

public class TabIdent {

	private Map<String, Ident> table;
	
	public TabIdent() {
		table = new HashMap<String, Ident>();
	}
	
	public int nbVarDeclared()
	{
		int compteur = 0;

		Iterator<Ident> i = table.values().iterator();
		while (i.hasNext()) {
			if(i.next() instanceof IdVar) {
				compteur++;
			}
		}

		return compteur;
	}
	
	public Ident chercheIdent(String cle) throws IdentDoesNotExistException {
		if (existeIdent(cle))
		{
			return table.get(cle);
		}
		else
		{
			throw new IdentDoesNotExistException(cle);
		}
	}
	
	public boolean existeIdent(String cle) {
		return table.containsKey(cle);
	}
	
	public void rangeIdent(String cle, Ident id) {
		if (id!=null)
			table.put(cle, id);
	}	
	
	public String toString()
	{
		return table.toString();
	}
}
