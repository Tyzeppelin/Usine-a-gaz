package compilateur;

public abstract class Ident {
	
	
	protected String nom;
	protected Type type;
	
	public Ident(String nom)
	{
		super();
		this.nom = nom;
	}
	public Ident(String nom, Type type) {
		super();
		this.nom = nom;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Ident [nom=" + nom + ", type=" + type + "]";
	}
	
	public abstract int getValeur();
	public abstract void setValeur(int value);
	
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
	
	public abstract void generateIdent(Generation gen);
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Ident)) {
			return false;
		}
		Ident other = (Ident) obj;
		if (nom == null) {
			if (other.nom != null) {
				return false;
			}
		} else if (!nom.equals(other.nom)) {
			return false;
		}
		if (type != other.type) {
			return false;
		}
		return true;
	}
	
	

}
