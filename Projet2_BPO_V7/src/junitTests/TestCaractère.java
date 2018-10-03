package junitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import element.Caractère;
import element.ElementCoordonné;

public class TestCaractère {

	@Test
	public void testseDessiner() {
		char[][] img = new char[10][10];
		Caractère c = new Caractère('a', 5, 5);
		c.seDessiner(img);
		assertEquals(img[5][5], 'a');
	}
	
	@Test
	public void testclone() {
		Caractère c = new Caractère('a', 5, 5);
		ElementCoordonné clone = c.clone();
		assertEquals(c.getX(), clone.getX());
		assertEquals(c.getX(), clone.getY());
	}
	@Test
	public void testencadrer() {
		Caractère c = new Caractère('a', 5, 5);
		Character sans_encadrement = new Character(' ');
		Character encadrement = new Character('X');
		c.encadrer('X');
		assertEquals(c.estEncadré(), true);
		assertEquals(c.getEncadrement(), encadrement);
		c.désencadrer();
		assertEquals(c.estEncadré(), false);
		assertEquals(c.getEncadrement(), sans_encadrement);
	}
	
	@Test
	public void testgetCoordExtreme() {
		Caractère c = new Caractère('a', 5, 5);
		int tab[] = {5, 5, 5, 5};
		int tabEncadré[] = {4, 6, 6, 4};
		for (int i = 0; i < tab.length; i++) {
			assertEquals(c.getCoordExtreme()[i], tab[i]);
			assertFalse(c.getCoordExtreme()[i] == tabEncadré[i]);
			c.encadrer('X');
			assertFalse(c.getCoordExtreme()[i] == tab[i]);
			assertEquals(c.getCoordExtreme()[i], tabEncadré[i]);
			c.désencadrer();
			assertEquals(c.getCoordExtreme()[i], tab[i]);
			assertFalse(c.getCoordExtreme()[i] == tabEncadré[i]);
		}

	}


}
