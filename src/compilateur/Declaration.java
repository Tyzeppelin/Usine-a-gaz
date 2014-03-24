package compilateur;

import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.ReturnTypeNotCorrectException;
import yaka.Yaka;
import yaka.YakaConstants;

/**
 * Classe de declaration d'une fonction
 * @author francois
 *
 */
public class Declaration implements YakaConstants{
	
	private IdFonc currentFonc;
	
	public Declaration()
	{
	}
	
	/**
	 * Retourne la fonction courante
	 * @return
	 */
	public IdFonc getCurrentFonc()
	{
		return currentFonc;
	}
	
	/**
	 * Methode de test du type de retour
	 * @param typeRetour : le type de retour de la fonction
	 * @throws ReturnTypeNotCorrectException : si le type retourne n'est pas celui declare
	 */
	public void testRetourneType(Type typeRetour) throws ReturnTypeNotCorrectException
	{
		if (typeRetour != currentFonc.getType())
		{
			throw new ReturnTypeNotCorrectException(currentFonc.getType());
		}
	}
	
	/**
	 * Methode d'ajout d'une fonction avec son nom
	 * @param name : le nom de la fonction
	 * @throws IdentAlreadyDeclaredException : si la fonction est deja declare
	 */
	public void addFonction(String name) throws IdentAlreadyDeclaredException
	{
		if (!Yaka.tabIdent.existeIdentGlobal(name))
		{
			currentFonc = new IdFonc(name);
			Yaka.tabIdent.rangeIdentGlobal(name, currentFonc);
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
		if (!Yaka.tabIdent.existeIdentGlobal(name))
		{
			currentFonc = new IdFonc(name);
			currentFonc.setType(type);
			Yaka.tabIdent.rangeIdentGlobal(name, currentFonc);
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}
	
	/**
	 * Methode d'ajout d'un parametre � la fonction avec son nom et son type
	 * @param name : le nom du parametre
	 * @param type : le type du parametre
	 * @throws IdentAlreadyDeclaredException : si le parametre est deja declare
	 */
	public void addParam(String name, Type type) throws IdentAlreadyDeclaredException
	{
		if (!Yaka.tabIdent.existeIdentLocal(name))
		{
			IdParam param = new IdParam(name,type);
			currentFonc.addParam(param);
			Yaka.tabIdent.rangeIdentLocal(name, param);
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
		if (!Yaka.tabIdent.existeIdentLocal(name))
		{
			Yaka.tabIdent.rangeIdentLocal(name, new IdConst(name, type, value));
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
		if (!Yaka.tabIdent.existeIdentLocal(name))
			Yaka.tabIdent.rangeIdentLocal(name, Yaka.tabIdent.chercheIdentLocal(ident));
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
		if (!Yaka.tabIdent.existeIdentLocal(name))
		{
			Yaka.tabIdent.rangeIdentLocal(name, new IdVar(name,Type.intToType(type),(Yaka.tabIdent.nbVarDeclared()+1)*(-2)));
		}
		else
		{
			throw new IdentAlreadyDeclaredException(name);
		}
	}

}
