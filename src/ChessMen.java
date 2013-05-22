import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

enum Team {
	w, b
}



public abstract class ChessMen extends JComponent {

	public int x, y;
	protected Team team;
	protected BufferedImage img;
	public boolean selected = false;
	public boolean isActive = true;
	
	/**
	 * 
	 * @return A list containing 32 chess men.<br>
	 * The list is as follows.<br>
	 * <li>0 - white pawn @ (A,2)</li>
	 * <li>1 - white pawn @ (B,2).</li>
	 * <li>2 - white pawn @ (C,2).</li>
	 */

	public static ArrayList<ChessMen> getChessSet() {
		ArrayList<ChessMen> list = new ArrayList<ChessMen>();

		for (int i = 1; i < 9; i++) {
			list.add(new Pawn(Team.w, i, 2));
		}

		list.add(new Rook(Team.w, 1, 1));
		list.add(new Rook(Team.w, 8, 1));

		list.add(new Knight(Team.w, 2, 1));
		list.add(new Knight(Team.w, 7, 1));

		list.add(new Bishop(Team.w, 3, 1));
		list.add(new Bishop(Team.w, 6, 1));

		list.add(new King(Team.w, 5, 1));

		list.add(new Queen(Team.w, 4, 1));
		
		
		
		for (int i = 1; i < 9; i++) {
			list.add(new Pawn(Team.b, i, 7));
		}
		
		list.add(new Rook(Team.b, 1, 8));
		list.add(new Rook(Team.b, 8, 8));

		list.add(new Knight(Team.b, 2, 8));
		list.add(new Knight(Team.b, 7, 8));

		list.add(new Bishop(Team.b, 3, 8));
		list.add(new Bishop(Team.b, 6, 8));

		list.add(new King(Team.b, 5, 8));

		list.add(new Queen(Team.b, 4, 8));
		
		
		return list;
		

	}

	protected ChessMen(Team team, int x, int y) {

		this.x = x;
		this.y = y;
		this.team = team;

		/*
		 * 
		 * Assigns the pictures for each piece
		 */
		try {
			this.img = ImageIO.read(new File("images\\" + team
					+ this.getClass().getName() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void draw(Graphics g) {

		if (isActive) {
			if (!selected) {
				g.drawImage(img, 47 + 75 * (x - 1), 47 + 75 * (y - 1), this);
				//System.out.println("ttttt"+this.getClass().getName());

			}

			else {
				g.drawImage(img, 47 + 75 * (x - 1), 47 + 75 * (y - 1), this);
				g.drawRect(50 + 75 * (x - 1), 50 + 75 * (y - 1), 55, 55);

			}

		}

	}

	public String toString() {
		return this.team.toString() + "" + this.getClass().getName() + "	";
	}

	public abstract boolean isLegalMove(int x, int y);

	public void makeMove(int x, int y) {
		this.x = x;
		this.y = y;

	}

}
