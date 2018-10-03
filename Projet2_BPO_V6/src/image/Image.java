package image;

import java.util.ArrayList;
import java.util.Arrays;

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

	public int getResX() {
		return resX;
	}

	public int getResY() {
		return resY;
	}

	public void ajouterElement(InterfaceElement e) {
		if (!this.listeElements.contains(e))
			this.listeElements.add(e);
	}

	public void ajouterElements(InterfaceElement[] e) {
		for (InterfaceElement eAdd : e)
			this.ajouterElement(eAdd);
	}

	public void retirerElement(InterfaceElement e) {
		if (this.listeElements.contains(e))
			this.listeElements.remove(e);
	}

	public void échanger(InterfaceElement e1, InterfaceElement e2) {
		if (this.listeElements.contains(e1) && this.listeElements.contains(e2)) {
			this.listeElements.set(this.listeElements.indexOf(e2), e1);
			this.listeElements.set(this.listeElements.indexOf(e1), e2);
		}
	}

	public void changerOrdre(InterfaceElement e, int i) {
		if (this.listeElements.contains(e)) {
			this.listeElements.remove(e);
			this.listeElements.add(i, e);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		char[][] imgTmp = new char[resY][resX];
		for (char[] cArr : imgTmp)
			Arrays.fill(cArr, ' ');
		for (InterfaceElement e : listeElements)
			e.seDessiner(imgTmp);
		for (int i = imgTmp.length - 1; i >= 0; --i) {
			for (int j = 0; j < imgTmp[0].length; ++j)
				sb.append(imgTmp[i][j]);
			sb.append("\n");
		}
		return sb.toString();
	}
}
