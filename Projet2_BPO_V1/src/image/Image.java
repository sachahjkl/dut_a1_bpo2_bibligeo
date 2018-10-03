package image;

import java.util.ArrayList;
import element.*;

public class Image {
	private int resX, resY;
	private ArrayList<Element> listeElements;

	public Image(Image img) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<Element>(img.listeElements);
		this.resX = img.resX;
		this.resY = img.resY;
	}

	public Image(int resX, int resY) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<Element>();
		this.resX = resX;
		this.resY = resY;
	}

	public Image() {
		this.listeElements = new ArrayList<Element>();
		this.resX = 1;
		this.resY = 1;
	}

	public int getResX() {
		return resX;
	}
	
	public int getResY() {
		return resY;
	}
	
	public void deplacerElement(int indiceElement, int x, int y) {
		assert (x >= 0 && y >= 0);
		listeElements.get(indiceElement).setX(x);
		listeElements.get(indiceElement).setY(y);
	}
	
	public void ajouterElement(Element e){
		assert(e.plaçable(resX, resY));
		this.listeElements.add(e);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		char[][] imgTmp = new char[resX][resY];
		for (char[] lc : imgTmp) {
			for (char c : lc) {
				c = ' ';
			}
		}
		for (Element e : listeElements) {
			e.seDessiner(imgTmp);
		}
		for (char[] lc : imgTmp) {
			for (char c : lc) {
				sb.append(c);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// (Y)o(us)sef_debug
	public void showElems() {
		for (int i = 0; i < listeElements.size(); ++i) {
			System.out.println("Element n°" + i + " de type " + listeElements.get(i));
		}
	}

}
