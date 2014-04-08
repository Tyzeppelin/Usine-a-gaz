package compilateur;

import yaka.Yaka;

public class JAVAGen extends AbstractGeneration {

	public String name;
	
	public JAVAGen(String nameFile)
	{
		super(nameFile+".java");
		name=nameFile;
	}
	
	@Override
	public void header() {
		progString.append("import java.util.*;\n\n" +
				"public class "+name+" {\n\n" +
				"private static Stack<Integer> stack = new Stack<Integer>();\n" +
				"private static int bp = 0;\n" +
				"private static int saveBp = bp;\n" +
				"\n\n private static boolean intToBool(int i) {return i==-1 ? true : false;}\n" +
				"private static int boolToInt(boolean i) {return i ? -1 : 0;}\n\n");
	}

	@Override
	public void footer() {
		progString.append("}\n}\n");

	}

	@Override
	public void iconst(int val) {
		progString.append("// iconst \n");
		progString.append("stack.push("+val+");\n");
	}

	@Override
	public void idiv() {
		progString.append("{\n\tint tmp = stack.pop();\n" +
				"stack.push(stack.pop()/tmp);\n" +
				"}\n");
	}

	@Override
	public void imul() {
		progString.append("stack.push(stack.pop()*stack.pop());\n");

	}

	@Override
	public void iadd() {
		progString.append("stack.push(stack.pop()+stack.pop());\n");
	}

	@Override
	public void isub() {
		progString.append("{\n\tint tmp = stack.pop();\n" +
				"stack.push(stack.pop()-tmp);\n" +
				"}\n");
	}

	@Override
	public void ineg() {
		progString.append("stack.push(stack.pop()*(-1));\n");
	}

	@Override
	public void inot() {
		progString.append("stack.push(boolToInt(!(intToBool(stack.pop()))));\n");
	}

	@Override
	public void ior() {
		progString.append("stack.push(boolToInt(stack.pop() || stack.pop()));\n");

	}

	@Override
	public void iand() {
		progString.append("stack.push(boolToInt(stack.pop() && stack.pop()));\n");
	}

	@Override
	public void iinf() {
		progString.append("{\n" +
				"int tmp = stack.pop();\n" +
				"stack.push(boolToInt(stack.pop() < tmp));\n" +
				"}\n");
	}

	@Override
	public void isup() {
		progString.append("{\n" +
				"int tmp = stack.pop();\n" +
				"stack.push(boolToInt(stack.pop() > tmp));\n" +
				"}\n");
	}

	@Override
	public void iinfegal() {

		progString.append("{\n" +
				"int tmp = stack.pop();\n" +
				"stack.push(boolToInt(stack.pop() <= tmp));\n" +
				"}\n");
	}

	@Override
	public void isupegal() {

		progString.append("{\n" +
				"int tmp = stack.pop();\n" +
				"stack.push(boolToInt(stack.pop() >= tmp));\n" +
				"}\n");
	}

	@Override
	public void iegal() {
		progString.append("stack.push(boolToInt(stack.pop() == stack.pop()));\n");
	}

	@Override
	public void idiff() {
		progString.append("stack.push(boolToInt(stack.pop() != stack.pop()));\n");
	}

	@Override
	public void ecrireInt() {
		progString.append("System.out.print(stack.pop());\n");
	}

	@Override
	public void ecrireBool() {
		progString.append("System.out.print(intToBool(stack.pop()));\n");
	}

	@Override
	public void ecrireString(String s) {
		progString.append("System.out.print("+s+");\n");

	}

	@Override
	public void alaligne() {
		progString.append("System.out.println();\n");

	}

	@Override
	public void iffauxIter() {
		progString.append("if (!intToBool(stack.peek())) {stack.pop();break;}\n");
	}

	@Override
	public void jumpIter() {
	}

	@Override
	public void iffauxCond() {
		progString.append("if (intToBool(stack.pop())) {\n");

	}

	@Override
	public void debut() {
		//progString.append("public static void main(String[] args) {\n");
	}


	@Override
	public void reserveRetour() {

	}

	
	public void sinon()
	{
		progString.append("}\n" +
				"else {\n");
	}
	
	public void fsi()
	{
		progString.append("\n}\n");
	}
	
	public void si()
	{
	}
	
	public void faire()
	{	

		progString.append("do {\n");
	}
	
	public void fait()
	{		
		progString.append("\n}while (intToBool(stack.pop()));\n");
	}

	@Override
	public void iconst(Ident ident) {
		progString.append("// iconst \n");
		progString.append("stack.push("+ident.getValeur()+");\n");
	}

	@Override
	public void istore(Ident ident) {
		progString.append("// istore \n");
		progString.append("{\n" +
				"int tmp = stack.pop();\n");

		int i = (ident.getValeur()/2)*(-1);
		String signe = "";
		if (ident.getValeur() < 0) signe = "+";
		progString.append("stack.set(bp"+signe+i+",tmp);\n" +
				"\n}\n");	
	}

	@Override
	public void iload(Ident ident) {
		progString.append("// iload \n");
		int i = (ident.getValeur()/2)*(-1);
		String signe = "";
		if (ident.getValeur() < 0) signe = "+";
		progString.append("stack.push(stack.elementAt(bp"+signe+i+"));\n");	
	}

	@Override
	public void lire(Ident ident) {

		int i = ((ident.getValeur()/2)*(-1));
		String signe = "";
		if (ident.getValeur() < 0) signe = "+";
		
		progString.append("{\n" +
				"Scanner sc = new Scanner(System.in);\n" +
				"int i = sc.nextInt();\n" +
				"stack.set(bp"+signe+i+",i);" +
				"}\n");
	}

	@Override
	public void ouvreBloc(IdFonc fonc) {
		String type;
		if (fonc.getType()==Type.ENT)
			type="int";
		else
			type="boolean";
		if (fonc.getNom().equals("main"))
		{
			progString.append("public static void "+fonc.getNom()+"(String[] args) {\nbp=-1;");	
		}
		else
			progString.append("public static "+type+" "+fonc.getNom()+"() {\n");
		
		for(int i=0;i<Yaka.tabIdent.nbVarDeclared();i++)
		{
			progString.append("stack.push(0);\n");			
		}
		
	}

	@Override
	public void fermeBloc(IdFonc fonc) {
		progString.append("}\n");		
	}

	@Override
	public void ireturn(IdFonc fonc) {
		progString.append("// ireturn \n");
		progString.append("int _tmpReturn__ = stack.pop();\n");
		for(int i=0;i<Yaka.tabIdent.nbVarDeclared();i++)
		{
			progString.append("stack.pop();");			
		}
		progString.append("bp=stack.pop();");			
		for(int i=0;i<fonc.getNbParam();i++)
		{
			progString.append("stack.pop();");			
		}
		if (fonc.getType()==Type.ENT)
			progString.append("return _tmpReturn__;\n");
		else
			progString.append("return intToBool(_tmpReturn__);\n");
		
	}

	@Override
	public void call(IdFonc fonc) {
		progString.append("stack.push(0);\nstack.push(bp);\n"+
							"bp=stack.size()-1;");
		if (fonc.getType()==Type.ENT)
			progString.append("stack.push("+fonc.getNom()+"());\n");	
		else
			progString.append("stack.push(boolToInt("+fonc.getNom()+"()));\n");
	}

	@Override
	public void jumpCond() {
		// TODO Auto-generated method stub
		
	}

}
