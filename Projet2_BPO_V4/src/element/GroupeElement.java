package element;

import java.util.ArrayList;

public class GroupeElement extends Element {
	private ArrayList<Element> Elist;

	public GroupeElement() {
		super(0, 0);
		this.Elist = new ArrayList<Element>();
	}

	public GroupeElement(GroupeElement ge) {
		super(0, 0);
		this.Elist = new ArrayList<>(ge.Elist);
	}

	public void ajouterElement(Element e) {
		this.Elist.add(e);
	}

	public void ajouterElements(Element[] e) {
		for (Element eAdd : e)
			this.Elist.add(eAdd);
	}

	public void déplacerElements(int dx, int dy) {
		for (Element e : Elist) {
			e.setX(e.getX() + dx);
			e.setY(e.getY() + dy);
		}
	}

	public void seDessiner(char[][] imgTmp) {
		for (Element e : Elist)
			e.seDessiner(imgTmp);
	}

	public void encadrer(Character c) {
		for (Element e : Elist)
			e.encadrer(c);
	}

	public void désencadrer() {
		for (Element e : Elist)
			e.désencadrer();
	}

}
