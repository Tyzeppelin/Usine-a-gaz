package compilateur;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IdFonc extends Ident {
	/**
	 * La liste des paramêtres de la fonctions
	 */
	private List<IdParam> listParam;

	public IdFonc(String nom) {
		super(nom);
		listParam = new ArrayList<IdParam>();
	}
	/**
	 * Retourne le nombre de paramètre de la fonction
	 * @return
	 */
	public int getNbParam()
	{
		return listParam.size();
	}
	/**
	 * Ajoute un paramêtre à la fonction
	 * @param param
	 */
	public void addParam(IdParam param)
	{
		listParam.add(param);
	}
	/**
	 * Récupère le ième paramètre de la fonction
	 * @param i
	 * @return
	 */
	public IdParam getParam(int i) 
	{
		return listParam.get(i);
	}

	/**
	 * Genère l'appel à la fonction
	 */
	@Override
	public void generateIdent(Generation gen) {
		gen.call(this);
	}
	/**
	 * Génère le ireturn de la fonction
	 * @param gen
	 */
	public void generateReturn(Generation gen)
	{
	  	  gen.ireturn(this);
	}

	/**
	 * Retourne 0. Cette fonction n'est pas utile dans cette classe
	 */
	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Ne fait rien.
	 */
	@Override
	public void setValeur(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "IdFonc "+nom+"["+type+"] [listParam=" + listParam + "]";
	}
	
	/**
	 * Attribut automatiquement les offsets des paramètres de la fonction.
	 * Cette fonction doit être appelé après que tous les paramètres soient déclarés.
	 */
	public void setOffsetParams()
	{
		ListIterator<IdParam> li = listParam.listIterator(listParam.size());
		int offset = 4;
		while(li.hasPrevious()) {
		  li.previous().setValeur(offset);
		  offset += 2;
		}
	}
	@Override
	public boolean canBeAffected() {
		return false;
	}

	
	

}
