import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;
//Imported Piece
import Classes.*;
import java.lang.Integer;

/*How it's gonna be done
 * Each piece will have a number assigned to it in its name, its variable will be the same value as its name
 * 		Each unique piece (king, queen) will have a zero attached
 * Black will be capital letters ex: K, Q
 * White will be lower case ex: k, q
 */

public class Main {

	//Moves the piece if a few conditions are met:
		//Where it's going is null(are empty spaces are null)
		//Where it's going doesn't have a friendly piece
		//It can go there based on its piece logic (above)
	//Returns turnCheck(boolean) because in main, that variable decides whether the turn is over (More explanation in main)
	public static boolean move(Piece board[][],Vector whereTo, Piece p, boolean turnCheck) {
		//Piece logic, and if where it's going is null
			//If this wasn't here there would be a null pointer in the else if
		System.out.println(p.pieceLogic(board,whereTo));
		if(p.pieceLogic(board,whereTo)&&board[whereTo.x][whereTo.y]==null) {
			//Turns the space where the piece occupies null
			board[p.getCoords().x][p.getCoords().y]=null;
			//Turns where it's going to the piece
			board[whereTo.x][whereTo.y]=p;
			//Sets the Piece's coords to whereTo
			p.setCoords(whereTo);
			//Turns turn check to false because of the successful move
			turnCheck=false;
		}
		//Piece logic, if the Piece at whereTo is not on the same side as the Piece that's being moved
		else if(p.pieceLogic(board,whereTo)&&board[whereTo.x][whereTo.y].getBorw()!=p.getBorw()) {

				
			//Sets where it is to null
			board[p.getCoords().x][p.getCoords().y]=null;
			//Sets where it's going to Piece
			board[whereTo.x][whereTo.y]=p;
			//Sets the Piece's coords to whereTo
			p.setCoords(whereTo);
			//Turn check false because of successful move
			turnCheck=false;
		}
		//This is specifically an else because I didn't want to account for ALL the edge cases
		else
			System.out.println("Can't go there");

		
		//Returns turnCheck at the end
		return turnCheck;
	
	}
	//Gives the coords of where a piece with that name is
	//Pretty simple iteration through the board
	public static Vector where(Piece board[][],String name) {
		for(int i=0;i<board[0].length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[j][i]!=null) {
					if(board[j][i].getName().equals(name)) {
						return board[j][i].getCoords();
					}
				}
					
			}
		}
		return new Vector();
	}

	//Prints the board
	public static void printBoard(Piece [][]b) {
		System.out.println("  0  1  2  3  4  5  6  7");
		for(int i=0;i<b.length;i++){
			System.out.print(i+"|");
			for(int j=0; j<b[0].length;j++){
				if(b[i][j]==null)
					System.out.print("  |");
				else
					System.out.print(b[i][j]+"|");
			}
			System.out.println();
		}
	}
	
	
	//Gives the pieces a black or white value
		//True is black, false is white
	public static void makeBorw(Piece [][] b){
		for(int i=0; i<2;i++) {
			for(Piece p:b[i])
				p.setBorw();
		}
		for(int i=b.length-2; i<b.length; i++) {
			for(Piece p: b[i])
				p.setBorw();
		}
	}
	
	//Gives the pieces their piece type
	public static void setPieces(Piece [][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]!=null) 
					board[i][j].setPieceType(board[i][j].getName().toLowerCase().charAt(0));
			}
		}
		
	}


	

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		//Global Variable Instantiation
		boolean blackWin=true;
		boolean whiteWin=true;
		int turnCount=1;
		
		//Remember row major
		//Black is capital, white is lowercase
		Piece[][] board=new Piece [8][8];


		
		//Adding the pieces in
		
		//Capital pieces
			//Special pieces
		board[0][0]= new Rook("R1",0,0);
		board[0][1]= new Horse("H1",0,1);
		board[0][2]= new Bishop("B1",0,2);
		board[0][3]= new Queen("Q0",0,3);
		board[0][4]= new King("K0",0,4);
		board[0][5]= new Bishop("B2",0,5);
		board[0][6]= new Horse("H2",0,6);
		board[0][7]= new Rook("R2",0,7);
			//Pawns
		board[1][0]= new Pawn("P1",1,0);
		board[1][1]= new Pawn("P2",1,1);
		board[1][2]= new Pawn("P3",1,2);
		board[1][3]= new Pawn("P4",1,3);
		board[1][4]= new Pawn("P5",1,4);
		board[1][5]= new Pawn("P6",1,5);
		board[1][6]= new Pawn("P7",1,6);
		board[1][7]= new Pawn("P8",1,7);

		//Lowercase pieces
			//Special Pieces
		board[7][0]= new Rook("r1",7,0);
		board[7][1]= new Horse("h1",7,1);
		board[7][2]= new Bishop("b1",7,2);
		board[7][3]= new King("k0",7,3);
		board[7][4]= new Queen("q0",7,4);
		board[7][5]= new Bishop("b2",7,5);
		board[7][6]= new Horse("h2",7,6);
		board[7][7]= new Rook("r2",7,7);
			//Pawns
		board[6][0]= new Pawn("p1",6,0);
		board[6][1]= new Pawn("p2",6,1);
		board[6][2]= new Pawn("p3",6,2);
		board[6][3]= new Pawn("p4",6,3);
		board[6][4]= new Pawn("p5",6,4);
		board[6][5]= new Pawn("p6",6,5);
		board[6][6]= new Pawn("p7",6,6);
		board[6][7]= new Pawn("p8",6,7);

		//Gives all the pieces a black or white value
		makeBorw(board);
		//Gives them their piece value
		setPieces(board);
		System.out.println("This game is pretty straight forward. Each piece can move the same way it can in"
				+ " regular chess, but without castling and the type of stuff. Pawns can move the same way, BUT they can also move diagonally, "
				+ "but only in the same direction they can move in a regular game.\nThe format is like this:\nMove p2 to 5 1 \nThe query has to be row major and DONT PUT A PERIOD IT WILL MAKE YOU RESTART. Don't put any extra characters onto the important parts (the piece name and the coords)"
				+ "For the most part it should work. Hope you have fun!\n\n------------------------------");
		
		//The blackWin and whiteWin while loop see if either side wins
		//The turnCheck while loop makes sure that each person gets their turn
		//The queryCheck while loop makes sure that the player types the correct thing in
		while(blackWin&&whiteWin) {

			boolean turnCheck=true;
			//The reason there are two major while loops is because if you didn't do your turn properly it would just give it to the other player
			//turnCheck makes sure that the person playing does their move correctly
			while(turnCheck) {
				printBoard(board);
				System.out.println("The format is \"Move *piece* to *row/space/column*\"");
				//Makes sure the query is properly formatted (kinda)
				boolean queryCheck=true;
				//An array that can hold the query's specific format
				String [] splitQuery= new String [5];
				//Goes through a loop if the format isn't correct(Isn't 100% foolproof, only goes off of the number of words)
					while(queryCheck) {
						
						//This is the unedited query that the player puts in, has to follow the above mentioned format
						String query=s.nextLine();
						//Splits the query by what is put into the method(I know that method from python)
						String [] temp=query.split(" ");
						//If there aren't 5 words, it's probably a typo.
						if(temp.length!=5) {
							System.out.println("Make sure there's a space in between the coordinates. \nYour query should look like this: \nMove r1 to 5 0");
						}
						else {
							queryCheck=false;
							//I'm honestly surprised this works
							splitQuery=query.split(" ");
						} 
					}
					//Turns splitQuery into an ArrayList
				ArrayList<String> analyzedQuery= new ArrayList<String>(Arrays.asList(splitQuery));
					//Removes the move and to from the query, could be any word
				analyzedQuery.remove(0);
				analyzedQuery.remove(1);
					//this is the name of the piece
				String pName=analyzedQuery.get(0);
					//Where they want the piece to move to
				Vector whereTo= new Vector(Integer.parseInt(analyzedQuery.get(1)),Integer.parseInt(analyzedQuery.get(2)));
				System.out.println(whereTo);
				//These two statements find out if the piece moved is being moved on the right turn
					//First one makes sure that the lowercase pieces are being used on their turn
				if(turnCount==1&&board[where(board,pName).x][where(board,pName).y].getBorw()==false) {
					//Because class data types update automatically, but primitives don't, I just returned a primitive on move so turnCheck would work nicely and everything else that's passed through is a class data type
					turnCheck=move(board,whereTo,board[where(board,pName).x][where(board,pName).y],turnCheck);
				}
				//This one's for the uppercase
				else if(turnCount==2&&board[where(board,pName).x][where(board,pName).y].getBorw()==true) {
					turnCheck=move(board,whereTo,board[where(board,pName).x][where(board,pName).y],turnCheck);
				}
				//Just like in move(), I used an else statement because I was scared of what edge cases there would be
				else {
					System.out.println("Can't use that piece");
			
				}
			}
	
			//Checks if either king is dead 
			if(where(board,"k0").x==-1)
				whiteWin=false;
			else if(where(board,"K0").x==-1)
				blackWin=false;
			//At the end of each turn, the turnCount goes up one or down one depending on whose turn it just was.
			if(turnCount==1)
				turnCount++;
			else
				turnCount--;

		}
		printBoard(board);
		if(!blackWin)
			System.out.println("Lowercase letters win!");
		else if(!whiteWin)
			System.out.println("Uppercase letters win!");


		
		
	}

}
