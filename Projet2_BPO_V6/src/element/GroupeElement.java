package element;

import java.util.ArrayList;

import image.InterfaceElement;

public class GroupeElement extends Element {
	private ArrayList<InterfaceElement> Elist;

	public GroupeElement() {
		super(0, 0);
		this.Elist = new ArrayList<InterfaceElement>();
	}

	public GroupeElement(int x, int y) {
		super(x, y);
		this.Elist = new ArrayList<InterfaceElement>();
	}

	public GroupeElement(GroupeElement ge, int x, int y) {
		super(x, y);
		this.Elist = new ArrayList<>(ge.Elist);
		this.encadrer(ge.getEncadrement());
	}

	public void ajouterElement(InterfaceElement e) {
		if (!this.Elist.contains(e))
			this.Elist.add(e);
	}

	public void ajouterElements(InterfaceElement[] e) {
		for (InterfaceElement eAdd : e)
			this.ajouterElement(eAdd);
	}

	public void déplacer(int x, int y) {
		for (InterfaceElement e : Elist) {
			e.setX(e.getX() + (x - this.getX()));
			e.setY(e.getY() + (y - this.getY()));
		}
		this.setX(x);
		this.setY(y);
	}

	public void seDessiner(char[][] imgTmp) {
		for (InterfaceElement e : Elist)
			e.seDessiner(imgTmp);
		if (this.estEncadré()) {
			int[] cCoord = this.getCoordExtreme();
			new Cadre(cCoord[0] - 1, cCoord[1] + 1, cCoord[2] - cCoord[0] + 2, -(cCoord[3] - cCoord[1]) + 2,
					this.getEncadrement()).seDessiner(imgTmp);
		}
	}

	public void encadrerElements(Character c) {
		for (InterfaceElement e : Elist)
			e.encadrer(c);
	}

	public void désencadrerElements() {
		for (InterfaceElement e : Elist)
			e.désencadrer();
	}

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
