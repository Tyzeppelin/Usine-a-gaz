package compilateur;

public abstract class Ident {
	
	/**
	 * Le nom de l'identifiant
	 */
	protected String nom;
	/**
	 * Son type
	 */
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
	/**
	 * Retourne la valeur de l'identifiant
	 * @return
	 */
	public abstract int getValeur();
	/**
	 * Modifie la valeur de l'identifiant
	 * @param value
	 */
	public abstract void setValeur(int value);
	/**
	 * Retourne le type de l'identifiant
	 * @return
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Modifie le type de l'identifiant
	 * @param type
	 */
	public void setType(Type type) {
		this.type = type;
	}
	/**
	 * Retourne le nom de l'identifiant
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Modifie le nom de l'identifiant
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Genère le code pour l'identifiant
	 * @param gen
	 */
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
