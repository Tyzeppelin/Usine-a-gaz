package compilateur;

public abstract class Ident {
	
	protected enum Type {
		ENTIER, BOOLEEN;
	}
	
	private String nom;
	private Type type;
	
	
	public Ident(String nom, Type type) {
		super();
		this.nom = nom;
		this.type = type;
	}
	
	
	public abstract int getValeur();
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

}
