package element;

import java.util.ArrayList;

import image.Element;
/**
 *Classe Groupe d'Element : étend la classe Element
 * Définit par une liste d'Elements
 */
public class GroupeElement extends ElementCoordonné {
	private ArrayList<Element> Elist;
	/** Initialise un groupe d'éléments à partir du constructeur de la classe Element*/ 
	public GroupeElement() {
		super(0, 0);
		this.Elist = new ArrayList<Element>();
	}
	/** Initialise un groupe d'éléments à partir de ses coordonnées dans l'image*/ 
	public GroupeElement(int x, int y) {
		super(x, y);
		this.Elist = new ArrayList<Element>();
	}
	/** Initialise un groupe d'éléments à partir d'un groupe d'élements et de ses coordonnées dans l'image*/ 
	public GroupeElement(GroupeElement ge, int x, int y) {
		super(x, y);
		this.Elist = new ArrayList<>(ge.Elist);
		this.encadrer(ge.getEncadrement());
	}
	/** Ajoute un élement e dans la liste */ 
	public void ajouterElement(Element e) {
		if (!this.Elist.contains(e))
			this.Elist.add(e);
	}
	/** Ajoute tous les élements e d'une liste dans la liste qui compose le goupe d'éléments*/ 
	public void ajouterElements(Element[] e) {
		for (Element eAdd : e)
			this.ajouterElement(eAdd);
	}
	/** déplace tous les elements de la liste à de nouvelles cordonnées dans l'image */ 
	public void déplacer(int x, int y) {
		for (Element e : Elist) {
			e.setX(e.getX() + (x - this.getX()));
			e.setY(e.getY() + (y - this.getY()));
		}
		this.setX(x);
		this.setY(y);
	}
	/**
	 * Dessine un Groupe d'éléments avec son encadrement si il est encadré.
	 * 
	 * @param imgTmp
	 *            Un tableau à 2 dimensions ou l'on va dessiner le caractère           
	 */
	public void seDessiner(char[][] imgTmp) {
		for (Element e : Elist)
			e.seDessiner(imgTmp);
		if (this.estEncadré()) {
			int[] cCoord = this.getCoordExtreme();
			new Cadre(cCoord[0] - 1, cCoord[1] + 1, cCoord[2] - cCoord[0] + 2, -(cCoord[3] - cCoord[1]) + 2,
					this.getEncadrement()).seDessiner(imgTmp);
		}
	}
	/**encadre tous les elements du groupe d'éléments individuellement*/
	public void encadrerElements(Character c) {
		for (Element e : Elist)
			e.encadrer(c);
	}
	/**désencadre tous les elements du groupe d'éléments individuellement*/
	public void désencadrerElements() {
		for (Element e : Elist)
			e.désencadrer();
	}
	
	/**
	 * @return les coordonnées des points les plus en haut à gauche et en bas à droite de l'Element
	 * 
	 */
	@Override
	public int[] getCoordExtreme() {
		int x1 = this.Elist.get(0).getCoordExtreme()[0], y1 = this.Elist.get(0).getCoordExtreme()[1],
				x2 = this.Elist.get(0).getCoordExtreme()[2], y2 = this.Elist.get(0).getCoordExtreme()[3];
		for (int i = 1; i < this.Elist.size(); ++i) {
			x1 = x1 > this.Elist.get(i).getCoordExtreme()[0] ? this.Elist.get(i).getCoordExtreme()[0] : x1;
			y1 = y1 < this.Elist.get(i).getCoordExtreme()[1] ? this.Elist.get(i).getCoordExtreme()[1] : y1;
			x2 = x2 <= this.Elist.get(i).getCoordExtreme()[2] ? this.Elist.get(i).getCoordExtreme()[2] : x2;
			y2 = y2 > this.Elist.get(i).getCoordExtreme()[3] ? this.Elist.get(i).getCoordExtreme()[3] : y2;
		}
		return new int[] { x1, y1, x2, y2 };
	}

}
