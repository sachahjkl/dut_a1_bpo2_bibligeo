package element;

import java.util.ArrayList;

public abstract class Ligne extends Element {
	private Charactère c;
	private int x, y;

	public Ligne(Charactère c, int x, int y) {
		this.x = x;
		this.y = y;
		this.c = new Charactère(c);
	}
	
	public Ligne(Ligne l) {
		this.c = new Charactère(l.c);
		this.x = l.x;
		this.y = l.y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
