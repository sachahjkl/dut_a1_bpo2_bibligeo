package image;

public interface InterfaceElement {

	int getX();

	int getY();

	void setX(int x);

	void setY(int y);

	void seDessiner(char[][] imgTmp);

	void encadrer(Character c);

	void désencadrer();

	boolean estEncadré();
	
	int[] getCoordExtreme();
	
}