package element;

public class Ligne extends Element {
	private int taille;
	private Character c;
	private Direction d;

	public Ligne(int x, int y, int taille, Character c, Direction d) {
		super(x, y);
		assert (taille > 1); // on considère qu'une ligne ne peut pas se réduire à un point
		this.taille = taille;
		this.c = c;
		this.d = d;
	}

	public Ligne(Ligne l) {
		this(l.getX(), l.getY(), l.taille, new Character(l.c), l.d);
		this.encadrer(new Character(l.getEncadrement()));
	}

	public Ligne(Ligne l, Direction d) {
		this(l.getX(), l.getY(), l.taille, l.c, d);
		this.encadrer(l.getEncadrement());
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(int taille) {
		assert (taille > 1);
		this.taille = taille;
	}

	public Character getC() {
		return new Character(c.charValue());
	}

	public void setC(Character c) {
		this.c = new Character(c);
	}

	public Direction getD() {
		return d;
	}

	public void setDirection(Direction d) {
		this.d = d;
	}
	
	public void tournerHoraire() {
		this.setDirection(this.d.précédent());
	}
	
	public void tournerAntiHoraire() {
		this.setDirection(this.d.suivant());
	}

	public void seDessiner(char[][] imgTmp) {
		int x = this.getX(), y = this.getY();
		int[] vC = this.getCoordHautGaucheEtLenXY();
		if (this.plaçable(imgTmp, x, y))
			imgTmp[y][x] = c;
		for (int i = 0; i < this.getTaille() - 1; i++) {
			x += this.d.getDx();
			y += this.d.getDy();
			if (this.plaçable(imgTmp, x, y))
				imgTmp[y][x] = c;
		}
		if (this.estEncadré())
			new Cadre(vC[0] - 1, vC[1] + 1, vC[2] + 1, vC[3] + 1, this.getEncadrement()).seDessiner(imgTmp);
	}

	int[] getCoordHautGaucheEtLenXY() {
		int xHG = this.getX(), yHG = this.getY(), lenX = 1, lenY = 1;
		for (int i = 0; i < this.getTaille() - 1; i++) {
			xHG += this.d.getCx();
			yHG += this.d.getCy();
			lenX += Math.abs(this.d.getDx());
			lenY += Math.abs(this.d.getDy());
		}
		return new int[] { xHG, yHG, lenX, lenY };
	}

	public Element clone() {
		return new Ligne(this);
	}

	public int[] getCoordExtreme() {
		int[] vL = this.getCoordHautGaucheEtLenXY();
		if (this.estEncadré())
			return new int[] { vL[0] - 1, vL[1] + 1, vL[0] + vL[2] + 1, vL[1] - vL[3] - 1 };
		else
			return new int[] { vL[0], vL[1], vL[0] + vL[2], vL[1] - vL[3] };
	}

}