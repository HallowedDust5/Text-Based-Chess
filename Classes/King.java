package Classes;

public class King extends Piece{
	


	public King(String n, int x, int y){
		super(x,y,n);
	}

	public boolean pieceLogic(Piece[][] board, Vector whereTo) {
		if(this.dist(whereTo)!=0)
			return false;
		return true;
	}


}
