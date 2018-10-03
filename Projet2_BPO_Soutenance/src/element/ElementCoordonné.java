package element;
import element.ElementCoordonné;
import image.Element;
/**
 * Classe Element : implemente une interface Element.
 * Définit par ses coordonnés dans l'image
 * Tout Element peut être encadré
 *        
 */
public abstract class ElementCoordonné implements Element{
	private int x, y;
	private Character encadrement;
	
	/**Initialise un Element avec des coordonnées x et y données*/
	public ElementCoordonné(int x, int y) {
		this.x = x;
		this.y = y;
		this.encadrement =  new Character(' ');
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Vérifie si un Element est encadré.
	 * Le caractère qui compose l'encadrement vaut ' ' si l'Element n'est pas encadré
	 *        
	 */
	public boolean estEncadré() {
		return this.encadrement != ' ';
	}
	/**
	 * méthode encadrer : Modifie le caractère d'encadrement de l'Element 
	 *   
	 */
	public void encadrer(Character c) {
		this.encadrement = new Character(c);
	}
	
	public Character getEncadrement() {
		return new Character(this.encadrement);
	}
	/**
	 * méthode désencadrer : Le caractère d'encadrement est redéfini comme étant ' '    
	 */
	public void désencadrer() {
		this.encadrement = new Character(' ');
	}
	/**
	 * Vérifie si l'Element est plaçable dans l'image   
	 */
	boolean plaçable(char[][] imgTmp, int x, int y) {
		return y < imgTmp.length && x < imgTmp[0].length && x >= 0 && y >= 0;
	}
	/**
	 * méthode abstraite qui récupère les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 */
	public abstract int[] getCoordExtreme();
}
