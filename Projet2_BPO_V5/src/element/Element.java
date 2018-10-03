package element;
import element.Element;
import image.InterfaceElement;

public abstract class Element implements InterfaceElement{
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

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
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
	public Character getEncadrement() {
		return new Character(this.encadrement);
	}

	public void désencadrer() {
		this.encadrement = null;
	}
}
