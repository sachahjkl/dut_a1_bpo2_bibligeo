package element;

public enum Direction {
	Est(1,0), NordEst(1,-1), Nord(0,-1), NordOuest(-1,-1), Ouest(-1,0), SudOuest(-1,1), Sud(0,1), SudEst(1,1);
	
	private final int dx, dy;

	private Direction(int dx, int dy) {
		this.dx = dx; this.dy = dy;
	}
	
	public int getDx() {
	    return dx;
	  }

	  public int getDy() {
	    return dy;
	  }
}