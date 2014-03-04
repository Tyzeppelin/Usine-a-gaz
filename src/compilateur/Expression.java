package compilateur;

import java.util.Stack;

import exceptions.IdentDoesNotExistException;

public class Expression {
	
	protected Type[][] typesOperateurs = {
		//   entier 	booleen
		{Type.ENT, Type.ERR, Type.ERR},	// +,-,*,/
		{Type.BOOL, Type.ERR, Type.ERR},	// <,>,<=,>=
		{Type.BOOL, Type.BOOL, Type.ERR},	// =, !=
		{Type.ERR, Type.BOOL, Type.ERR}	// et, ou
	};
		

	public Stack<Type> stackType;	// pile du type des op�randes lues
	protected Stack<Operateur> stackOp;	// pile des op�rateurs lus
	
	// Table des identifiants
	protected TabIdent tabIdent;
	
	public Expression(TabIdent tab) {
		stackType = new Stack<Type>();
		stackOp = new Stack<Operateur>();
		tabIdent = tab;
	}
	
	
	public void ajouterOp (Operateur op) {
		stackOp.push(op);
	}
	
	public void ajouterType(Type type) {
		stackType.push(type);
	}
	
	public void ajouterIdent(String nom) throws IdentDoesNotExistException {
		if (tabIdent.existeIdent(nom))
		{
			Ident ident = tabIdent.chercheIdent(nom);
			stackType.push(ident.getType());
		}
		else
		{
			stackType.push(Type.ERR);
			throw new IdentDoesNotExistException(nom);
		}
	}
	
	public void verifType() {
		Operateur op = stackOp.pop();
		Type t1 = stackType.pop();
		Type t2;
		
		switch (op) {
		case NEG:
			if (t1 == Type.ENT)
				stackType.push(Type.ENT);
			else
				stackType.push(Type.ERR);
			break;
			
		case NOT:
			if (t1 == Type.BOOL)
				stackType.push(Type.BOOL);
			else
				stackType.push(Type.ERR);
			break;
		case ADD:
		case MUL:
		case SUB:
		case DIV:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[0][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case INF:
		case INFE:
		case SUP:
		case SUPE:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[1][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case EQU:
		case DIFF:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[2][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		case AND:
		case OR:
			t2 = stackType.pop();
			if (t1==t2)
			{
				stackType.push(typesOperateurs[3][t1.ordinal()]);
			}
			else
			{
				stackType.push(Type.ERR);
			}
			break;
		default:
				
		}
	}
	
	public void clear()
	{
		stackType.clear();
		stackOp.clear();
	}
	
}
