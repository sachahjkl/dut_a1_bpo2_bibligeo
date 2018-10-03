package element;

public class ExtraitDeTexte extends Element {
	private Texte t;
	private int dx1, dy1, dx2, dy2;

	public ExtraitDeTexte(Texte t, int x, int y, int dx1, int dy1, int dx2, int dy2) {
		super(x, y);
		assert (dy1 < dy2 && dx1 < dx2);
		this.t = t;
		this.setPositions(dx1, dy1, dx2, dy2);
	}

	public ExtraitDeTexte(ExtraitDeTexte e) {
		this(e.t, e.getX(), e.getY(), e.dx1, e.dy1, e.dx2, e.dy2);
		this.encadrer(e.getEncadrement());
	}

	public void setPositions(int dx1, int dy1, int dx2, int dy2) {
		if (dy1 < dy2 && dx1 < dx2) {
			this.dy1 = dy1 < 0 ? 0 : dy1;
			this.dy2 = dy2 >= this.t.getTxt().size() ? this.t.getTxt().size() - 1 : dy2;
			this.dx1 = dx1 < 0 ? 0 : dx1;
			this.dx2 = dx2 >= this.getLenMax() ? this.getLenMax() - 1 : dx2;
		}
	}

	public void seDessiner(char[][] imgTmp) {
		int y = this.getY();
		for (int i = this.dy1; i <= dy2; ++i) {
			int x = this.getX();
			for (int j = dx1; j <= dx2; ++j) {
				if (j < this.t.getTxt().get(i).length())
					new Caractère(this.t.getTxt().get(i).toCharArray()[j], x, y).seDessiner(imgTmp);
				else
					new Caractère(' ', x, y).seDessiner(imgTmp); // permet ou non la transparence
				++x;
			}
			--y;
		}
		if (this.estEncadré()) {
			new Cadre(this.getX() - 1, this.getY() + 1, dx2 - dx1 + 2, this.getNbLignes() + 2, this.getEncadrement())
					.seDessiner(imgTmp);
		}
	}

	int getLenMax() {
		int lenXMax = 0;
		for (int i = this.dy1; i <= dy2; ++i)
			lenXMax = lenXMax >= this.t.getTxt().get(i).length() ? lenXMax : this.t.getTxt().get(i).length();
		return lenXMax;
	}

	int getNbLignes() {
		return dy2 - dy1;
	}

	public Element clone() {
		return new ExtraitDeTexte(this);
	}

	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + dx2 + 1,
					this.getY() - this.t.getTxt().size() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX() + this.getLenMax(),
					this.getY() - this.t.getTxt().size() };
	}
}
