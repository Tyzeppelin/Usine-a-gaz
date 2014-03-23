package compilateur;

import exceptions.IdentDoesNotExistException;
import exceptions.TypeParamException;

/**
 * Classe de contrôle du type de fonction <br>
 * @author francois
 *
 */
public class ControlTypeFonction {
	
	private int nb;
	private TabIdent tabIdent;
	private IdFonc fonc;
	
	public ControlTypeFonction(TabIdent tabIdent)
	{
		this.tabIdent = tabIdent;
		nb = 0;
	}
	
	/**
	 * Methode d'initialisation du test. 
	 * @param nameFonc : le nom de la fonction a tester
	 * @throws IdentDoesNotExistException : si la fonction n'existe pas
	 */
	public void initTest(String nameFonc) throws IdentDoesNotExistException
	{
		fonc = (IdFonc) tabIdent.chercheIdentGlobal(nameFonc);
	}
	
	/**
	 *  Methode de test du type d'un parametre
	 * @param type : le type du parametre à tester
	 * @throws TypeParamException : si le type du parametre [nb] est different du type passé en parametre
	 */
	public void testTypeParam(Type type) throws TypeParamException
	{
		if (fonc.getParam(nb).getType() != type)
		{
			throw new TypeParamException(fonc.getParam(nb));
		}
	}

}
