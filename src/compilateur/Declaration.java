package compilateur;

import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.ReturnTypeNotCorrectException;
import yaka.YakaConstants;

/**
 * Classe de declaration d'une fonction <br>
 * @author francois
 *
 */
public class Declaration implements YakaConstants{
	
	private TabIdent tabIdent;
	private IdFonc actualFonc;
	
	public Declaration(TabIdent tabIdent)
	{
		this.tabIdent=tabIdent;
	}
	
	/**
	 * Methode de test du type de retour
	 * @param typeRetour : le type de retour de la fonction
	 * @throws ReturnTypeNotCorrectException : si le type retourne n'est pas celui declare
	 */
	public void testRetourneType(Type typeRetour) throws ReturnTypeNotCorrectException
	{
		if (typeRetour != actualFonc.getType())
		{
			throw new ReturnTypeNotCorrectException(actualFonc.getType());
		}
	}
	
	/**
	 * Methode d'ajout d'une fonction avec son nom
	 * @param name : le nom de la fonction
	 * @throws IdentAlreadyDeclaredException : si la fonction est deja declare
	 */
	public void addFonction(String name) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdentGlobal(name))
		{
			actualFonc = new IdFonc(name);
			tabIdent.rangeIdentGlobal(name, actualFonc);
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	/**
	 * Methode d'ajout d'une fonction avec son nom et son type
	 * @param name : le nom de la fonction
	 * @param type : le type de retour de la fonction
	 * @throws IdentAlreadyDeclaredException : si la fonction est deja declare
	 */
	public void addFonction(String name, Type type) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdentGlobal(name))
		{
			actualFonc = new IdFonc(name);
			actualFonc.setType(type);
			tabIdent.rangeIdentGlobal(name, actualFonc);
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	/**
	 * Methode d'ajout d'un parametre à la fonction avec son nom et son type
	 * @param name : le nom du parametre
	 * @param type : le type du parametre
	 * @throws IdentAlreadyDeclaredException : si le parametre est deja declare
	 */
	public void addParam(String name, Type type) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdentLocal(name))
		{
			IdParam param = new IdParam(name,type);
			param.setValeur((tabIdent.nbVarDeclared()+1)*2);
			actualFonc.addParam(param);
			tabIdent.rangeIdentLocal(name, param);
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	/**
	 * Methode d'ajout d'une constante a l'environnement de la fonction
	 * @param name : nom de la constante
	 * @param type : type de la contante
	 * @param value : valeur de la constante
	 * @throws IdentAlreadyDeclaredException : si la constante est deja declaree
	 */
	public void addConst(String name,Type type, int value) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdentLocal(name))
		{
			tabIdent.rangeIdentLocal(name, new IdConst(name, type, value));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	/**
	 * Methode d'ajout d'une constante a l'environnement de la fonction
	 * @param name : le nom de la constante
	 * @param ident : l'ident de la constante
	 * @throws IdentAlreadyDeclaredException : si la constante est deja declaree
	 * @throws IdentDoesNotExistException : si l'ident n'existe pas
	 */
	public void addConstIdent(String name,String ident) throws IdentAlreadyDeclaredException, IdentDoesNotExistException
	{
		if (!tabIdent.existeIdentLocal(name))
			tabIdent.rangeIdentLocal(name, tabIdent.chercheIdentLocal(ident));
		else
			throw new IdentAlreadyDeclaredException(name);
	}
	
	/**
	 * Ajout d'une varaiable a l'environnement de la fonction
	 * @param name : nom de la variable a ajouter
	 * @param type : type de la variable a ajouter
	 * @throws IdentAlreadyDeclaredException
	 */
	public void addVar(String name, int type) throws IdentAlreadyDeclaredException
	{
		if (!tabIdent.existeIdentLocal(name))
		{
			tabIdent.rangeIdentLocal(name, new IdVar(name,Type.intToType(type),(tabIdent.nbVarDeclared()+1)*(-2)));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}

}
