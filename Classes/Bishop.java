package Classes;

public class Bishop extends Piece {
	

	public Bishop(String n, int x, int y){
		super(x,y,n);
	}

	public boolean pieceLogic(Piece[][] board, Vector whereTo) {
		if(whereTo.x==this.getCoords().x||whereTo.y==this.getCoords().y)
			return false;
		else if(this.dist(whereTo)!=-1) {
			if(whereTo.x<this.getCoords().x&&whereTo.y>this.getCoords().y&&(this.dist(whereTo)<this.ifTopRight(board)||this.ifTopRight(board)==-1))
				return true;
			else if(whereTo.x<this.getCoords().x&&whereTo.y<this.getCoords().y&&(this.dist(whereTo)<this.ifTopLeft(board)||this.ifTopLeft(board)==-1))
				return true;
			else if(whereTo.x>this.getCoords().x&&whereTo.y>this.getCoords().y&&(this.dist(whereTo)<this.ifBotRight(board)||this.ifBotRight(board)==-1))
				return true;
			else if(whereTo.x>this.getCoords().x&&whereTo.y<this.getCoords().y&&(this.dist(whereTo)<this.ifBotLeft(board)||this.ifBotLeft(board)==-1))
				return true;
		}
		return false;
	}

}
