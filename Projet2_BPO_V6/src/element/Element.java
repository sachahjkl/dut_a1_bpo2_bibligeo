package element;
import element.Element;
import image.InterfaceElement;

public abstract class Element implements InterfaceElement{
	private int x, y;
	private Character encadrement;
	
	public Element(int x, int y) {
		this.x = x;
		this.y = y;
		this.encadrement =  new Character(' ');
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
		return this.encadrement != ' ';
	}

	public void encadrer(Character c) {
		this.encadrement = new Character(c);
	}
	public Character getEncadrement() {
		return new Character(this.encadrement);
	}

	public void désencadrer() {
		this.encadrement = new Character(' ');
	}
	
	boolean plaçable(char[][] imgTmp, int x, int y) {
		return y < imgTmp.length && x < imgTmp[0].length && x >= 0 && y >= 0;
	}
	
	public abstract int[] getCoordExtreme();
}
