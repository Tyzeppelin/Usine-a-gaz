package compilateur;

import java.util.ArrayList;
import java.util.List;

public class IdFonc extends Ident {
	
	private List<IdParam> listParam;
	private Type typeReturn;

	public IdFonc(String nom) {
		super(nom);
		listParam = new ArrayList<IdParam>();
	}
	
	public void addParam(IdParam param)
	{
		listParam.add(param);
	}
	
	public IdParam getParam(int i)
	{
		return listParam.get(i);
	}

	@Override
	public int getValeur() {
		return typeReturn.ordinal();
	}

	@Override
	public void setValeur(int value) {
		typeReturn = Type.intToType(value);
	}

	@Override
	public void generateIdent(Generation gen) {
		

	}

}
