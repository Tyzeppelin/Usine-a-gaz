package compilateur;

import yaka.Yaka;
import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.NotEnoughParamException;
import exceptions.TooMuchParamException;
import exceptions.TypeParamException;

/**
 * Classe de contr�le du type de fonction 
 * @author francois
 *
 */
public class ControlTypeFonction {
	
	private int nbParam;
	private IdFonc fonc;
	
	public ControlTypeFonction()
	{
		nbParam = 0;
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
		catch(IdentDoesNotExistException e)
		{
			Yaka.decl.addFonction(nameFonc, Type.ERR);
			fonc = (IdFonc) Yaka.tabIdent.chercheIdentGlobal(nameFonc);
			throw e;
		}
	}
	
	/**
	 *  Methode de test du type d'un parametre
	 * @param type : le type du parametre � tester
	 * @throws TypeParamException : si le type du parametre [nb] est different du type pass� en parametre
	 * @throws TooMuchParamException 
	 */
	public void testTypeParam(Type type) throws TypeParamException, TooMuchParamException
	{
		int tmp = nbParam;
		nbParam++;
		if (tmp>=fonc.getNbParam())
		{
			throw new TooMuchParamException(fonc.getNom(),tmp-(fonc.getNbParam()));
		}
		if (fonc.getParam(tmp).getType() != type)
		{
			throw new TypeParamException(fonc, fonc.getParam(tmp));
		}
	}
	
	/**
	 * Test si le nombre de paramètres de la fonction est le bon
	 * @param nbParam
	 * @throws NotEnoughParamException
	 * @throws TooMuchParamException 
	 */
	public void testNbParam() throws NotEnoughParamException, TooMuchParamException
	{
		if (nbParam < fonc.getNbParam())
		{
			throw new NotEnoughParamException(fonc.getNom(),fonc.getNbParam()-nbParam);			
		}
		if (nbParam>fonc.getNbParam())
		{
			throw new TooMuchParamException(fonc.getNom(),nbParam-fonc.getNbParam());
		}
	}

}
