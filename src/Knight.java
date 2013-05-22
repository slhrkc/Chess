public class Knight extends ChessMen {
	public Knight(Team t, int x, int y) {
		super(t, x, y);
	}

	@Override
	public boolean isLegalMove(int x, int y) {
		// TODO Auto-generated method stub
		if ((x <= 8 && x > 0) && (y <= 8 && y > 0)) {
			if ((Math.abs(x - this.x) == 2 && Math.abs(y - this.y) == 1)
					|| (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 2)) {

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
