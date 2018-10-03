package element;

public class Caractère extends Element {

	private Character c;

	public Caractère(Character c, int x, int y) {
		super(x, y);
		this.setC(c);
	}

	public Caractère(Caractère ch) {
		this(ch.c,ch.getX(),ch.getY());
		this.encadrer(ch.getEncadrement());
	}

	public Character getC() {
		return new Character(c.charValue());
	}

	public void setC(Character c) {
		this.c = new Character(c);
	}

	public void seDessiner(char[][] imgTmp) {
		if (this.plaçable(imgTmp, 0, 0))
			imgTmp[this.getY()][this.getX()] = this.c;
		if (this.estEncadré())
			this.dessinerEncadrement(imgTmp, 0, 0);
	}

	public boolean plaçable(char[][] imgTmp, int x, int y) {
		return this.getX() < imgTmp[0].length && this.getY() < imgTmp.length && this.getX() >= 0 && this.getY() >= 0;
	}

	public void dessinerEncadrement(char[][] imgTmp, int x, int y) {
		final int[] tabX = { 1, -1, 0 };
		final int[] tabY = { 1, -1, 0 };
		for (int dx : tabX) {
			for (int dy : tabY) {
				if (dx == tabX[2] && dy == tabY[2])
					break;
				new Caractère(this.getEncadrement(), this.getX() - dx, this.getY() - dy).seDessiner(imgTmp);
			}
		}
	}

	public Element clone() {
		return new Caractère(this);
	}
}
