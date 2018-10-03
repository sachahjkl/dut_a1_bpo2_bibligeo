package element;

public abstract class Element {
	private int x, y;

	public Element(int x, int y) {
		assert (x >= 0 && y >= 0);
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		assert (x >= 0);
		this.x = x;
	}

	public void setY(int y) {
		assert (y >= 0);
		this.y = y;
	}
	
	public abstract void seDessiner(char[][] tab);
	public abstract boolean plaçable(int resX, int resY);

}
