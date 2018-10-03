package element;

public enum Direction {
	Est(1, 0, 0, 0), NordEst(1, 1, 0, 1), Nord(0, 1, 0, 1), NordOuest(-1, 1, -1, 1), Ouest(-1, 0, -1, 0), SudOuest(-1,
			-1, -1, 0), Sud(0, -1, 0, 0), SudEst(1, -1, 0, 0);

	private final int dx, dy, cx, cy;

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

	public Direction suivant() {
		return Direction.values()[this.ordinal()] == SudEst ? Est : Direction.values()[this.ordinal() + 1];
	}

	public Direction précédent() {
		return Direction.values()[this.ordinal()] == Est ? SudEst
				: Direction.values()[this.ordinal() - 1];
	}
}