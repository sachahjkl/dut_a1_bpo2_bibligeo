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
		this(l.getX(),l.getY(),l.taille,l.c,l.d);
		this.encadrer(l.getEncadrement());
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

	public Direction getD() {
		return d;
	}

	public void setD(Direction d) {
		this.d = d;
	}

	public void seDessiner(char[][] imgTmp) {
		// Est, NordEst, Nord, NordOuest, Ouest, SudOuest, Sud, SudEst
		int x = this.getX(), y = this.getY();
		
		for (int i = 0; i < this.getTaille(); i++) {
			if (this.plaçable(imgTmp, x, y))
				imgTmp[y][x] = c;
			x += this.d.getDx();
			y += this.d.getDy();
		}
		if (this.estEncadré())
			this.dessinerEncadrement(imgTmp, x, y);
	}

	public boolean plaçable(char[][] imgTmp, int x, int y) {
		return y < imgTmp.length && x < imgTmp[0].length && x >= 0 && y >= 0;
	}

	public void dessinerEncadrement(char[][] imgTmp, int x, int y) {
		//new Cadre
	}
	
	public Element clone() {
		return new Ligne(this);
	}

}