package compilateur;

import yaka.Yaka;
import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.SemanticException;
import exceptions.TypeParamException;

/**
 * Classe de contrôle du type de fonction 
 * @author francois
 *
 */
public class ControlTypeFonction {
	
	private int nb;
	private IdFonc fonc;
	
	public ControlTypeFonction()
	{
		nb = 0;
	}
	
	/**
	 * Methode d'initialisation du test. 
	 * @param nameFonc : le nom de la fonction a tester
	 * @throws IdentDoesNotExistException : si la fonction n'existe pas
	 * @throws IdentAlreadyDeclaredException 
	 */
	public void initTest(String nameFonc) throws IdentDoesNotExistException, IdentAlreadyDeclaredException
	{
		try
		{
			fonc = (IdFonc) Yaka.tabIdent.chercheIdentGlobal(nameFonc);
		}
		catch(SemanticException e)
		{
			Yaka.decl.addFonction(nameFonc, Type.ERR);
			fonc = (IdFonc) Yaka.tabIdent.chercheIdentGlobal(nameFonc);
			throw e;
		}
	}
	
	/**
	 *  Methode de test du type d'un parametre
	 * @param type : le type du parametre à tester
	 * @throws TypeParamException : si le type du parametre [nb] est different du type passé en parametre
	 * @throws TooMuchParamException 
	 */
	public void testTypeParam(Type type) throws TypeParamException, TooMuchParamException
	{
		if (nb>=fonc.getNbParam())
		{
			throw new TooMuchParamException(fonc.getNom());
		}
		if (fonc.getParam(nb).getType() != type)
		{
			throw new TypeParamException(fonc.getParam(nb));
		}
		nb++;
	}
	
	public void testNbParam(int nbParam) throws NotEnoughParamException
	{
		if (nbParam != fonc.getNbParam())
		{
			throw new NotEnoughParamException(fonc.getNom());			
		}
	}

}
