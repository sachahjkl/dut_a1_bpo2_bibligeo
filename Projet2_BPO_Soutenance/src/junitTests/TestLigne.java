package junitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import element.Direction;
import element.ElementCoordonné;
import element.Ligne;

public class TestLigne {

	@Test
	public void testseDessiner() {
		char[][] img = new char[10][10];
		Ligne l = new Ligne(5, 5,"ligne",Direction.Est);
		l.seDessiner(img);
		assertEquals(img[5][5], 'l');
		assertEquals(img[5][6], 'i');
		assertEquals(img[5][7], 'g');
		assertEquals(img[5][8], 'n');
		assertEquals(img[5][9], 'e');
	}
	
	@Test
	public void testclone() {
		Ligne l = new Ligne(5, 5,"ligne",Direction.Est);
		ElementCoordonné clone = l.clone();
		assertEquals(l.getX(), clone.getX());
		assertEquals(l.getX(), clone.getY());
	}
	@Test
	public void testencadrer() {
		Ligne l = new Ligne(5, 5,"ligne",Direction.Est);
		Character sans_encadrement = new Character(' ');
		Character encadrement = new Character('X');
		l.encadrer('X');
		assertEquals(l.estEncadré(), true);
		assertEquals(l.getEncadrement(), encadrement);
		l.désencadrer();
		assertEquals(l.estEncadré(), false);
		assertEquals(l.getEncadrement(), sans_encadrement);
	}
	@Test
	public void testTourner() {
		Ligne l = new Ligne(5, 5,"ligne",Direction.Est);
		final int NB_DIRECTION = 8;
		for (int i = 0; i < NB_DIRECTION; i++) {
			assertEquals(l.getD(), Direction.values()[i]);
			l.tournerAntiHoraire();
		}
		for (int i = NB_DIRECTION - 1; i > 0 ; i--) {
			l.tournerHoraire();
			assertEquals(l.getD(), Direction.values()[i]);
		}
	}

	
	@Test
	public void testgetCoordExtreme() {
		Ligne l = new Ligne(5, 5,"ligne",Direction.Est);
		int tab[] = {5, 5, 10, 4};
		int tabEncadré[] = {4, 6, 11, 3};
		for (int i = 0; i < tab.length; i++) {
			assertEquals(l.getCoordExtreme()[i], tab[i]);
			assertFalse(l.getCoordExtreme()[i] == tabEncadré[i]);
			l.encadrer('X');
			assertFalse(l.getCoordExtreme()[i] == tab[i]);
			assertEquals(l.getCoordExtreme()[i], tabEncadré[i]);
			l.désencadrer();
			assertEquals(l.getCoordExtreme()[i], tab[i]);
			assertFalse(l.getCoordExtreme()[i] == tabEncadré[i]);
		}

	}


}
