package element;

import java.util.ArrayList;
/**
 * Classe Texte : étend Element
 * 
 * Definie par une liste de caractère
 */
public class Texte extends ElementCoordonné {

	private ArrayList<String> txt;
	/**Initialise un texte à partir de ses coordonnées*/
	public Texte(int x, int y) {
		super(x, y);
		this.txt = new ArrayList<String>();
	}
	/**Initialise un texte à partir d'un texte*/
	public Texte(Texte t) {
		super(t.getX(), t.getY());
		this.txt = new ArrayList<String>(t.txt);
		this.encadrer(t.getEncadrement());
	}
	/**Ajoute une ligne (chaine de caratctère) dans le texte */
	public void ajouterligneTxt(String strTxt) {
		String[] strLigne = strTxt.split("[\\r\\n]+");
		for (String s : strLigne)
			this.txt.add(s);
	}
	/**
	 * Dessine la chaine de caractère dans une image avec son encadrement si il est encadré
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner le caractère           
	 */
	public void seDessiner(char[][] imgTmp) {
		int y = this.getY();
		for (int i = 0; i < this.txt.size(); ++i) {
			int x = this.getX();
			for (char c : txt.get(i).toCharArray()) {
				new Caractère(c, x, y).seDessiner(imgTmp);
				++x;
			}
			--y;
		}
		if (this.estEncadré()) {
			new Cadre(this.getX() - 1, this.getY() + 1, this.getLenMax() + 1, this.txt.size() + 1,
					this.getEncadrement()).seDessiner(imgTmp);
		}
	}

	ArrayList<String> getTxt() {
		return new ArrayList<String>(this.txt);
	}
	/**
	 * @return La longueur de la ligne la plus longue que contient le texte           
	 */
	int getLenMax() {
		int lenXMax = 0;
		for (String s : this.txt)
			lenXMax = lenXMax < s.length() ? s.length() : lenXMax;
		return lenXMax;
	}
	/**
	 * @return un clone de l'Element sans sa référence.
	 */
	public ElementCoordonné clone() {
		return new Texte(this);
	}

	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 */
	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + this.getLenMax() + 1,
					this.getY() - this.txt.size() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX() + this.getLenMax(),
					this.getY() - this.txt.size() };
	}

}
