import java.util.ArrayList;


public class ChessSet {
	protected Board board;
	protected ArrayList<ChessMen> pieceSet;
	
	protected ChessSet(){
		this.board = Board.getBoard();
		this.pieceSet = ChessMen.getChessSet();
	}
	
	public static ChessSet getChessSet(){
		return new ChessSet();
	}
	
	public Board getBoard(){
		return board;
	}
	public ArrayList <ChessMen> getChessMen(){
		return pieceSet;
	}

}
