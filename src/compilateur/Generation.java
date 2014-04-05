package compilateur;

public interface Generation {

	void header();
	void footer();
	
	void closeFile();
	
	// variables et constantes
	void iconst(Ident ident);
	void iconst(int val);
	void istore(Ident ident);
	void iload(Ident ident);
	
	// opérateurs
	void idiv();
	void imul();
	void iadd();
	void isub();
	
	void ineg();
	void inot();
	
	void ior();
	void iand();
	
	void iinf();
	void isup();
	void iinfegal();
	void isupegal();
	void iegal();
	void idiff();
	
	//lecture ecriture
	void ecrireInt();
	void ecrireBool();
	void ecrireString(String s);
	void alaligne();
	void lire(Ident ident);
	
	// itération
	void iffauxIter();
	void faire();
	void jumpIter();
	void fait();
	
	//condition
	void iffauxCond();
	void jumpCond();
	void sinon();
	void fsi();
	void si();
	
	//fonction
	void debut();
	void ouvreBloc(IdFonc fonc);
	void fermeBloc(IdFonc fonc);
	void ireturn(IdFonc fonc);
	void reserveRetour();
	void call(IdFonc fonc);
	
	
	
	
	
}
