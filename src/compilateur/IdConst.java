package compilateur;

public class IdConst extends Ident {
	

	private int val;

	public IdConst(String nom)
	{
		super(nom);
	}
	public IdConst(String nom, Type type, int val) {
		super(nom, type);
		this.val = val;
	}

	@Override
	public int getValeur() {
		return val;
	}

	@Override
	public void setValeur(int value)
	{
		val = value; 
	}
	

}
