package Classes;

public class Rook extends Piece{

	public Rook(String n, int x, int y){
		super(x,y,n);
	}

	public boolean pieceLogic(Piece[][] board, Vector whereTo) {
		//Is it in the same row?
		if(whereTo.x==coords.x) {
			//Determines if it's to the right or left
			if(whereTo.y>coords.y) {
				//If whereTo is
				if(this.dist(whereTo)-1<this.ifRight(board))
					return true;
			}
			else if(whereTo.y<coords.y) {
				if(this.dist(whereTo)-1<this.ifLeft(board))
					return true;
			}
		}
		//Is it in the same column?
		else if(whereTo.y==coords.y) {
			if(whereTo.x>coords.x) {
				if(this.dist(whereTo)-1<this.ifDown(board))
					return true;
			}
			else if(whereTo.x<coords.x) {
				if(this.dist(whereTo)-1<this.ifUp(board))
					return true;
			}
		}
		return false;
	}

}
