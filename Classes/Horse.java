package Classes;

public class Horse extends Piece {
	
	public Horse(String n, int x, int y){
		super(x,y,n);
	}

	public boolean pieceLogic(Piece[][] board, Vector whereTo) {
		//These two large if statements make sure whereTo is two tiles in any direction
		//The two smaller if statements make sure that it's one tile to the side
		if(whereTo.x==coords.x-2||whereTo.x==coords.x+2) {
			if(whereTo.y==coords.y+1||whereTo.y==coords.y-1)
				return true;
		}
		else if(whereTo.y==coords.y-2||whereTo.y==coords.y+2) {
			if(whereTo.x==coords.x+1||whereTo.x==coords.x-1)
				return true;
		}
		return false;
	}

}
