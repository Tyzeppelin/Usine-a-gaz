package compilateur;

public class IdVar extends Ident {
	
	private int offset;


	public IdVar(String nom, Type type) {
		super(nom, type);
	}
	public IdVar(String nom, Type type, int offset) {
		super(nom, type);
		this.offset = offset;
	}


	@Override
	public int getValeur() {
		return offset;
	}

	@Override
	public void setValeur(int value)
	{
		offset = value; 
	}
	

}
