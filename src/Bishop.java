import java.io.File;
import java.io.IOException;
import java.lang.Math;

import javax.imageio.ImageIO;

public class Bishop extends ChessMen {
	public Bishop(Team t, int x, int y) {
		super(t, x, y);
	}

	public boolean isLegalMove(int x, int y) {
		
		System.out.printf("%d, %d", x, y);
		if ((x <= 8 && x > 0) && (y <= 8 && y > 0)) {
			if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
				System.out.println("LEGAL");

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
