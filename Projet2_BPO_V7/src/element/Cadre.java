package element;

/**
 * Classe cadre : Un caractère c à une position (x, y)
 * est repété sur une longueur LenX ou LenY.
 * Il permet de créer les lignes qui composent un encadrement
 */
public class Cadre {
	private int x, y, lenX, lenY;
	private Character c;
	
	/** Initialise un cadre avec une position et des longueurs données */
	public Cadre(int x, int y, int lenX, int lenY, Character c) {
		this.x = x;
		this.y = y;
		this.lenX = lenX;
		this.lenY = lenY;
		this.c = new Character(c);
	}
	
	/**
	 * méthode seDessiner : dessine toutes lignes necessaire à un encadrement.
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner l'encardement         
	 */
	public void seDessiner(char[][] imgTmp) {
		new Ligne(x, y, repeat(c, lenX + 1), Direction.Est).seDessiner(imgTmp);
		new Ligne(x + lenX, y - 1, repeat(c, lenY), Direction.Sud).seDessiner(imgTmp);
		new Ligne(x + lenX - 1, y - lenY, repeat(c, lenX), Direction.Ouest).seDessiner(imgTmp);
		new Ligne(x, y, repeat(c, lenY), Direction.Sud).seDessiner(imgTmp);
		new Ligne(x - 1, y + 1, repeat(c, lenX + 3), Direction.Est).seDessiner(imgTmp);
		new Ligne(x + lenX + 1, y, repeat(c, lenY + 2), Direction.Sud).seDessiner(imgTmp);
		new Ligne(x + lenX, y - lenY - 1, repeat(c, lenX + 2), Direction.Ouest).seDessiner(imgTmp);
		new Ligne(x - 1, y + 1, repeat(c, lenY + 2), Direction.Sud).seDessiner(imgTmp);
	}
	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 * @param c
	 *            le caractère à répéter.
	 * @param len
	 *            La longueur sur laquelle est répétée le caractère.
	 *            
	 */
	public static String repeat(char c, int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; ++i)
			sb.append(c);
		return sb.toString();
	}

}
