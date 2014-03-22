package compilateur;

import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.ReturnTypeNotCorrectException;
import yaka.YakaConstants;

public class Declaration implements YakaConstants{
	
	private TabIdent tabIdent;
	private IdFonc actualFonc;
	
	public Declaration(TabIdent tabIdent)
	{
		this.tabIdent=tabIdent;
	}
	
	public void testRetourneType(Type typeRetour) throws ReturnTypeNotCorrectException
	{
		if (typeRetour != actualFonc.getType())
		{
			throw new ReturnTypeNotCorrectException(actualFonc.getType());
		}
	}
	
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
	
	public void addConstIdent(String name,String ident) throws IdentAlreadyDeclaredException, IdentDoesNotExistException
	{
		if (!tabIdent.existeIdentLocal(name))
			tabIdent.rangeIdentLocal(name, tabIdent.chercheIdentLocal(ident));
		else
			throw new IdentAlreadyDeclaredException(name);
	}
	
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
