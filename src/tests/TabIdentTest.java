package tests;

import org.junit.Before;
import org.junit.Test;

import compilateur.IdVar;
import compilateur.Ident;
import compilateur.TabIdent;
import compilateur.Type;
import exceptions.IdentDoesNotExistException;
import junit.framework.TestCase;

public class TabIdentTest extends TestCase {
	
	TabIdent tabIdent;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		tabIdent = new TabIdent();
	}

	@Test
	public void testChercheIdent() {
		
		boolean thrown = false;
		
		try {
			assertEquals(null, tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		tabIdent.rangeIdent("test", new IdVar("test", Type.ENT));
		thrown = false;
		try {
			assertEquals(new IdVar("test", Type.ENT), tabIdent.chercheIdent("test"));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}		
		assertFalse(thrown);
		
		thrown = false;
		try {
			assertEquals(null, tabIdent.chercheIdent(null));
		} catch (IdentDoesNotExistException e) {
			thrown = true;
		}
		assertTrue(thrown);
	}

	@Test
	public void testExisteIdent() {
		assertFalse(tabIdent.existeIdent("test"));
		Ident ident = new IdVar("test", Type.ENT);
		tabIdent.rangeIdent("test", ident);
		assertTrue(tabIdent.existeIdent("test"));
	}

	@Test
	public void testRangeIdent() {
		assertFalse(tabIdent.existeIdent("test"));
		Ident ident = new IdVar("test", Type.ENT);
		tabIdent.rangeIdent("test", ident);
		assertTrue(tabIdent.existeIdent("test"));
		
		tabIdent.rangeIdent("test2", null);
		assertFalse(tabIdent.existeIdent("test2"));
	}

}
