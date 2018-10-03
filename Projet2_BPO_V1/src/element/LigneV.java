package element;

public class LigneV extends Ligne {

	public LigneV(int x, int y, int taille, Character c, Direction d) {
		super(x, y, taille, c, d);
	}

	public LigneV(Ligne l) {
		super(l);
	}

	@Override
	public Ligne pivoter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void seDessiner(char[][] tab) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean plaçable(int resX, int resY) {
		// TODO Auto-generated method stub
		return false;
	}

}
