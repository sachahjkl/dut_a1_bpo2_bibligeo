package exception;
/**
 * Exeption renvoyé si la résolution d'une image est différente de celle du film
 * 
 */
public class InvalidResolutionException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "Image resolution is different from Film ";
	}

}
