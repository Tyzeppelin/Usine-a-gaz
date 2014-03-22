package compilateur;

import java.util.ArrayList;
import java.util.List;

public class IdFonc extends Ident {
	
	private List<IdParam> listParam;

	public IdFonc(String nom) {
		super(nom);
		listParam = new ArrayList<IdParam>();
	}
	
	public int getNbParam()
	{
		return listParam.size();
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
	public void generateIdent(Generation gen) {
		

	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValeur(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "IdFonc "+nom+"["+type+"] [listParam=" + listParam + "]";
	}

	
	

}
