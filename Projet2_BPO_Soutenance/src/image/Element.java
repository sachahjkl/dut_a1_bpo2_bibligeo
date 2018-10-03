package image;
/** 
 * L'Interface Element
 * 
 * Contient les méthodes abstraites qui caractérisent un élément
 * 
 * */
public interface Element {

	int getX();

	int getY();

	void setX(int x);

	void setY(int y);

	void seDessiner(char[][] imgTmp);

	void encadrer(Character c);

	void désencadrer();
	
	int[] getCoordExtreme();
	
}