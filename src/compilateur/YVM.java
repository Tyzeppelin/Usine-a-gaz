package compilateur;

import java.io.OutputStream;

public class YVM extends AbstractGeneration {
	
	public YVM(OutputStream out)
	{
		this.out=out;
	}
	public YVM(String nameFile)
	{
		super(nameFile);
	}

	@Override
	public void header() {
		Ecriture.ecrireStringln(out,"entete");
	}

	@Override
	public void footer() {
		Ecriture.ecrireStringln(out,"queue");	
		Ecriture.fermer(out);
	}

	@Override
	public void iconst(int val) {
		Ecriture.ecrireStringln(out,"iconst "+val);		
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireStringln(out,"istore "+offset);				
	}

	@Override
	public void iload(int offset) {
		Ecriture.ecrireStringln(out,"iload "+offset);	
	}

	@Override
	public void idiv() {
		Ecriture.ecrireStringln(out,"idiv");
	}

	@Override
	public void imul() {
		Ecriture.ecrireStringln(out,"imul");
	}

	@Override
	public void iadd() {
		Ecriture.ecrireStringln(out,"iadd");
	}

	@Override
	public void isub() {
		Ecriture.ecrireStringln(out,"isub");
	}

	@Override
	public void ineg() {
		Ecriture.ecrireStringln(out,"ineg");
	}

	@Override
	public void inot() {
		Ecriture.ecrireStringln(out,"inot");
	}

	@Override
	public void ior() {
		Ecriture.ecrireStringln(out,"ior");
	}

	@Override
	public void iand() {
		Ecriture.ecrireStringln(out,"iand");
	}

	@Override
	public void iinf() {
		Ecriture.ecrireStringln(out,"iinf");
	}

	@Override
	public void isup() {
		Ecriture.ecrireStringln(out,"isup");
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireStringln(out,"iinfegal");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireStringln(out,"isupegal");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireStringln(out,"iegal");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireStringln(out,"idiff");
	}

	@Override
	public void ecrireInt() {
		Ecriture.ecrireStringln(out,"ecrireInt");
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireStringln(out,"ecrireBool");
	}

	@Override
	public void ecrireString(String s) {
		Ecriture.ecrireStringln(out,"ecrireChaine "+s+" ");
	}

	@Override
	public void alaligne() {
		Ecriture.ecrireStringln(out,"aLaLigne");
	}

	@Override
	public void lire(int offset) {
		Ecriture.ecrireStringln(out,"lireEnt "+offset);
	}

	@Override
	public void ouvrePrinc(int i) {
		Ecriture.ecrireStringln(out,"ouvrePrinc "+i);
	}
}
