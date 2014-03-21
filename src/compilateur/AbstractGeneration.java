package compilateur;

import java.io.OutputStream;
import java.util.Stack;

public abstract class AbstractGeneration implements Generation {

	protected OutputStream out;
	
	protected Stack<Integer> stackTantQue; 
	protected Stack<Integer> stackCond; 
	
	protected AbstractGeneration()
	{
		out = System.out;
		stackTantQue = new Stack<Integer>();
		stackTantQue.push(0);
		stackCond = new Stack<Integer>();
		stackCond.push(0);
	}
	protected AbstractGeneration(String nameFile)
	{
		out = Ecriture.ouvrir(nameFile);
		stackTantQue = new Stack<Integer>();
		stackTantQue.push(0);
		stackCond = new Stack<Integer>();
		stackCond.push(0);
	}

	public void sinon()
	{
		jumpCond();
		Ecriture.ecrireString(out, "SINON"+stackCond.peek()+":\n");		
	}
	public void fsi()
	{
		Ecriture.ecrireString(out, "FSI"+stackCond.pop()+":\n");
	}
	public void si()
	{
		stackCond.push(1);		
	}

	public void faire()
	{
		stackTantQue.push(stackTantQue.peek()+1);
		Ecriture.ecrireString(out, "FAIRE"+stackTantQue.peek()+":\n");
	}
	
	public void fait()
	{
		jumpIter();
		Ecriture.ecrireString(out, "FAIT"+stackTantQue.pop()+":\n");		
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
	public void closeFile() {
		Ecriture.fermer(out);
	}

}
