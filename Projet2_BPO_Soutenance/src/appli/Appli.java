package appli;

import java.io.IOException;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import com.sun.xml.internal.bind.v2.model.core.ID;

import element.*;
import exception.InvalidResolutionException;
import image.*;
import film.*;

public class Appli {
	private static final int resX = 40, resY = 40;

	public static void main(String[] args) throws InvalidResolutionException, IOException {

		// Séquence 1
		Film f = new Film(resX, resY);
		int posYPaul = 20, posXPaul = 14;
		int posYAlix = 20, posXAlix = 22;
		Ligne lPaul = new Ligne(posXPaul, posYPaul, "Paul", Direction.Est);
		Ligne lAlix = new Ligne(posXAlix, posYAlix, "Alix", Direction.Est);
		int posYlTrait = 20, posXlTrait = 18;
		Ligne lTrait = new Ligne(posXlTrait, posYlTrait, "----", Direction.Est);
		lPaul.encadrer('+');
		lAlix.encadrer('+');
		Image i0 = new Image(resX, resY);
		i0.ajouterElements(new Element[] { lAlix, lPaul, lTrait });
		f.ajouterImage(i0);
		Ligne lpb = null, lpa = null, lpl = null;
		for (int i = 0; i < 4; ++i) {
			Image in = new Image(resX, resY);
			lpb = new Ligne(lPaul);
			lpb.setX(posXPaul - i - 1);
			lpa = new Ligne(lAlix);
			lpa.setX(posXAlix + i + 1);
			lpl = new Ligne(lTrait);
			StringBuilder sb = new StringBuilder(lpl.getLigne());
			for (int j = 0; j < i + 1; ++j)
				sb.append("--");
			lpl.setLigne(sb.toString());
			lpl.setX(posXlTrait - i - 1);
			in.ajouterElements(new Element[] { lpb, lpa, lpl });
			f.ajouterImage(in);
		}
		Ligne lpc = null, lac = null, llc;
		Image in = null;
		for (int i = 0; i < 3; ++i) {
			in = new Image(resX, resY);
			lpc = new Ligne(lpb);
			lpc.setX(lpb.getX() - i - 1);
			lac = new Ligne(lpa);
			lac.setX(lpa.getX() - i - 1);
			llc = new Ligne(lpl);
			llc.setX(lpl.getX() - i - 1);
			in.ajouterElements(new Element[] { lpc, lac, llc });
			f.ajouterImage(in);
		}
		Image i8 = new Image(in);
		i8.retirerElement(lpc);
		Ligne lpcSaut = new Ligne(lpc);
		lpcSaut.setY(lpc.getY() + 1);
		i8.ajouterElement(lpcSaut);
		i8.changerOrdre(lpc, 0);
		for (int i = 0; i < 3; ++i) {
			f.ajouterImage(i8);
			f.ajouterImage(in);
		}
		Image iFin = new Image(in);
		iFin.retirerElement(lac);
		f.ajouterImage(iFin);

		// Séquence 2
		Texte jg = new Texte(0, 34);
		jg.ajouterligneTxt("j'ai gagné");
		jg.ajouterligneTxt("je suis le plus fort");
		Image iSeq2 = new Image(iFin);
		iSeq2.ajouterElement(jg);
		Texte jTemp = new Texte(jg);
		Image iTemp = null;
		while (jTemp.getY() != lpc.getY()) {
			jTemp.setY(jTemp.getY() - 1);
			iTemp = new Image(iFin);
			iTemp.ajouterElement(jTemp);
			iTemp.changerOrdre(jTemp, 0);
			f.ajouterImage(iTemp);
			jTemp = new Texte(jTemp);
		}
		Image iFinSeq2 = new Image(iFin);
		jTemp.encadrer('=');
		iFinSeq2.ajouterElement(jTemp);
		System.out.println(iFinSeq2);
		f.ajouterImage(iFinSeq2);
		// Séquence 3
		Image iDebutSeq3 = new Image(resX, resY);
		Caractère c1 = new Caractère('o', 10, 10);
		Caractère c2 = new Caractère('o', 10, 30);
		Caractère c3 = new Caractère('o', 30, 30);
		Caractère c4 = new Caractère('o', 30, 10);
		Ligne lH4 = new Ligne(20, 20, "4444", Direction.Est);
		Ligne lH8 = new Ligne(20, 20, "88888888", Direction.Est);
		Image iseq31 = new Image(resX, resY);
		iseq31.ajouterElements(new Element[] { c1, c2, c3, c4, lH4, lH8 });
		GroupeElement ge1 = new GroupeElement(0, 0);
		Image iseq32 = new Image(iDebutSeq3);
		ge1.ajouterElements(new Element[] { c1, c2, c3, c4, lH8, lH4 });
		ge1.encadrer('X');
		iseq32.ajouterElement(ge1);
		System.out.println(iseq31);
		System.out.println(iseq32);
		Image iTemp2 = null;
		Ligne temp8 = new Ligne(lH8);
		GroupeElement geTemp = new GroupeElement();
		for (int i = 0; i < 5; ++i) {
			temp8.setDirection(temp8.getD().précédent());
			iTemp2 = new Image(iDebutSeq3);
			iTemp2.ajouterElements(new Element[] { c1, c2, c3, c4, lH4, temp8});
			System.out.println(iTemp2);
			f.ajouterImage(iTemp2);
			temp8 = new Ligne(temp8);
		}
		f.génererFilm("film.txt");

	}

}
