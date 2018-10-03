package appli;

import image.*;


import element.*;

public class Appli {
	public static final int resX = 50;
	public static final int resY = 20;

	public static void main(String[] args) {
		Image i0 = new Image(resX, resY);
		Ligne l0 = new Ligne(10, 13, "abcdefg", Direction.SudOuest);
		l0.encadrer('o');
		Texte t0 = new Texte(9, 10);
		t0.ajouterligneTxt("ligne 1 de test\r\n" + 
							"2 test abcdefgijklmnopkrstuvwxyz\r\n" + 
							"3 test bien bien bien long\r\n" + 
							"dernière ligne");
		t0.encadrer('x');
		ExtraitDeTexte et0 = new ExtraitDeTexte(t0, 8, 13,3, 0,10, 3);
		GroupeElement ge0 = new GroupeElement();
		ge0.ajouterElements(new Element[] {t0,l0,et0});
		et0.encadrer('0');
		ge0.encadrer('O');
		//i0.ajouterElement(l0);
		//i0.ajouterElement(t0);
		//i0.ajouterElement(et0);
		i0.ajouterElement(ge0);
		System.out.println(i0);

	}
}