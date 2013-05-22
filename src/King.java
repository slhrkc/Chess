/**
 * 
 */

/**
 * @author salih
 * 
 */
public class King extends ChessMen {
	public King(Team t, int x, int y) {
		super(t, x, y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ChessMen#isLegalMove(int, int)
	 */
	@Override
	public boolean isLegalMove(int x, int y) {
		if ((x <= 8 && x > 0) && (y <= 8 && y > 0)) {
			if ((Math.abs(x - this.x) < 2 && Math.abs(y - this.y) < 2)
					&& (Math.abs(x - this.x) + Math.abs(y - this.y) > 0)) {
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
