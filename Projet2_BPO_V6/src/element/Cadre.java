package element;

public class Cadre {
	private int x, y, lenX, lenY;
	private Character c;

	public Cadre(int x, int y, int lenX, int lenY, Character c) {
		this.x = x;
		this.y = y;
		this.lenX = lenX;
		this.lenY = lenY;
		this.c = new Character(c);
	}

	public void seDessiner(char[][] imgTmp) {
		new Ligne(x, y, lenX+1, c, Direction.Est).seDessiner(imgTmp);
		new Ligne(x + lenX, y - 1, lenY, c, Direction.Sud).seDessiner(imgTmp);
		new Ligne(x + lenX - 1, y - lenY, lenX, c, Direction.Ouest).seDessiner(imgTmp);
		new Ligne(x, y, lenY, c, Direction.Sud).seDessiner(imgTmp);
	}

}
