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
	
	/**
	 * Cette méthode retourne le nombre de paramêtres déclarés
	 * @return le nombre de IdParam
	 */
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
	 * Retourne l'identifiant suivant son nom. Cherche d'abord dans la table des locaux, puis dans la table des globaux.
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
	/**
	 * Cherche l'identifiant dans la table des locaux
	 * @param name
	 * @return
	 * @throws IdentDoesNotExistException
	 */
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
	/**
	 * Cherche l'identifiant dans la table des globaux
	 * @param name
	 * @return
	 * @throws IdentDoesNotExistException
	 */
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
	 * Test si l'identifiant existe dans la table des locaux
	 * @param name le nom de l'identifiant
	 * @return true si l'identifiant existe, faux sinon
	 */
	
	public boolean existeIdentLocal(String name) {
		return locaux.containsKey(name);
	}
	
	/**
	 * Test si l'identifiant existe dans la table des globaux
	 * @param name
	 * @return
	 */
	public boolean existeIdentGlobal(String name) {
		return globaux.containsKey(name);
	}
	
	/**
	 * Range l'identifiant à l'index "name" dans la table des locaux
	 * @param name le nom de l'identifiant
	 * @param id l'identifiant
	 */
	public void rangeIdentLocal(Ident id)
	{
		if (id!=null)
			locaux.put(id.getNom(), id);
	}
	/**
	 * Range l'identifiant à l'index "name" dans la table des globaux
	 * @param name le nom de l'identifiant
	 * @param id l'identifiant
	 */
	public void rangeIdentGlobal(Ident id)
	{
		if (id!=null)
			globaux.put(id.getNom(), id);
	}
	/**
	 * Efface la table des globaux et des locaux
	 */
	public void clear()
	{
		globaux.clear();
		locaux.clear();
	}
	/**
	 * Efface la table des locaux
	 */
	public void clearLocaux()
	{
		locaux.clear();
	}
	/**
	 * Efface la table des globaux
	 */
	public void clearGlobaux()
	{
		globaux.clear();
	}
	
	public String toString()
	{
		return globaux.toString()+"\n"+locaux.toString();
	}
}
