package compilateur;

public class ASM  extends AbstractGeneration {
	
	private YVM yvm;
	private int numString;
	
	public ASM(String nameFile)
	{
		super(nameFile);
		yvm = new YVM(out);
		numString = 0;
	}

	@Override
	public void header() {
		Ecriture.ecrireChar(out, ';');
		yvm.header();
		
		Ecriture.ecrireStringln(out,"extrn lirent:proc, ecrent:proc\n"
				+ "extrn ecrbool:proc\n"
				+ "extrn ecrch:proc, ligsuiv:proc\n" +
				".model SMALL\n" +
				".586\n" +
				".CODE\n" +
				"debut:\n" +
				"STARTUPCODE\n");
	}

	@Override
	public void footer() {
		Ecriture.ecrireChar(out, ';');
		yvm.footer();

		Ecriture.ecrireStringln(out,"nop\n" +
				"EXITCODE\n" +
				"end debut\n");
	}

	@Override
	public void iconst(int val) {
		Ecriture.ecrireChar(out, ';');
		yvm.iconst(val);

		Ecriture.ecrireStringln(out,"push "+val+"\n");	
	}

	@Override
	public void istore(int offset) {
		Ecriture.ecrireChar(out, ';');
		yvm.istore(offset);

		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"mov word ptr[bp"+signe+offset+"], ax\n");	
	}

	@Override
	public void iload(int offset) {
		Ecriture.ecrireChar(out, ';');
		yvm.iload(offset);

		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"push word ptr[bp"+signe+offset+"]\n");
	}

	@Override
	public void idiv() {
		Ecriture.ecrireChar(out, ';');
		yvm.idiv();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cwd\n" +
				"idiv bx\n" +
				"push ax\n");
	}

	@Override
	public void imul() {
		Ecriture.ecrireChar(out, ';');
		yvm.imul();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"imul bx\n" +
				"push ax\n");
	}

	@Override
	public void iadd() {
		Ecriture.ecrireChar(out, ';');
		yvm.iadd();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"add ax,bx\n" +
				"push ax\n");
	}

	@Override
	public void isub() {
		Ecriture.ecrireChar(out, ';');
		yvm.isub();

		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"sub ax,bx\n" +
				"push ax\n");
	}

	@Override
	public void ineg() {
		Ecriture.ecrireChar(out, ';');
		yvm.ineg();

		Ecriture.ecrireStringln(out,"pop ax\n" +
				"neg ax\n" + // Calcule l'opposé de l'opérande (négation par complément à deux)
				"push ax\n");
	}

	@Override
	public void inot() {
		Ecriture.ecrireChar(out, ';');
		yvm.inot();

		Ecriture.ecrireStringln(out,"pop ax\n" +
				"not ax\n" + // Effectue un NON logique (négation par complément à un)
				"push ax\n");		
	}

	@Override
	public void ior() {
		Ecriture.ecrireChar(out, ';');
		yvm.ior();
		
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"pop bx\n" +
				"or ax, bx\n" +
				"push ax\n");	
	}

	@Override
	public void iand() {
		Ecriture.ecrireChar(out, ';');
		yvm.iand();
		
		Ecriture.ecrireStringln(out,"pop ax\n" +
				"pop bx\n" +
				"and ax, bx\n" +
				"push ax\n");			
	}

	@Override
	public void iinf() {
		Ecriture.ecrireChar(out, ';');
		yvm.iinf();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jge $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	public void isup() {
		Ecriture.ecrireChar(out, ';');
		yvm.isup();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jle $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	public void iinfegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.iinfegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jg $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	public void isupegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.isupegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jl $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	public void iegal() {
		Ecriture.ecrireChar(out, ';');
		yvm.iegal();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"jne $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");
	}

	@Override
	public void idiff() {
		Ecriture.ecrireChar(out, ';');
		yvm.idiff();
		
		Ecriture.ecrireStringln(out,"pop bx\n" +
				"pop ax\n" +
				"cmp ax, bx\n" +
				"je $+6\n" +
				"push -1\n" +
				"jmp $+4\n" +
				"push 0\n");		
	}

	@Override
	public void ecrireInt() {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireInt();
		
		Ecriture.ecrireStringln(out,"call ecrent\n");	
	}

	@Override
	public void ecrireBool() {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireBool();
		
		Ecriture.ecrireStringln(out,"call ecrbool\n");	
	}

	@Override
	public void ecrireString(String s) {
		Ecriture.ecrireChar(out, ';');
		yvm.ecrireString(s);
		
		Ecriture.ecrireStringln(out,".DATA\n" +
				"mess"+numString+" DB " + s.substring(0, s.length()-1) + "$\"\n" +
				".CODE\n" +
				"lea dx, mess"+numString+"\n" +
				"push dx\n" +
				"call ecrch\n");	
		numString++;
	}

	@Override
	public void alaligne() {
		Ecriture.ecrireChar(out, ';');
		yvm.alaligne();
		
		Ecriture.ecrireStringln(out,"call ligsuiv\n");		
	}

	@Override
	public void lire(int offset) { // lireEnt
		Ecriture.ecrireChar(out, ';');
		yvm.lire(offset);
		
		String signe = "";
		if (offset >= 0) signe = "+";
		Ecriture.ecrireStringln(out,"lea dx, [bp"+signe+offset+"]\n" +
				"push dx\n" +
				"call lirent\n");			
	}

	@Override
	public void ouvrePrinc(int i) {
		Ecriture.ecrireChar(out, ';');
		yvm.ouvrePrinc(i);
		
		Ecriture.ecrireStringln(out,"mov bp, sp\n" +
				"sub sp, " + i + "\n");	
	}

}
