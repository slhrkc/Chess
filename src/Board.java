import java.awt.*;

import javax.swing.JComponent;

public class Board extends JComponent {

	private final int leftPadding;
	private final int topPadding;
	private final int edgeSize;
	private final int boardWidth;
	private ChessMen[][] boardMen = new ChessMen[8][8];

	public Board(int leftPadding, int topPadding, int edgeSize, int boardWidth) {
		this.leftPadding = leftPadding;
		this.topPadding = topPadding;
		this.edgeSize = edgeSize;
		this.boardWidth = boardWidth;

		this.add(new Pawn(Team.b, 3, 5));

	}

	/**
	 * 
	 * @return a Board with default values, <li>Left Margin is 40 <li>Top
	 *         Marging is 40 <li>Board width is 600 <li>Square width is 75
	 */
	public static Board getBoard() {
		return new Board(40, 40, 75, 600);
	}
	
	public ChessMen getChessMenAt(int x, int y){
		return boardMen[x][y];
	}

	public boolean pathClean(int x1, int y1, int x2, int y2) {
		if (x1 == x2 || y1 == y2) { // for Rook and Queen
			if (x1 == x2) {
				if (y1 > y2) {
					for (int i = y1 - 1; i > y2; i--) {
						if (boardMen[x1 - 1][i - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							
							return false;
						}
					}
					return true;
				} else {
					for (int i = y2 - 1; i > y1; i--) {
						if (boardMen[x1 - 1][i - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
					}
					return true;
				}
			} else { // y2 == y1
				if (x1 > x2) {
					for (int i = x1 - 1; i > x2; i--) {
						if (boardMen[i - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
					}
					return true;
				} else {
					for (int i = x2 - 1; i > x1; i--) {
						if (boardMen[i - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
					}
					return true;
				}

			}
		}

		else {
			if(Math.abs(x2-x1)!=Math.abs(y2-y1)){
				return true;
			}
			// Warning CHECK IT ONE MORE TIME ,BIRI ARTARKEN DIÐERI AZALABILIR
			else if (x1 > x2) {// for Bishops
				if(y1>y2){
					x1--;
					y1--;
					while (x1 > x2) {
						System.out.println(x1+y1);
						if (boardMen[x1 - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
						x1--;
						y1--;
					}
					return true;
				}
				else{
					x1--;
					y1++;
					while (x1 > x2) {
						System.out.println(x1+y1);
						if (boardMen[x1 - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
						x1--;
						y1++;
					}
					return true;
				}
				

			} else {
				if(y1<y2){
					x1++;
					y1++;
					while (x1 < x2) {
						if (boardMen[x1 - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);

							return false;
						}
						x1++;
						y1++;
					}
					return true;
				}
				else{
					x1++;
					y1--;
					while (x1 < x2) {
						if (boardMen[x1 - 1][y1 - 1] != null) {
							System.out.println("X is "+x1+" Y is "+y1);
							return false;
						}
						x1++;
						y1--;
					}
					return true;
				}
				
			}
			

		}

		
	}

	public void setBoardMen(int x, int y, ChessMen c) {
		boardMen[x][y] = c;
	}

	public ChessMen getBoardMen(int x, int y) {
		return boardMen[x][y];
	}

	public boolean isEmpty(int x, int y) {
		if (boardMen[x][y] == null) {
			return true;
		} else {
			return false;
		}
	}

	public void freeBoardMen(int x, int y) {
		boardMen[x][y] = null;
	}

	public void draw(Graphics g) {
		for (Component t : this.getComponents()) {
			t.repaint();
			System.out.println("ddddddddd");
		}
		g.drawRect(leftPadding, topPadding, boardWidth, boardWidth);

		for (int i = 0; i < 64; i++) {
			g.setColor(Color.darkGray);

			g.drawRect(leftPadding + (i % 8) * edgeSize, topPadding + (i / 8)
					* edgeSize, edgeSize, edgeSize);
			i++;
			g.setColor(Color.darkGray);
			g.drawRect(leftPadding + (i % 8) * edgeSize, topPadding + (i / 8)
					* edgeSize, edgeSize, edgeSize);
			g.setColor(Color.WHITE);

		}
		g.setColor(Color.BLACK);
		g.drawString("A", leftPadding + edgeSize / 2, 30);
		g.drawString("B", leftPadding + edgeSize / 2 + edgeSize, 30);
		g.drawString("C", leftPadding + edgeSize / 2 + edgeSize * 2, 30);
		g.drawString("D", leftPadding + edgeSize / 2 + edgeSize * 3, 30);
		g.drawString("E", leftPadding + edgeSize / 2 + edgeSize * 4, 30);
		g.drawString("F", leftPadding + edgeSize / 2 + edgeSize * 5, 30);
		g.drawString("G", leftPadding + edgeSize / 2 + edgeSize * 6, 30);
		g.drawString("H", leftPadding + edgeSize / 2 + edgeSize * 7, 30);

		g.drawString("1", 30, topPadding + edgeSize / 2);
		g.drawString("2", 30, topPadding + edgeSize / 2 + edgeSize);
		g.drawString("3", 30, topPadding + edgeSize / 2 + edgeSize * 2);
		g.drawString("4", 30, topPadding + edgeSize / 2 + edgeSize * 3);
		g.drawString("5", 30, topPadding + edgeSize / 2 + edgeSize * 4);
		g.drawString("6", 30, topPadding + edgeSize / 2 + edgeSize * 5);
		g.drawString("7", 30, topPadding + edgeSize / 2 + edgeSize * 6);
		g.drawString("8", 30, topPadding + edgeSize / 2 + edgeSize * 7);

	}

}
