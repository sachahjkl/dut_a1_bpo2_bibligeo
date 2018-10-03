package appli;

import image.*;

import java.io.IOException;

import element.*;
import exception.InvalidResolutionException;
import film.Film;

public class Appli {
	public static final int resX = 170;
	public static final int resY = 50;

	public static void main(String[] args) {
		Texte t30 = new Texte(1,2);
		t30.encadrer('0');
		t30.ajouterligneTxt("````````````````````````````````````````````/o//:.``````````````````````````````````````````````````");
		t30.ajouterligneTxt("````````````````````````````````````````````:+//:.``````````````````````````````````````````````````");
		t30.ajouterligneTxt("````````````````````````````````````````````oo//:.``````````````````````````````````````````````````");
		t30.ajouterligneTxt("````````````````````````````````````````````ss//:.``````````````````````````````````````````````````");
		t30.ajouterligneTxt("````````````````````````````````````````````sh//:.``````````````````````````````````````````````````");
		t30.ajouterligneTxt("```````````````````````````````````````````.yy///-``````````````````````````````````````````````````");
		t30.ajouterligneTxt("```````````````````````````````````````````/yyo//:.`````````````````````````````````````````````````");
		t30.ajouterligneTxt("``````````````````````````````````````````.osys//:-.````````````````````````````````````````````````");
		t30.ajouterligneTxt("``````````````````````````````````````````/osyoo//:.````````````````````````````````````````````````");
		t30.ajouterligneTxt("```...........```````````````````````````-oosso++//-.``````````````````.........````````````````````");
		t30.ajouterligneTxt("`......................`````````````````-oooss+soo/:-.```..........................................`");
		t30.ajouterligneTxt("`..........................````````````:o+oosy+ooso/:-..............................................");
		t30.ajouterligneTxt("...................................``./oooo+oyooooo++/-.........");
		t30.ajouterligneTxt("....................................:+ooooo+syoo+++ooo/:-...........................................");
		t30.ajouterligneTxt("..................................:+o++oooooss++oo+oooo+/:-.........................................");
		t30.ajouterligneTxt("...............................-/+osooo++oooss++ooooo+oooo+:-.......................................");
		t30.ajouterligneTxt("...........................-:/+o++oooooooo++syooooooo++osooo+/:-......");
		t30.ajouterligneTxt("...................----:/++ooooooo+++soooo++oyooo++++ooooo+++oooo+/:---.............................");
		t30.ajouterligneTxt("...............ooosyssshysssysssysssyyssyyssyyssshsssyyssshsssyyssyhs");
		t30.ajouterligneTxt("...............-///++++++ooooo+++ooooo+++sooss+++soooo+++ooooooo+++.");
		t30.ajouterligneTxt("................-::::::////++++oooo+++ooosoosy+ooo++ooooo+ooo++");
		t30.ajouterligneTxt("........................--:::///+ooo++oooo++syooo+++ooooo+////////::---.............................");
		t30.ajouterligneTxt("..............................-:://+oooooo++syoooooo+oo+//////:--...................................");
		t30.ajouterligneTxt(".................................-::/ooo++soyy++soooo//////:--......................................");
		t30.ajouterligneTxt("....................................-:++sososs+oo+o+/////:-.........................................");
		t30.ajouterligneTxt(".....................................-:/ooo+yyoo+o//++//--..........................................");
		t30.ajouterligneTxt(".......................................-/oo+oyoso//++/:-............................................");
		t30.ajouterligneTxt("........................................-/+ssy+s+/++/:-.............................................");
		t30.ajouterligneTxt(".........................................-/ssso++++/:-..............................................");
		t30.ajouterligneTxt("..........................................-osso/++/:-...............................................");
		t30.ajouterligneTxt(".........................................../yh+++/:-...................................-------......");
		t30.ajouterligneTxt("..............------------------------------yy+++/:-.............................----------------...");
		t30.ajouterligneTxt("......--------------------------------------yy/++/:-------------------------------------------------");
		t30.ajouterligneTxt("...-----------------------------------------os+++/--------------------------------------------------");
		t30.ajouterligneTxt(".-------------------------------------------os+++:--------------------------------------------------");
		t30.ajouterligneTxt("--------------------------------------------/+++/:--------------------------------------------------");
		t30.ajouterligneTxt("---------------------------------------------/++/:--------------------------------------------------");
		t30.ajouterligneTxt("---------------------------------------------://:---------------------------------------------------");
		//t30.ajouterligneTxt("Ceci est un test1");
		//t30.ajouterligneTxt("Ceci est un test2 mais plus long");
		//t30.ajouterligneTxt("Ceci est test3 ");
		Image i40 = new Image(resX, resY);
		ExtraitDeTexte et40 = new ExtraitDeTexte(t30, 50, 10, 28, 10, 20, 30);
		ExtraitDeTexte et41 = new ExtraitDeTexte(t30, 20, 15, 28, 10, 20, 30);
		ExtraitDeTexte et42 = new ExtraitDeTexte(t30, 10, -10, 28, 10, 20, 30);
		Caractère ca = new Caractère('a',1,40);
		Caractère cb = new Caractère('b',5,40);
		Caractère cc = new Caractère('c',1,45);
		Caractère cd = new Caractère('d',5,45);
		GroupeElement ge = new GroupeElement();
		ge.ajouterElements(new Element[]{ca,cb,cc,cd});
		ge.encadrer('0');
		et40.encadrer('X');
		et41.encadrer('X');
		et42.encadrer('X');
		i40.ajouterElement(t30);
		Image i41 = new Image(i40);
		Image i42 = new Image(i40);
		i40.ajouterElement(et40);
		i41.ajouterElement(et41);
		i41.ajouterElement(ge);
		GroupeElement ge2 = new GroupeElement();
		ge2.ajouterElements(new Element[] {ca.clone(),cb.clone(),cc.clone(),cd.clone()});
		ge2.déplacerElements(10, -10);
		ge2.encadrer('1');
		i42.ajouterElement(et42);
		i42.ajouterElement(ge2);
		System.out.println(i42);
		Film f4 = new Film(resX,resY);
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
		
		/*Image i30 = new Image(resX, resY);
		Texte t30 = new Texte(1,2);
		t30.encadrer('0');
		t30.ajouterligneTxt("Ceci est un test1");
		t30.ajouterligneTxt("Ceci est un test2 mais plus long");
		t30.ajouterligneTxt("Ceci est test3 ");
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
		//c.encadrer('t');
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
		Film f1 = new Film(resX, resY);;
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
		}*/
	}
}
