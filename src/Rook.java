public class Rook extends ChessMen {
	Rook(Team t, int x, int y) {
		super(t, x, y);
		
	}
	
	public boolean isLegalMove(int x,int y){
		if ((x <= 8 && x > 0) && (y <= 8 && y > 0)) {
			if (this.x == x || this.y == y) {
				return true;
			} else {
				System.out.println("ILLEGAL");
				return false;
			}

		}

		else {
			System.out.println("ILLEGAL");
			return false;
		}
	}

}
