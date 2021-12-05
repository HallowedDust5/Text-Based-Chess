package Classes;

public class Queen extends Piece{
	
	public Queen(String n, int x, int y){
		super(x,y,n);
	}

	public boolean pieceLogic(Piece[][] board, Vector whereTo) {
		//Horizontal Logic
		if(whereTo.x==coords.x) {
			if(whereTo.y>coords.y) {
				if(this.dist(whereTo)<this.ifRight(board))
					return true;
			}
			else if(whereTo.y<coords.y) {
				if(this.dist(whereTo)-1<this.ifLeft(board))
					return true;
			}
		}
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
		//Diagonal Logic
		else if(this.dist(whereTo)!=-1) {
			if(whereTo.x<coords.x&&whereTo.y>coords.y&&(this.dist(whereTo)<this.ifTopRight(board)||this.ifTopRight(board)==-1))
				return true;
			else if(whereTo.x<coords.x&&whereTo.y<coords.y&&(this.dist(whereTo)<this.ifTopLeft(board)||this.ifTopLeft(board)==-1))
				return true;
			else if(whereTo.x>coords.x&&whereTo.y>coords.y&&(this.dist(whereTo)<this.ifBotRight(board)||this.ifBotRight(board)==-1))
				return true;
			else if(whereTo.x>coords.x&&whereTo.y<coords.y&&(this.dist(whereTo)<this.ifBotLeft(board)||this.ifBotLeft(board)==-1))
				return true;
		}
		return false;
	}


}
