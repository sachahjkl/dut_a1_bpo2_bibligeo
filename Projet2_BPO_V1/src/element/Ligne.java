package element;

public abstract class Ligne extends Element {
	private Direction d;
	private int taille;
	private Character c;
	
	public Ligne(int x, int y, int taille, Character c, Direction d) {
		super(x, y);
		assert(taille>1); // on considère qu'une ligne ne peut pas se réduire à un point
		this.taille = taille;
		this.c = new Character(c);
		this.d = d;
	}
	
	public Ligne(Ligne l) {
		super(l.getX(), l.getY());
		this.taille = l.taille;
		this.c = new Character(l.c);
		this.d = l.d;
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void setTaille(int taille) {
		assert(taille>1);
		this.taille = taille;
	}
	
	public void setC(Character c) {
		this.c = c;
	}
	
	public Character getC() {
		return new Character(c);
	}
	
	public Direction getDir() {
		return d;
	}

	public abstract Ligne pivoter();
	
}
