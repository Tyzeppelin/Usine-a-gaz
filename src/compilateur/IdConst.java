package compilateur;

public class IdConst extends Ident {
	
	private int val;

	public IdConst(String nom, Type type, int val) {
		super(nom, type);
		this.val = val;
	}

	@Override
	public int getValeur() {
		return val;
	}
	
	

}
