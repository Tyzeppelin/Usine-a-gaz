package compilateur;

import java.io.OutputStream;

public class AbstractGeneration implements Generation {

	protected OutputStream out;
	
	protected AbstractGeneration()
	{
		
	}
	protected AbstractGeneration(String nameFile)
	{
		out = Ecriture.ouvrir(nameFile);
	}

	public void operation(Operateur op) {
		switch (op)
		{
		case ADD:
			iadd();
			break;
		case SUB:
			isub();
			break;
		case MUL:
			imul();
			break;
		case DIV:
			idiv();
			break;
		case INF:
			iinf();
			break;
		case SUP:
			isup();
			break;
		case INFE:
			iinfegal();
			break;
		case SUPE:
			isupegal();
			break;
		case EQU:
			iegal();
			break;
		case DIFF:
			idiff();
			break;
		case AND:
			iand();
			break;
		case OR:
			ior();
			break;
		case NEG:
			ineg();
			break;
		case NOT:
			inot();
			break;
		}
	}

	@Override
	public void header() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ouvrePrinc(int i) {
		// TODO Auto-generated method stub
		
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

}
