package appli;

import image.*;

import java.io.IOException;
import element.*;
import film.Film;

public class Appli {
	public static final int resX = 5;
	public static final int resY = 5;
	
	
	public Appli() {
	}

	public static void main(String[] args) {
		Image i0 = new Image(resX, resY);
		Image i1 = new Image(i0);
		i1.ajouterElement(new Charactère('a', 0, 0));
		Image i2 = new Image(i1);
		i2.ajouterElement(new Charactère('b', 4, 0));
		Image i3 = new Image(i2);
		i3.ajouterElement(new Charactère('c', 0, 4));
		Image i4 = new Image(i3);
		i4.ajouterElement(new Charactère('d', 4, 4));
		Image i5 = new Image(i4);
		i5.ajouterElement(new Charactère('o', 2, 2));
		Film f = new Film(resX, resY);
		f.ajouterImage(i0);
		System.out.println(i5);
		f.ajouterImage(i1);
		f.ajouterImage(i2);
		f.ajouterImage(i3);
		f.ajouterImage(i4);
		f.ajouterImage(i5);
		try {
			f.génererFilm("FicTest.txt");
		} catch (IOException e) {
			System.out.println("t'as tout pêté pc.");;
		}
	}
}
