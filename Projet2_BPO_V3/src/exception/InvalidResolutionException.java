package exception;

public class InvalidResolutionException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "Image resolution is different from Film ";
	}

}
