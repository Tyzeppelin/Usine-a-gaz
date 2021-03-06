package tests;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;

import compilateur.IdConst;
import compilateur.IdVar;
import compilateur.Ident;
import compilateur.Type;

import exceptions.IdentDoesNotExistException;
import exceptions.TypeErrException;

public class ExpressionTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		Yaka.expr.clear();
		Yaka.tabIdent.clearLocaux();
	}

	@Test
	public void testGetTypeExpr() {
		Yaka.expr.ajouterType(Type.ENT);
		Type type = null;
		try {
			type = Yaka.expr.getTypeExpr();
		} catch (TypeErrException e) {
			assertTrue(false);
		}
		
		assertEquals(Type.ENT, type);
	}

	@Test
	public void testAjouterIdentString() {
		try {
			Yaka.expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		Yaka.tabIdent.rangeIdentLocal(new IdConst("test"));
		
		try {
			Yaka.expr.ajouterIdent("test");
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
	}

	@Test
	public void testAjouterIdentIdent() {
		Ident id = new IdVar("test",Type.ENT);
		try {
			Yaka.expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(true);
		}
		
		Yaka.tabIdent.rangeIdentLocal(id);
		
		try {
			Yaka.expr.ajouterIdent(id);
		} catch (IdentDoesNotExistException e) {
			assertTrue(false);
		}
		
	}
}
