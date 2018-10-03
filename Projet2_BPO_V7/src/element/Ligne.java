package element;
/**
 * Classe Ligne : étend Element
 * 
 * Définie par une chaine de caractère s
 * et une direction d
 */
public class Ligne extends ElementCoordonné {
	private String s;
	private Direction d;
	/** Initialise une ligne à partir de coordonnées, d'une chaine de caractère et d'une direction*/
	public Ligne(int x, int y, String s, Direction d) {
		super(x, y);
		assert (s != ""); // on considère qu'une ligne ne peut pas se réduire à un point
		this.s = new String(s);
		this.d = d;
	}
	/** Initialise une ligne à partir d'une ligne*/
	public Ligne(Ligne l) {
		this(l.getX(), l.getY(), l.s, l.d);
		this.encadrer(new Character(l.getEncadrement()));
	}
	/** Initialise une ligne à partir d'une ligne et d'une direction*/
	public Ligne(Ligne l, Direction d) {
		this(l.getX(), l.getY(),l.s, d);
		this.encadrer(l.getEncadrement());
	}

	public int getTaille() {
		return this.s.length();
	}

	public String getLigne() {
		return new String(this.s);
	}

	public void setLigne(String s) {
		this.s = new String(s);
	}

	public Direction getD() {
		return d;
	}

	public void setDirection(Direction d) {
		this.d = d;
	}
	
	/** Permet la rotation d'une ligne dans le sens horraire*/
	public void tournerHoraire() {
		this.setDirection(this.d.précédent());
	}
	/** Permet la rotation d'une ligne dans le sens anti horraire*/
	public void tournerAntiHoraire() {
		this.setDirection(this.d.suivant());
	}
	
	/**
	 * Dessine une ligne avec son encadrement si il est encadré.
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner le caractère           
	 */
	public void seDessiner(char[][] imgTmp) {
		int x = this.getX(), y = this.getY();
		int[] vC = this.getCoordHautGaucheEtLenXY();
		for (int i = 0; i < this.getTaille(); i++) {
			if (this.plaçable(imgTmp, x, y))
				imgTmp[y][x] = s.charAt(i);
			x += this.d.getDx();
			y += this.d.getDy();
		}
		if (this.estEncadré())
			new Cadre(vC[0] - 1, vC[1] + 1, vC[2] + 1, vC[3] + 1, this.getEncadrement()).seDessiner(imgTmp);
	}
	/**
	 * @return la longueur et la position du point le plus en haut à gauche de la ligne
	 * 
	 */
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
	
	/**
	 * @return un clone de l'Element sans sa référence.
	 *        
	 */
	public ElementCoordonné clone() {
		return new Ligne(this);
	}
	
	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 */
	public int[] getCoordExtreme() {
		int[] vL = this.getCoordHautGaucheEtLenXY();
		if (this.estEncadré())
			return new int[] { vL[0] - 1, vL[1] + 1, vL[0] + vL[2] + 1, vL[1] - vL[3] - 1 };
		else
			return new int[] { vL[0], vL[1], vL[0] + vL[2], vL[1] - vL[3] };
	}

}