package Classes;

public class Pawn extends Piece{
	
	public Pawn(String n, int x, int y){
		super(x,y,n);
	}



	public boolean pieceLogic(Piece [][] board, Vector whereTo){
		if(this.getBorw()) {
			if(this.dist(whereTo)==0&&whereTo.x>coords.x)
				return true;
		}
		else {
			if(this.dist(whereTo)==0&&whereTo.x<coords.x)
				return true;
		}
		return false;

	}

}
