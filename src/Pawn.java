import java.awt.Graphics;

import javax.swing.SwingUtilities;

public class Pawn extends ChessMen {

	private boolean firstMove = true;
	private boolean way;

	public Pawn(Team t, int x, int y) {
		super(t, x, y);

		if (y > 3) {
			this.way = true; // Means it must go upper side of the board
		} else {
			this.way = false; // Must go to lower side of the board
		}

	}



	public boolean isLegalMove(int x, int y) {
		if (firstMove) {
			if (x == this.x && (y - this.y < 3)) {
				firstMove = false;
				return true;
			} else {
				return false;
			}

		}

		else {
			if (x == this.x && (y - this.y < 2)) {

				return true;
			} else {
				return false;
			}

		}

	}

}
