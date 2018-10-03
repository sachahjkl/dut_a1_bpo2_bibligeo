package appli;

import image.*;

import java.io.IOException;

import element.*;
import exception.InvalidResolutionException;
import film.Film;

public class Appli {
	public static final int resX = 100;
	public static final int resY = 40;

	public static void main(String[] args) {
		Texte t30 = new Texte(1, 2);
		t30.encadrer('0');
		t30.ajouterligneTxt("```````````````````````````````o//-```````````````````````````````````\r\n"
				+ "```````````````````````````````s::.```````````````````````````````````\r\n"
				+ "``````````````````````````````.h//.```````````````````````````````````\r\n"
				+ "``````````````````````````````-h//-```````````````````````````````````\r\n"
				+ "``````````````````````````````/ho/:.``````````````````````````````````\r\n"
				+ "`````````````````````````````.oys+/-``````````````````````````````````\r\n"
				+ "``........``````````````````.+oyoo+:.`````````````......``````````````\r\n"
				+ "`.................`````````.+ooy+oo/:.................................\r\n"
				+ "........................``-+oo+yoooo+:-...............................\r\n"
				+ "........................./+ooooyoo+ooo+:..............................\r\n"
				+ "......................:+ooo++oos++ooo+oo+:............................\r\n"
				+ ".................-:/+oooo+oooo+yooo++oooooo+/-........................\r\n"
				+ "..........:/+oooyssssossossosooyoosoossossosssssoo+///--..............\r\n"
				+ "..........-////+++ooo+ooooo++oos++oooo++oooo++++////////-.............\r\n"
				+ "...............--:://++oo++ooo+hoo++oooo++/////::---..................\r\n"
				+ ".....................-:/+ooo+o+yoooooo+////:-.........................\r\n"
				+ "........................-:/ooooy+o+o+///:-............................\r\n"
				+ "..........................-:oo+hooo/++/-..............................\r\n"
				+ "............................:ooy+o/++/-...............................\r\n"
				+ ".............................:syo++/:-................................\r\n"
				+ "..............................+ho++:-.................................\r\n"
				+ "..........--------------------:y++/-.....................-----------..\r\n"
				+ "....---------------------------y++/-----------------------------------\r\n"
				+ ".------------------------------y++/-----------------------------------\r\n"
				+ "-------------------------------+++:-----------------------------------\r\n"
				+ "--------------------------------//:-----------------------------------");
		// t30.ajouterligneTxt("Ceci est un test1");
		// t30.ajouterligneTxt("Ceci est un test2 mais plus long");
		// t30.ajouterligneTxt("Ceci est test3 ");
		Image i40 = new Image(resX, resY);
		ExtraitDeTexte et40 = new ExtraitDeTexte(t30, -2, 50, 28, 0, 150, 20);
		ExtraitDeTexte et41 = new ExtraitDeTexte(t30, 20, 40, 28, 0, 150, 20);
		ExtraitDeTexte et42 = new ExtraitDeTexte(t30, 10, 15, 0, 10, 200, 30);
		Caractère ca = new Caractère('a', 1, 43);
		Caractère cb = new Caractère('b', 5, 43);
		Caractère cc = new Caractère('c', 1, 48);
		Caractère cd = new Caractère('d', 5, 48);
		GroupeElement ge = new GroupeElement(3, 20);
		ge.ajouterElements(new InterfaceElement[] { ca, cb, cc, cd });
		ge.déplacer(3, 18);
		ge.encadrerElements('1');
		ge.encadrer('0');
		ge.ajouterElement(et42);
		et40.encadrer('X');
		et41.encadrer('X');
		et42.encadrer('X');
		i40.ajouterElement(t30);
		Image i41 = new Image(i40);
		Image i42 = new Image(i40);
		i40.ajouterElement(et40);
		i41.ajouterElement(et41);
		i41.ajouterElement(ge);
		GroupeElement ge2 = new GroupeElement(9, 3);
		ge2.ajouterElements(new InterfaceElement[] { ca.clone(), cb.clone(), cc.clone(), cd.clone() });
		ge2.déplacer(20, 4);
		ge2.encadrerElements('O');
		ge2.encadrer('4');
		ge2.ajouterElement(et42);
		i42.ajouterElement(et42);
		i42.ajouterElement(ge2);
		i42.ajouterElement(ge);
		System.out.println(i40);
		Film f4 = new Film(resX, resY);
		try {
			f4.ajouterImage(i40);
			f4.ajouterImage(i41);
			f4.ajouterImage(i42);
			f4.génererFilm("FicTest4.txt");
		} catch (InvalidResolutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image i30 = new Image(resX, resY);
		i30.ajouterElement(t30);
		i30.ajouterElement(new Caractère('a', 4, 0));
		Film f3 = new Film(resX, resY);
		try {
			f3.ajouterImage(i30);
			f3.génererFilm("FicTest3.txt");
		} catch (InvalidResolutionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image i0 = new Image(resX, resY);
		Image i1 = new Image(i0);
		i1.ajouterElement(new Caractère('a', 0, 0));
		Image i2 = new Image(i1);
		i2.ajouterElement(new Caractère('b', 4, 0));
		Image i3 = new Image(i2);
		i3.ajouterElement(new Caractère('c', 0, 4));
		Image i4 = new Image(i3);
		Caractère ct = new Caractère('d', 4, 4);
		ct.encadrer('0');
		i4.ajouterElement(ct);
		Image i5 = new Image(i4);
		Caractère c = new Caractère('o', 2, 2);
		// c.encadrer('t');
		i5.ajouterElement(c);
		Film f = new Film(resX, resY);

		System.out.println(i5);
		try {
			f.ajouterImage(i0);
			f.ajouterImage(i1);
			f.ajouterImage(i2);
			f.ajouterImage(i3);
			f.ajouterImage(i4);
			f.ajouterImage(i5);
		} catch (InvalidResolutionException e2) {
			e2.printStackTrace();
		}

		try {
			f.génererFilm("FicTest1.txt");
		} catch (IOException e) {
			System.out.println("t'as tout pêté pc.");
		}

		Image i10 = new Image(resX, resY);
		Image i11 = new Image(i10);
		Ligne l11 = new Ligne(5, 5, 4, 'l', Direction.SudEst);
		l11.encadrer('0');
		i11.ajouterElement(l11);
		Image i12 = new Image(i10);
		Ligne l12 = new Ligne(5, 5, 4, 'l', Direction.Sud);
		l12.encadrer('0');
		i12.ajouterElement(l12);
		Image i13 = new Image(i10);
		Ligne l13 = new Ligne(5, 5, 4, 'l', Direction.SudOuest);
		l13.encadrer('0');
		i13.ajouterElement(l13);
		Image i14 = new Image(i10);
		Ligne l14 = new Ligne(5, 5, 4, 'l', Direction.Ouest);
		l14.encadrer('0');
		i14.ajouterElement(l14);
		Image i15 = new Image(i10);
		Ligne l15 = new Ligne(5, 5, 4, 'l', Direction.NordOuest);
		l15.encadrer('0');
		i15.ajouterElement(l15);
		Image i16 = new Image(i10);
		Ligne l16 = new Ligne(5, 5, 4, 'l', Direction.Nord);
		l16.encadrer('0');
		i16.ajouterElement(l16);
		Image i17 = new Image(i10);
		Ligne l17 = new Ligne(5, 5, 4, 'l', Direction.NordEst);
		l17.encadrer('0');
		i17.ajouterElement(l17);
		Image i18 = new Image(i10);
		Ligne l18 = new Ligne(5, 5, 4, 'l', Direction.Est);
		l18.encadrer('0');
		i18.ajouterElement(l18);
		System.out.println(i18);
		Film f1 = new Film(resX, resY);
		;
		try {
			f1.ajouterImage(i11);
			f1.ajouterImage(i12);
			f1.ajouterImage(i13);
			f1.ajouterImage(i14);
			f1.ajouterImage(i15);
			f1.ajouterImage(i16);
			f1.ajouterImage(i17);
			f1.ajouterImage(i18);
		} catch (InvalidResolutionException e1) {
			e1.printStackTrace();
		}

		try {
			f1.génererFilm("FicTest2.txt");
		} catch (IOException e) {
			System.out.println("t'as tout pêté pc.");
		}
	}
}
