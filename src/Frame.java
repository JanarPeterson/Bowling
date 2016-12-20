
public class Frame {

	int framescore = 0;
	Roll firstroll;
	Roll secondroll;

	boolean strike = false;
	boolean spare = false;



	public Frame(int firstroll, int secondroll) {
		this.firstroll = new Roll(firstroll);
		this.secondroll = new Roll(secondroll);
		this.setFramescore();
		this.setStrike(firstroll);
		this.setSpare(this.getFramescore());
	}
	

	public Frame() {
		this.firstroll = new Roll();
		this.secondroll = new Roll();
		this.setFramescore();
	}


	public int getFramescore() {
		// TODO Auto-generated method stub
		return framescore;
	}

	public void setFramescore() {
		// TODO Auto-generated method stub
		this.framescore = this.firstroll.getRollscore() + this.secondroll.getRollscore();
	}
	
	
	public boolean isStrike() {
		return this.strike;
	}


	private void setStrike(int score) {
		this.strike = score == 10;
	}


	public boolean isSpare() {
		return spare;
	}


	private void setSpare(int score) {
		this.spare = score == 10;
	}


	class Roll{
		
		
		public Roll() {

		}

		public Roll(int rollscore) {
			
			this.rollscore = rollscore;
		}

		private int rollscore = 0;

		private int getRollscore() {
			return rollscore;
		}

		private void setRollscore(int rollscore) {
			this.rollscore = rollscore;
		}
		
		
	}

}
