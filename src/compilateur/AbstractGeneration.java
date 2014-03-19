package compilateur;

import java.io.OutputStream;

public abstract class AbstractGeneration implements Generation {

	protected OutputStream out;
	
	protected AbstractGeneration()
	{
		out = System.out;
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
	public void closeFile() {
		Ecriture.fermer(out);
	}

}
