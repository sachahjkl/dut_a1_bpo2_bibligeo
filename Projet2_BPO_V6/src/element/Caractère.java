package element;

public class Caractère extends Element {

	private Character c;

	public Caractère(Character c, int x, int y) {
		super(x, y);
		this.setC(c);
	}

	public Caractère(Caractère ch) {
		this(new Character(ch.c), ch.getX(), ch.getY());
		this.encadrer(ch.getEncadrement());
	}

	public Character getC() {
		return new Character(c.charValue());
	}

	public void setC(Character c) {
		this.c = new Character(c);
	}

	public void seDessiner(char[][] imgTmp) {
		final int len = 2;
		if (this.plaçable(imgTmp, this.getX(), this.getY()))
			imgTmp[this.getY()][this.getX()] = this.c;
		if (this.estEncadré()) {
			new Cadre(this.getX() - 1, this.getY() + 1, len, len, this.getEncadrement()).seDessiner(imgTmp);
			//new Cadre(this.getX() - 2, this.getY() + 2, len + 2, len + 2, this.getEncadrement()).seDessiner(imgTmp);
		}
	}

	public Element clone() {
		return new Caractère(this);
	}

	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + 1, this.getY() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX(), this.getY() };
	}
}
