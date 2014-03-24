package tests;

import org.junit.Before;
import org.junit.Test;

import yaka.Yaka;

import compilateur.IdVar;
import compilateur.Ident;
import compilateur.TabIdent;
import compilateur.Type;
import exceptions.IdentDoesNotExistException;
import junit.framework.TestCase;

public class TabIdentTest extends TestCase {
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		Yaka.tabIdent.clearLocaux();
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
		
		Yaka.tabIdent.rangeIdentLocal("test", new IdVar("test", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test", Type.ENT), Yaka.tabIdent.chercheIdent("test"));
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
	public void testExisteIdent() {
		assertFalse(Yaka.tabIdent.existeIdentLocal("test"));
		Ident ident = new IdVar("test", Type.ENT);
		Yaka.tabIdent.rangeIdentLocal("test", ident);
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
	}

	@Test
	public void testRangeIdent() {
		assertFalse(Yaka.tabIdent.existeIdentLocal("test"));
		Ident ident = new IdVar("test", Type.ENT);
		Yaka.tabIdent.rangeIdentLocal("test", ident);
		assertTrue(Yaka.tabIdent.existeIdentLocal("test"));
		
		Yaka.tabIdent.rangeIdentLocal("test2", null);
		assertFalse(Yaka.tabIdent.existeIdentLocal("test2"));
	}

}
