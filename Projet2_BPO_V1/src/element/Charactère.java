package element;

public class Charactère extends Element {

	private Character c;

	public Charactère(Character c, int x, int y) {
		super(x, y);
		this.setC(c);
	}
	
	public Charactère(Charactère ch) {
		super(ch.getX(), ch.getY());
		this.setC(ch.c);
	}

	public Character getC() {
		return new Character(c.charValue());
	}

	public void setC(Character c) {
		this.c = c;
	}

	public void seDessiner(char[][] tab) {
		tab[this.getX()][this.getY()] = this.c;
	}

	public boolean plaçable(int resX, int resY) {
		return this.getX() < resX && this.getY() < resY;
	}
}
