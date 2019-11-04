public class QueenPiece {
	public int xPosition;
	public int yPosition;
	public Boolean safe;
	
	public QueenPiece(String coordinate){
		safe = true;
		xPosition = Integer.parseInt(coordinate.substring(0, (coordinate.indexOf(","))));
		yPosition = Integer.parseInt(coordinate.substring(coordinate.indexOf(",")+1, coordinate.length()));
	}
	
	public void canPieceAttackTarget(QueenPiece target){
		this.canAttackTargetVertically(target);
		this.canAttackTargetHorizontally(target);
		this.canAttackTargetToBottomLeft(target);
		this.canAttackTargetToBottomRight(target);
		this.canAttackTargetToTopLeft(target);
		this.canAttackTargetToTopRight(target);
	}
	
	public void canAttackTargetVertically(QueenPiece target){
		target.safe = target.safe && !(target.xPosition == this.xPosition);
	}
	
	public void canAttackTargetHorizontally(QueenPiece target){
		target.safe = target.safe && !(target.yPosition == this.yPosition);
	}
	
	public void canAttackTargetToBottomLeft(QueenPiece target){
		for(int i = 1; i <= this.xPosition; i++){
			if(((this.xPosition-i) == target.xPosition) && ((this.yPosition-i) == target.yPosition)){
				target.safe = target.safe && false;
			}
		}
	}
	
	public void canAttackTargetToBottomRight(QueenPiece target){
		for(int i = 1; (this.xPosition+i) <= 8; i++){
			if(((this.xPosition+i) == target.xPosition) && ((this.yPosition-i) == target.yPosition)){
				target.safe = target.safe && false;
			}
		}
	}
	
	public void canAttackTargetToTopLeft(QueenPiece target){
		for(int i = 1; i <= this.xPosition; i++){
			if(((this.xPosition-i) == target.xPosition) && ((this.yPosition+i) == target.yPosition)){
				target.safe = target.safe && false;
			}
		}
	}
	
	public void canAttackTargetToTopRight(QueenPiece target){
		for(int i = 1; (this.xPosition+i) <= 8; i++){
			if(((this.xPosition+i) == target.xPosition) && ((this.yPosition+i) == target.yPosition)){
				target.safe = target.safe && false;
			}
		}
	}
}
