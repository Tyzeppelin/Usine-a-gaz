package tests;

import org.junit.Before;
import org.junit.Test;

import compilateur.IdVar;
import compilateur.Ident;
import compilateur.TabIdent;
import compilateur.Type;

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
		assertEquals(null, tabIdent.chercheIdent("test"));
		tabIdent.rangeIdent("test", new IdVar("test", Type.ENT));
		assertEquals(new IdVar("test", Type.ENT), tabIdent.chercheIdent("test"));		
		assertEquals(null, tabIdent.chercheIdent(null));		
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
