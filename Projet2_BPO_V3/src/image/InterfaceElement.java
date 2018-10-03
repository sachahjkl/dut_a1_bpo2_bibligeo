package image;

public interface InterfaceElement {

	int getX();

	int getY();

	void setX(int x);

	void setY(int y);

	void seDessiner(char[][] imgTmp) throws ArrayIndexOutOfBoundsException;

	void dessinerEncadrement(char[][] imgTmp, int x, int y) throws ArrayIndexOutOfBoundsException;

	void encadrer(Character c);

	void désencadrer();

	boolean estEncadré();
	
}