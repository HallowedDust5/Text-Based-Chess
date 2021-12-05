package Classes;

public abstract class Piece {
	Vector coords = new Vector();
	String name;
	char pieceType;
	//borw is black or white (b or w)
		//True is capitals, false is lowercase
	private boolean borw=false;
	
	//Constructors
	public Piece(int x, int y, String n) {
		coords.x=x;
		coords.y=y;
		name=n;
	}

	
	
	//Accessor Methods
	public Vector getCoords() {
		return coords;
	}
	public String getName() {
		return name;
	}
	public char getPieceType(){
		return pieceType;
	}
	public boolean getBorw() {
		return borw;
	}

	
	
	
	//Mutator Methods
	public void setBorw() {
		if(name.charAt(0)=='B'||name.charAt(0)=='H'||name.charAt(0)=='K'||name.charAt(0)=='P'||name.charAt(0)=='Q'||name.charAt(0)=='R') 
				borw=true;
	}
	public void setPieceType(char p) {
		pieceType=p;
	}
	public void setCoords(Vector coor) {
		coords=coor;
	}

	//Says if coords are out of bounds
	private boolean isOutOfBounds(Vector v){
		return (v.x+ coords.x<0 && v.x+ coords.x>8)||(v.y+ coords.y<0 && v.y+ coords.y>8);
	}

	public abstract boolean pieceLogic(Piece [][] board, Vector whereTo);

	//This method checks the distance of where the piece is moving
	//Returns number of tiles between piece and whereTo
	public int dist(Vector whereTo) {
		Vector disp_vec = whereTo.sub(coords);
		if(isOutOfBounds(disp_vec)){
			return -1;
		}
		return (int)disp_vec.mag()-1;
	}
	
	//Methods that check whether or not the piece can move there
	
		//Diagonals
	public int ifTopRight(Piece [][] b) {
		int count=0;
		for(int i=coords.x+1, j=coords.y-1; i<b[0].length&&j<b.length;i--,j++) {
			if(i>=8||j<=-1)
				return -1;
			if(b[i][j]!=null) 
				return count;
			count++;
		}
		return -1;
	}
	public int ifTopLeft(Piece [][] b) {
		int count=0;
		for(int i=coords.x-1, j=coords.y-1; i<b[0].length&&j<b.length;i--,j--) {
			if(i<=-1||j<=-1)
				return -1;
			if(b[i][j]!=null) 
				return count;
			count++;
		}
		return -1;
	}
	public int ifBotRight(Piece [][] b) {
		int count=0;
		for(int i=coords.x+1, j=coords.y+1; i<b[0].length&&j<b.length;i++,j++) {
			if(i>=8||j>=8)
				return -1;
			if(b[i][j]!=null) 
				return count;
			count++;
		}
		return -1;
	}

	public int ifBotLeft(Piece [][] b) {
		int count=0;
		for(int i=coords.x+1, j=coords.y-1; i<b[0].length&&j<b.length;i++,j--) {
			if(i>=8||j<=-1)
				return -1;
			if(b[i][j]!=null) 
				return count;
			count++;
		}
		return -1;
	}
	
	public int ifUp(Piece [][] board) {
		int count=0;
		for(int i=coords.x-1;i>-1;i--) {
			if(i<=-1)
				return -1;
			if(board[i][coords.y]!=null)
				return count;
			count++;
		}
		return -1;
	}
	public int ifDown(Piece [][] board) {
		int count=0;
		for(int i=coords.x+1;i<8;i++) {
			if(i>=8)
				return -1;
			if(board[i][coords.y]!=null)
				return count;
			count++;
		}
		return -1;
	}
	public int ifLeft(Piece [][] board) {
		int count=0;
		for(int i=coords.y-1;i>-1;i--) {
			if(i<=-1)
				return -1;
			if(board[coords.x][i]!=null)
				return count;
			count++;
		}
		return -1;
	}
	public int ifRight(Piece [][] board) {
		int count=0;
		for(int i=coords.y+1;i<8;i++) {
			if(i>=8)
				return -1;
			if(board[coords.x][i]!=null)
				return count;
			count++;
		}
		return -1;
	}
	
	public String toString() {
		return name;
	}
}



