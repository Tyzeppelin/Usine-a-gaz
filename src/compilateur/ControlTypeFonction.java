package compilateur;

import exceptions.IdentDoesNotExistException;
import exceptions.TypeParamException;

public class ControlTypeFonction {
	
	private int nb;
	private TabIdent tabIdent;
	private IdFonc fonc;
	
	public ControlTypeFonction(TabIdent tabIdent)
	{
		this.tabIdent = tabIdent;
		nb = 0;
	}
	
	public void initTest(String nameFonc) throws IdentDoesNotExistException
	{
		fonc = (IdFonc) tabIdent.chercheIdentGlobal(nameFonc);
	}
	
	public void testTypeParam(Type type) throws TypeParamException
	{
		if (fonc.getParam(nb).getType() != type)
		{
			throw new TypeParamException(fonc.getParam(nb));
		}
	}

}
