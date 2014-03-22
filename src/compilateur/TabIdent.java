package compilateur;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exceptions.IdentDoesNotExistException;

public class TabIdent {

	private Map<String, Ident> globaux;
	private Map<String, Ident> locaux;
	
	public TabIdent() {
		globaux = new HashMap<String, Ident>();
		locaux = new HashMap<String, Ident>();
	}
	
	/**
	 * Cette méthode retourne le nombre de variable déclarée
	 * @return le nombre de IdVar
	 */
	public int nbVarDeclared()
	{
		int compteur = 0;
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()) {
			if(i.next() instanceof IdVar) {
				compteur++;
			}
		}
		return compteur;
	}
	
	public int nbParamDeclared()
	{
		int compteur = 0;
		Iterator<Ident> i = locaux.values().iterator();
		while (i.hasNext()) {
			if(i.next() instanceof IdParam) {
				compteur++;
			}
		}
		return compteur;
	}
		
	/**
	 * Retourne l'identifiant suivant son nom
	 * @param name le nom de l'identifiant
	 * @return l'identifiant
	 * @throws IdentDoesNotExistException si l'identifiant n'existe pas
	 */
	
	public Ident chercheIdent(String name) throws IdentDoesNotExistException
	{
		Ident res=null;
		try {
			res = chercheIdentLocal(name);
		} catch (IdentDoesNotExistException _) {
			try {
				res = chercheIdentGlobal(name);
			} catch (IdentDoesNotExistException e) {
				throw e;
			}
		}
		return res;
	}
	
	public Ident chercheIdentLocal(String name) throws IdentDoesNotExistException {
		if (existeIdentLocal(name))
		{
			return locaux.get(name);
		}
		else
		{
			throw new IdentDoesNotExistException(name);
		}
	}
	
	public Ident chercheIdentGlobal(String name) throws IdentDoesNotExistException {
		if (existeIdentGlobal(name))
		{
			return globaux.get(name);
		}
		else
		{
			throw new IdentDoesNotExistException(name);
		}
	}
	
	/**
	 * Test si l'identifiant existe
	 * @param name le nom de l'identifiant
	 * @return true si l'identifiant existe, faux sinon
	 */
	
	public boolean existeIdentLocal(String name) {
		return locaux.containsKey(name);
	}
	
	public boolean existeIdentGlobal(String name) {
		return globaux.containsKey(name);
	}
	
	/**
	 * Range l'identifiant à l'index "name"
	 * @param name le nom de l'identifiant
	 * @param id l'identifiant
	 */
	public void rangeIdentLocal(String name, Ident id)
	{
		if (id!=null)
			locaux.put(name, id);
	}
	
	public void rangeIdentGlobal(String name, Ident id)
	{
		if (id!=null)
			globaux.put(name, id);
	}
	
	public void clearLocaux()
	{
		locaux.clear();
	}
	
	public String toString()
	{
		return globaux.toString()+"\n"+locaux.toString();
	}
}
