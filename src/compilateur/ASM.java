package compilateur;

import java.io.OutputStream;

public class ASM  extends AbstractGeneration {
	
	private YVM yvm;
	
	public ASM(String nameFile)
	{
		super(nameFile);
		yvm = new YVM(out);
	}

	@Override
	public void header() {
		Ecriture.ecrireChar(out, ';');
		yvm.header();
		
		
	}

	@Override
	public void footer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iconst(int val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void istore(int offset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iload(int offset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void idiv() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imul() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iadd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isub() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ineg() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inot() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ior() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iinf() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iinfegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isupegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void iegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void idiff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ecrireInt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ecrireBool() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ecrireString(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alaligne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lire(int offset) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ouvrePrinc(int i) {
		// TODO Auto-generated method stub
		
	}

}
