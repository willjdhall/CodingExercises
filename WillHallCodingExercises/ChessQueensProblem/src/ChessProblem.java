import java.io.IOException;
import java.util.ArrayList;

public class ChessProblem {
	static ArrayList<QueenPiece> queenPieces = new ArrayList<QueenPiece>();
	
	public static void main(String[] args) throws IOException{
		System.out.println("Please enter the coordinates of the Queen Pieces");
		String input = System.console().readLine();
		
		String[] inputSplits = input.split(" ");
		
		for(String coordinate : inputSplits){
			queenPieces.add(new QueenPiece(coordinate));
		}
		
		//Treat each piece as both a target and attacker, but never check if they can attack themselves
		for(QueenPiece attacker : queenPieces){
			for(QueenPiece target : queenPieces){
				if(attacker != target){
					attacker.canPieceAttackTarget(target);
				}
			}
		}
		
		//Output the first piece that would be unsafe based on order of input and end program
		for(QueenPiece q: queenPieces){
			if(!q.safe){
				System.out.println(q.xPosition + "," + q.yPosition);
				System.exit(0);
			}
		}
		
		System.out.println(true);
	}
}
