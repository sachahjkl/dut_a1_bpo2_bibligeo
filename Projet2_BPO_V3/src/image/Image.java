package image;

import java.util.ArrayList;

public class Image {
	private int resX, resY;
	private ArrayList<InterfaceElement> listeElements;

	public Image(Image img) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<InterfaceElement>(img.listeElements);
		this.resX = img.resX;
		this.resY = img.resY;
	}

	public Image(int resX, int resY) {
		assert (resX > 0 && resY > 0);
		this.listeElements = new ArrayList<InterfaceElement>();
		this.resX = resX;
		this.resY = resY;
	}

	public Image() {
		this(1, 1);
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

	public void ajouterElement(InterfaceElement e) {
		this.listeElements.add(e);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		char[][] imgTmp = new char[resY][resX];
		for (int i = 0; i < imgTmp.length; ++i) {
			for (int j = 0; j < imgTmp[0].length; ++j)
				imgTmp[i][j] = ' ';
		}
		for (InterfaceElement e : listeElements) {
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
