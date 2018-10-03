package element;

import image.Image;

public class Charactère extends Element{
	private Character c;
	
	public Charactère(Character c) {
		this.c = new Character(c);
	}
	
	public Charactère(Charactère c) {
		this.c = new Character(c.c);
	}

	@Override
	public void seDessiner(char[][] c, int x, int y) throws Exception {
	}
	
	public String toString() {
		return c.toString();
	}

}
