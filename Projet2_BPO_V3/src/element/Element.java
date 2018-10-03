package element;

import image.InterfaceElement;

public class Element implements InterfaceElement {
	private int x, y;
	private Character encadrement;

	public Element(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public Element(Element e) {
		this.x = e.x;
		this.y = e.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean estEncadré() {
		return this.encadrement != null;
	}

	public void encadrer(Character c) {
		this.encadrement = new Character(c);
	}

	public void désencadrer() {
		this.encadrement = null;
	}

	public void seDessiner(char[][] imgTmp) {
	}

	public Character getEncadrement() {
		return new Character(encadrement);
	}

	public void dessinerEncadrement(char[][] imgTmp, int x, int y) {
	}

	public boolean plaçable(char[][] imgTmp, int x, int y) {
		return false;
	}

	public Element clone() {
		return new Element(this);
	}
}
