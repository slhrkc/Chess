public class Queen extends ChessMen {
	public Queen(Team t, int x, int y) {
		super(t, x, y);
	}

	@Override
	public boolean isLegalMove(int x, int y) {
		if ((x <= 8 && x > 0) && (y <= 8 && y > 0)) {
			if (this.x == x || this.y == y) {
				return true;
			}

			else if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
				return true;
			}

			else {
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
