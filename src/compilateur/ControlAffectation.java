package compilateur;

import yaka.Yaka;
import exceptions.IdentAffectationException;
import exceptions.IdentDoesNotExistException;
import exceptions.TypeErrException;
import exceptions.TypeExpectedNotCorrectException;

public class ControlAffectation {

	public static void controlIdent(String ident) throws IdentDoesNotExistException, IdentAffectationException {
		if (!Yaka.tabIdent.existeIdentLocal(ident) && !Yaka.tabIdent.existeIdentGlobal(ident)) {
			throw new IdentDoesNotExistException(ident);
		} else {
			Ident id = Yaka.tabIdent.chercheIdent(ident);
			if (!id.canBeAffected()) {
				throw new IdentAffectationException(id.getNom());
			}
		}
	}
	
	public static void controlExpression(String ident) throws TypeErrException, IdentDoesNotExistException, TypeExpectedNotCorrectException
	{		
		Type typeGiven = Yaka.expr.getTypeExpr();
		Type typeExpected = Yaka.tabIdent.chercheIdentLocal(ident).getType();
		if (typeGiven != typeExpected)
		{
			throw new TypeExpectedNotCorrectException(typeGiven,typeExpected);
		}
	}
}
