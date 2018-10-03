package element;

public class LigneH extends Ligne {

	public LigneH(int x, int y, int taille, Character c, Direction d) {
		super(x, y, taille, c, d);
		assert (d == Direction.Ouest || d == Direction.Est);
	}

	public LigneH(Ligne l) {
		super(l);
	}

	public Ligne pivoter(int ang) {
		assert (ang % 45 == 0 && ang > 0);
		Direction d1 = this.getDir();
		if (ang > 0) {
			for (int i = 0; i < ang / 45;++i)
				d1.next();
			return new LigneV(this.getX(), this.getY(), this.getTaille(), this.getC(), d1);
		}
		else if(ang<0) {
			for (int i = 0; i < ang / 45;++i)
				d1.previous();
			return new LigneV(this.getX(), this.getY(), this.getTaille(), this.getC(), d1);
		}
		return this;

	}

	@Override
	public void seDessiner(char[][] imgTmp) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean plaçable(int resX, int resY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ligne pivoter() {
		// TODO Auto-generated method stub
		return null;
	}

}
