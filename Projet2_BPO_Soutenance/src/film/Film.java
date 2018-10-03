package film;

import java.util.LinkedList;

import exception.InvalidResolutionException;

import java.io.IOException;
import java.io.PrintWriter;

import image.Image;
/**
 * Classe Film
 * 
 * Définie par sa résoluton et une liste d'images
 */
public class Film {
	private int resX, resY;
	private LinkedList<Image> mov;
	/** Initialise un film à partir d'une resolution*/
	public Film(int resX, int resY) {
		assert (resX > 0 && resY > 0);
		this.resX = resX;
		this.resY = resY;
		this.mov = new LinkedList<Image>();
	}
	/** Initialise un film à partir d'un film*/
	public Film(Film f) {
		this.mov = new LinkedList<Image>(f.mov);
		this.resX = f.resX;
		this.resY = f.resY;
	}
	/** Ajoute une image au film si sa résolution est similaire
	 * 
	 * @param l'image à ajouter
	 * */
	public void ajouterImage(Image i) throws InvalidResolutionException {
		if (i.getResX() != this.resX || i.getResY() != this.resY)
			throw new InvalidResolutionException() ;
		mov.add(i);
	}
	/**génére un film à partir des images de la liste dans un fichier texte donné
	 * 
	 * @param nom du fichier
	 * */
	public void génererFilm(String nomFic) throws IOException {		
		PrintWriter out = new PrintWriter(nomFic);
		out.println(this.resX + " " + this.resY);
		for (int i = 0; i < mov.size() - 1; ++i) {
			out.println(mov.get(i).toString() + "\\newframe");
		}
		out.println(mov.get(mov.size() - 1).toString());
		out.close();
	}
}
