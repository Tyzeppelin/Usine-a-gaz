package tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;
import compilateur.IdFonc;
import compilateur.IdParam;
import compilateur.IdVar;
import compilateur.Ident;
import compilateur.Type;
import exceptions.IdentDoesNotExistException;

public class TabIdentTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		Yaka.tabIdent.clear();
	}
	
	@Test
	public void testNbVarDeclared()
	{
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test2", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test3", Type.ENT));
		
		assertEquals(3, Yaka.tabIdent.nbVarDeclared());
		
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test4", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test5", Type.ENT));
		assertEquals(5, Yaka.tabIdent.nbVarDeclared());
	}
	
	@Test
	public void testNbParamDeclared()
	{
		Yaka.tabIdent.rangeIdentLocal(new IdParam("test", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdParam("test2", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdParam("test3", Type.ENT));
		
		assertEquals(3, Yaka.tabIdent.nbParamDeclared());
		
		Yaka.tabIdent.rangeIdentLocal(new IdParam("test4", Type.ENT));
		Yaka.tabIdent.rangeIdentLocal(new IdParam("test5", Type.ENT));
		assertEquals(5, Yaka.tabIdent.nbParamDeclared());		
	}

	@Test
	public void testChercheIdent() {
		
		boolean thrown = false;
		
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		Yaka.tabIdent.rangeIdentGlobal(new IdVar("test", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test", Type.ENT), Yaka.tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}		
		assertFalse(thrown);
		

		Yaka.tabIdent.rangeIdentLocal(new IdVar("test2", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test2", Type.ENT), Yaka.tabIdent.chercheIdent("test2"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}		
		assertFalse(thrown);
		
		thrown = false;
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdent(null));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void testChercheIdentGlobal() {
		
		boolean thrown = false;
		
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdentGlobal("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		Yaka.tabIdent.rangeIdentGlobal(new IdVar("test", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test", Type.ENT), Yaka.tabIdent.chercheIdentGlobal("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}		
		assertFalse(thrown);
		
		thrown = false;
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdentGlobal(null));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void testChercheIdentLocal() {
		
		boolean thrown = false;
		
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdentLocal("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		Yaka.tabIdent.rangeIdentLocal(new IdVar("test", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test", Type.ENT), Yaka.tabIdent.chercheIdentLocal("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}		
		assertFalse(thrown);
		
		thrown = false;
		try {
			assertEquals(null, Yaka.tabIdent.chercheIdentLocal(null));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void testExisteIdentLocal() {
		assertFalse(Yaka.tabIdent.existeIdentLocal("test"));
		Ident ident = new IdVar("test", Type.ENT);
		Yaka.tabIdent.rangeIdentLocal(ident);
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
	}
	
	@Test
	public void testExisteIdentGlobal() {
		assertFalse(Yaka.tabIdent.existeIdentGlobal("test"));
		IdFonc ident = new IdFonc("test");
		Yaka.tabIdent.rangeIdentGlobal(ident);
		assertTrue(Yaka.tabIdent.existeIdentGlobal("test"));
	}

	@Test
	public void testRangeIdentLocal() {
		assertFalse(Yaka.tabIdent.existeIdentLocal("test"));
		Ident ident = new IdVar("test", Type.ENT);
		Yaka.tabIdent.rangeIdentLocal(ident);
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
		
		Yaka.tabIdent.rangeIdentLocal(null);
		assertFalse(Yaka.tabIdent.existeIdentLocal("test2"));
	}

	@Test
	public void testRangeIdentGlobal() {
		assertFalse(Yaka.tabIdent.existeIdentGlobal("test"));
		Ident ident = new IdVar("test", Type.ENT);
		Yaka.tabIdent.rangeIdentGlobal(ident);
		assertTrue(Yaka.tabIdent.existeIdentGlobal("test"));
		
		Yaka.tabIdent.rangeIdentGlobal(null);
		assertFalse(Yaka.tabIdent.existeIdentGlobal("test2"));
	}

}
