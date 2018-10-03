package image;

import java.util.ArrayList;
import java.util.Arrays;
/**Classe Image
 * Définie par sa résolution et une liste d'éléments
 * */
public class Image {
	private int resX, resY;
	private ArrayList<Element> listeElements;
	/** Initialise une image à partir d'une image*/
	public Image(Image img) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<Element>(img.listeElements);
		this.resX = img.resX;
		this.resY = img.resY;
	}
	/** Initialise une image à partir de sa résolution*/
	public Image(int resX, int resY) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<Element>();
		this.resX = resX;
		this.resY = resY;
	}

	public int getResX() {
		return resX;
	}

	public int getResY() {
		return resY;
	}

	public void ajouterElement(Element e) {
		if (!this.listeElements.contains(e))
			this.listeElements.add(e);
	}

	public void ajouterElements(Element[] e) {
		for (Element eAdd : e)
			this.ajouterElement(eAdd);
	}

	public void retirerElement(Element e) {
		if (this.listeElements.contains(e))
			this.listeElements.remove(e);
	}
	/** Echange 2 éléments de la liste
	 *
	 * @param l'élément 1 à échanger avec l'élément 2
	 *
	 * @param élément 2 à échanger avec l'élément 1
	 *
	 * */
	public void échanger(Element e1, Element e2) {
		if (this.listeElements.contains(e1) && this.listeElements.contains(e2)) {
			this.listeElements.set(this.listeElements.indexOf(e2), e1);
			this.listeElements.set(this.listeElements.indexOf(e1), e2);
		}
	}

	/**
	 * Modifie l'emplacement d'un élément dans l'image
	 *
	 * @param l'élément
	 *
	 * @param i
	 * 		 l'indice du nouvel emplacement de l'élément dans l'image
	 *
	 * */
	public void changerOrdre(Element e, int i) {
		if (this.listeElements.contains(e)) {
			this.listeElements.remove(e);
			this.listeElements.add(i, e);
		}
	}
	/**
	 * @return les éléments dessinés dans l'image
	 *
	 * */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		char[][] imgTmp = new char[resY][resX];
		for (char[] cArr : imgTmp)
			Arrays.fill(cArr, ' ');
		for (Element e : listeElements)
			e.seDessiner(imgTmp);
		for (int i = imgTmp.length - 1; i >= 0; --i) {
			for (int j = 0; j < imgTmp[0].length; ++j)
				sb.append(imgTmp[i][j]);
			sb.append("\n");
		}
		return sb.toString();
	}
}
