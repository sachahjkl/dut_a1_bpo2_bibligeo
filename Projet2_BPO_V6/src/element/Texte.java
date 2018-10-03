package element;

import java.util.ArrayList;

public class Texte extends Element {

	private ArrayList<String> txt;

	public Texte(int x, int y) {
		super(x, y);
		this.txt = new ArrayList<String>();
	}

	public Texte(Texte t) {
		super(t.getX(), t.getY());
		this.txt = new ArrayList<String>(t.txt);
		this.encadrer(t.getEncadrement());
	}

	public void ajouterligneTxt(String strTxt) {
		String[] strLigne = strTxt.split("[\\r\\n]+");
		for (String s : strLigne)
			this.txt.add(s);
	}

	public void seDessiner(char[][] imgTmp) {
		int y = this.getY(), lenMax = 0;
		for (int i = this.txt.size() - 1; i >= 0; --i) {
			int x = this.getX();
			for (char c : txt.get(i).toCharArray()) {
				new Caractère(c, x, y).seDessiner(imgTmp);
				++x;
			}
			lenMax = lenMax >= x ? lenMax : x;
			++y;
		}
		if (this.estEncadré()) {
			new Cadre(this.getX() - 1, y, lenMax, this.txt.size() + 1, this.getEncadrement()).seDessiner(imgTmp);
		}
	}

	ArrayList<String> getTxt() {
		return new ArrayList<String>(this.txt);
	}

	int getLenMax() {
		int lenXMax = 0;
		for (String s : this.txt)
			lenXMax = lenXMax < s.length() ? s.length() : lenXMax;
		return lenXMax;
	}

	public Element clone() {
		return new Texte(this);
	}

	public int[] getCoordExtreme() {
		if (this.estEncadré())
			return new int[] { this.getX() - 1, this.getY() + 1, this.getX() + this.getLenMax() + 1,
					this.getY() - this.txt.size() - 1 };
		else
			return new int[] { this.getX(), this.getY(), this.getX() + this.getLenMax(),
					this.getY() - this.txt.size() };
	}

}
