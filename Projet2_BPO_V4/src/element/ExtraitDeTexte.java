package element;

public class ExtraitDeTexte extends Element {
	private Texte t;
	private int dx1, dy1, dx2, dy2;

	public ExtraitDeTexte(Texte t, int x, int y, int dx1, int dy1, int dx2, int dy2) {
		super(x, y);
		assert (dy1 < dy2 && dy2 < this.t.getTxt().size() && dx1 >= 0
				&& dx2 < this.t.getTxt().get(this.t.getTxt().size() - 1).length());
		this.t = t;
		this.dx1 = dx1;
		this.dy1 = dy1;
		this.dx2 = dx2;
		this.dy2 = dy2;
	}

	public ExtraitDeTexte(ExtraitDeTexte e) {
		this(new Texte(e.t), e.getX(), e.getY(), e.dx1, e.dy1, e.dx2, e.dy2);
		this.encadrer(e.getEncadrement());
	}

	public void setPositions(int dx1, int dy1, int dx2, int dy2) {
		if (dy1 < dy2 && dy2 < this.t.getTxt().size() && dx1 >= 0
				&& dx2 < this.t.getTxt().get(this.t.getTxt().size() - 1).length()) {
			this.dx1 = dx1;
			this.dy1 = dy1;
			this.dx2 = dx2;
			this.dy2 = dy2;
		}
	}

	public void seDessiner(char[][] imgTmp) {
		ExtraitDeTexte edt = null;
		for (int y = this.dy1; y <= dy2; ++y) {
			for (int x = 0; x < this.t.getTxt().get(y).length(); ++x) {
				if (y == this.dy1 && x == 0)
					x = dx1;
				if (y == dy2 && x > dx2)
					break;
				new Caractère(this.t.getTxt().get(y).toCharArray()[x], this.getX() + x, this.getY() + (y - dy1))
						.seDessiner(imgTmp);
				if (this.estEncadré())
					this.dessinerEncadrement(imgTmp, this.getX() + x, this.getY() + (y - dy1));
			}
		}
		if (this.estEncadré()) {
			edt = new ExtraitDeTexte(this);
			edt.désencadrer();
			edt.seDessiner(imgTmp);
		}
	}

	public void dessinerEncadrement(char[][] imgTmp, int x, int y) {
		Caractère c = new Caractère(this.getEncadrement(), x, y);
		c.encadrer(this.getEncadrement());
		c.dessinerEncadrement(imgTmp, x, y);
	}

	public Element clone() {
		return new ExtraitDeTexte(this);
	}
}
