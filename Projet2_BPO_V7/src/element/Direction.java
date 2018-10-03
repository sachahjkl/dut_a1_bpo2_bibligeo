package element;

/**
 * Constante d'énumération Direction : Les huit orientations possible d'une ligne
 *        (variation de direction en x, variation de direction en y, coordonées x et y du point le plus en haut à droite) 
 */
public enum Direction {
	Est(1, 0, 0, 0), NordEst(1, 1, 0, 1), Nord(0, 1, 0, 1), NordOuest(-1, 1, -1, 1), Ouest(-1, 0, -1, 0), SudOuest(-1,
			-1, -1, 0), Sud(0, -1, 0, 0), SudEst(1, -1, 0, 0);

	private final int dx, dy, cx, cy;
	
	/**Initialise les valeurs entre parenthèses de l'énumération
	 * 
	 * (variation de direction en x, variation de direction en y, coordonées x et y du point le plus en haut à droite)
	 * */
	private Direction(int dx, int dy, int cx, int cy) {
		this.dx = dx;
		this.dy = dy;
		this.cx = cx;
		this.cy = cy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getCx() {
		return cx;
	}

	public int getCy() {
		return cy;
	}
	/**
	 * méthode suivant : obtient la direction suivante à partir de la direction actuelle dans l'énumération.
	 *        
	 */
	public Direction suivant() {
		return Direction.values()[this.ordinal()] == SudEst ? Est : Direction.values()[this.ordinal() + 1];
	}
	/**
	 * méthode précédent : obtient la direction précédente à partir de la direction actuelle dans l'énumération.
	 *        
	 */
	public Direction précédent() {
		return Direction.values()[this.ordinal()] == Est ? SudEst
				: Direction.values()[this.ordinal() - 1];
	}
}