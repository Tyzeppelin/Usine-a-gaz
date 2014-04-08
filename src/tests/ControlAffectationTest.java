package tests;


import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;

import compilateur.ControlAffectation;
import compilateur.Type;
import exceptions.IdentAffectationException;
import exceptions.IdentAlreadyDeclaredException;
import exceptions.IdentDoesNotExistException;
import exceptions.TypeErrException;
import exceptions.TypeExpectedNotCorrectException;

import junit.framework.TestCase;

public class ControlAffectationTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Yaka.tabIdent.clear();
		Yaka.expr.clear();
	}

	@Test
	public void testControlIdent() {
		try {
			ControlAffectation.controlIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		} catch (IdentAffectationException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			ControlAffectation.controlIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		} catch (IdentAffectationException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.decl.addConst("testConst", Type.ENT, 0);
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			ControlAffectation.controlIdent("testConst");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		} catch (IdentAffectationException e) {
			assertTrue(true);
		}
		
	}

	@Test
	public void testControlExpression() {
		try {
			Yaka.decl.addVar("test", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		try {
			Yaka.decl.addVar("test2", Type.typeToInt(Type.ENT));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}
		
		try {
			Yaka.expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		
		try {
			ControlAffectation.controlExpression("test2");
		} catch (TypeErrException e) {
			assertTrue(false);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		} catch (TypeExpectedNotCorrectException e) {
			assertTrue(false);
		}
		

		try {
			Yaka.decl.addVar("test3", Type.typeToInt(Type.BOOL));
		} catch (IdentAlreadyDeclaredException e) {
			assertTrue(false);
		}

		try {
			Yaka.expr.ajouterIdent("test3");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		

		
		try {
			ControlAffectation.controlExpression("test2");
		} catch (TypeErrException e) {
			assertTrue(false);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		} catch (TypeExpectedNotCorrectException e) {
			assertTrue(true);
		}
		
		
		
	}

}
