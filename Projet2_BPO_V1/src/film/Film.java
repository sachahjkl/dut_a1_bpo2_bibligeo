package film;

import java.util.LinkedList;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import image.Image;

public class Film {
	private int resX, resY;
	private LinkedList<Image> mov;

	public Film(int resX, int resY) {
		assert (resX > 0 && resY > 0);
		this.resX = resX;
		this.resY = resY;
		this.mov = new LinkedList<Image>();
	}

	public Film(Film f) {
		this.mov = new LinkedList<Image>(f.mov);
		this.resX = f.resX;
		this.resY = f.resY;
	}

	public void ajouterImage(Image i) {
		assert (i.getResX() == this.resX && i.getResY() == this.resY);
		mov.add(i);
	}

	public void génererFilm(String nomFic) throws IOException {
		PrintWriter out = new PrintWriter(nomFic);
		out.println(this.resX + " " + this.resY);
		for (int i = 0; i < mov.size() - 1; ++i) {
			out.println(mov.get(i) + "\\newframe");
		}
		out.println(mov.get(mov.size() - 1).toString());
		out.close();
	}
}
