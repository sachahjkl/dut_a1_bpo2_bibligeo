package appli;

import image.*;

import java.io.IOException;

import element.*;
import exception.InvalidResolutionException;
import film.Film;

public class Appli {
	public static final int resX = 10;
	public static final int resY = 10;

	public static void main(String[] args) {
		
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
		 */
		Image i10 = new Image(resX, resY);
		Image i11 = new Image(i10);
		Ligne l11 = new Ligne(5, 5, 4, 'l', Direction.SudEst);
		
		i11.ajouterElement(l11);
		Image i12 = new Image(i10);
		Ligne l12 = new Ligne(5, 5, 4, 'l', Direction.Sud);
		i12.ajouterElement(l12);
		Image i13 = new Image(i10);
		Ligne l13 = new Ligne(5, 5, 4, 'l', Direction.SudOuest);
		i13.ajouterElement(l13);
		Image i14 = new Image(i10);
		Ligne l14 = new Ligne(5, 5, 4, 'l', Direction.Ouest);
		i14.ajouterElement(l14);
		Image i15 = new Image(i10);
		Ligne l15 = new Ligne(5, 5, 4, 'l', Direction.NordOuest);
		i15.ajouterElement(l15);
		Image i16 = new Image(i10);
		Ligne l16 = new Ligne(5, 5, 4, 'l', Direction.Nord);
		i16.ajouterElement(l16);
		Image i17 = new Image(i10);
		Ligne l17 = new Ligne(5, 5, 4, 'l', Direction.NordEst);
		i17.ajouterElement(l17);
		Image i18 = new Image(i10);
		Ligne l18 = new Ligne(5, 5, 4, 'l', Direction.Est);
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
		}
	}
}
