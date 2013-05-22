import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class Game extends JPanel {

    /*
    Test TEst
    */


	/**
	 * @param args
	 */
	public static ChessMen[] whiteTeam = new ChessMen[16];
	public static ChessMen[] blackTeam = new ChessMen[16];

	public static boolean[][] checkBoard = new boolean[8][8];
	public static ChessMen[][] boardMen = new ChessMen[8][8];

	public static ChessMen selectedMen;
	public static int targetX;
	public static int targetY;
	
	public static Player player1, player2, currentPlayer;
	

	public static Board b;

	public static void main(String[] args) throws InterruptedException {
		player1 = Player.getPlayer(Team.w);
		player2 = Player.getPlayer(Team.b);
		
		ChessSet cs = ChessSet.getChessSet();
		ArrayList<ChessMen> list = cs.getChessMen();
		b = cs.getBoard();

		for (int i = 0; i < 16; i++) {
			whiteTeam[i] = list.get(i);
			b.setBoardMen(whiteTeam[i].x - 1, whiteTeam[i].y - 1, whiteTeam[i]);

		}

		for (int i = 16; i < 32; i++) {
			blackTeam[i - 16] = list.get(i);
			b.setBoardMen(blackTeam[i - 16].x - 1, blackTeam[i - 16].y - 1,
					blackTeam[i - 16]);

		}

		// TODO Auto-generated method stub
		Handler handler = new Handler();
		JFrame f = new JFrame("Chess");
		f.setResizable(true);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game t = new Game();
		t.addMouseListener(handler);
		f.add(t);
		f.setSize(700, 700);
		f.setVisible(true);

		handler.t = t;

	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		g.setColor(Color.BLUE);
		b.draw(g);

		for (int i = 0; i < 16; i++) {
			whiteTeam[i].draw(g);
			blackTeam[i].draw(g);
		}

		if (selectedMen != null) {
			g.setColor(Color.BLACK);

		}

	}

	private static class Handler implements MouseListener {
		Game t;

		public void mouseClicked(MouseEvent event) {

			if (selectedMen != null) {
				

				targetX = (event.getX() - 40) / 75 + 1;
				targetY = (event.getY() - 40) / 75 + 1;

				if (b.isEmpty(targetX - 1, targetY - 1)) {
					if (selectedMen.isLegalMove(targetX, targetY)
							&& b.pathClean(selectedMen.x, selectedMen.y,
									targetX, targetY)) {
						b.freeBoardMen(selectedMen.x - 1, selectedMen.y - 1);
						selectedMen.x = targetX;
						selectedMen.y = targetY;
						b.setBoardMen(selectedMen.x - 1, selectedMen.y - 1,
								selectedMen);
					}
					
				}
				else {
					if(b.getChessMenAt(targetX-1, targetY-1).team != selectedMen.team){
						
						ChessMen eatenMen=b.getChessMenAt(targetX-1, targetY-1);
						
							if (selectedMen.isLegalMove(targetX, targetY)
									&& b.pathClean(selectedMen.x, selectedMen.y,
											targetX, targetY)) {
								b.freeBoardMen(selectedMen.x - 1, selectedMen.y - 1);
								selectedMen.x = targetX;
								selectedMen.y = targetY;
								b.setBoardMen(selectedMen.x - 1, selectedMen.y - 1,
										selectedMen);
								eatenMen.isActive = false;
							}
							
							
						
					}
				}
				t.repaint();
				selectedMen.selected= false;

				selectedMen = null;
			} else {
				int x = (event.getX() - 40) / 75;
				int y = (event.getY() - 40) / 75;
				System.out.println(x + " " + y);
				selectedMen = b.getBoardMen(x, y);

				if (selectedMen != null) {
					selectedMen.selected = true;
					t.repaint();

				}

				System.out.println(selectedMen);
			}

		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

}
