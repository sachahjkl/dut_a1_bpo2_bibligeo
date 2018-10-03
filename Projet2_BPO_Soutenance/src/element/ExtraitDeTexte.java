package element;
/**
 * Classe Extrait de texte qui étend un Element
 * Un extrait de texte est obtenu à partir d'un texte et de 4 coordonées
 * qui définissent le point le plus en haut à gauche et le point le plus en bas à droite
 */
public class ExtraitDeTexte extends ElementCoordonné {
	private Texte t;
	private int dx1, dy1, dx2, dy2;
	/**Initialise un extrait de texte à partir de ses coordonnées dans le texte*/
	public ExtraitDeTexte(Texte t, int x, int y, int dx1, int dy1, int dx2, int dy2) {
		super(x, y);
		assert (dy1 < dy2 && dx1 < dx2);
		this.t = t;
		this.setPositions(dx1, dy1, dx2, dy2);
	}
	/**Initialise un extrait de texte à partir d'un extrait de texte*/
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
	/**
	 * Dessine un Extrait de texte avec son encadrement si il est encadré.
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner le caractère           
	 */
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
	/**
	 * @return la longueur de la ligne la plus longue qui compose l'extrait de texte
	 * 
	 */
	int getLenMax() {
		int lenXMax = 0;
		for (int i = this.dy1; i <= dy2; ++i)
			lenXMax = lenXMax >= this.t.getTxt().get(i).length() ? lenXMax : this.t.getTxt().get(i).length();
		return lenXMax;
	}
	/** @return nombre de lignes de l'extrait de texte*/
	int getNbLignes() {
		return dy2 - dy1;
	}
	/**
	 * @return un clone de l'Element sans sa référence.
	 *        
	 */
	public ElementCoordonné clone() {
		return new ExtraitDeTexte(this);
	}
	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 */
	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + dx2 + 1,
					this.getY() - this.t.getTxt().size() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX() + this.getLenMax(),
					this.getY() - this.t.getTxt().size() };
	}
}
