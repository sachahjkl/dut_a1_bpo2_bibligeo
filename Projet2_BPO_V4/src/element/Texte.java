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
		this.txt.add(strTxt);
	}

	public void seDessiner(char[][] imgTmp) {
		int y = this.getY();
		Texte t = null;
		for (String s : txt) {
			int x = this.getX();
			for (char c : s.toCharArray()) {
				new Caractère(c, x, y).seDessiner(imgTmp);
				if (this.estEncadré())
					this.dessinerEncadrement(imgTmp, x, y);
				++x;
			}
			++y;
		}
		if (this.estEncadré()) {
			t = new Texte(this);
			t.désencadrer();
			t.seDessiner(imgTmp);
		}
	}

	public void dessinerEncadrement(char[][] imgTmp, int x, int y) {
		Caractère c = new Caractère(this.getEncadrement(), x, y);
		c.encadrer(this.getEncadrement());
		c.dessinerEncadrement(imgTmp, x, y);
	}

	public ArrayList<String> getTxt() {
		return new ArrayList<String>(this.txt);
	}

	public Element clone() {
		return new Texte(this);
	}

}
