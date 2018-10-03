package element;
/**
 * Classe Caractère qui étend Element
 * Définie par un Character
 */
public class Caractère extends ElementCoordonné {

	private Character c;
	
	/**Initialise un Character à une position donnée*/
	public Caractère(Character c, int x, int y) {
		super(x, y);
		this.setC(c);
	}
	/**Initialise un Character avec un autre Caracter*/
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
	
	/**
	 * méthode seDessiner : dessine un caractère si il est plaçable, et son encadrement si il est encadré.
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner le caractère           
	 */
	public void seDessiner(char[][] imgTmp) {
		final int len = 2;
		if (this.plaçable(imgTmp, this.getX(), this.getY()))
			imgTmp[this.getY()][this.getX()] = this.c;
		if (this.estEncadré()) {
			new Cadre(this.getX() - 1, this.getY() + 1, len, len, this.getEncadrement()).seDessiner(imgTmp);
			//new Cadre(this.getX() - 2, this.getY() + 2, len + 2, len + 2, this.getEncadrement()).seDessiner(imgTmp);
		}
	}
	
	/**
	 * @return un clone de l'Element sans sa référence.
	 *        
	 */
	public ElementCoordonné clone() {
		return new Caractère(this);
	}
	
	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 */
	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + 1, this.getY() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX(), this.getY() };
	}
}
