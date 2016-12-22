package Back_End;

public class Frame {

	private int framescore = 0;
	private Roll firstroll;
	private Roll secondroll;

	private boolean strike = false;
	private boolean spare = false;



	public void insertRolls(int firstroll, int secondroll) {
		this.firstroll.setRollscore(firstroll);
		this.secondroll.setRollscore(secondroll);
		this.calcFramescore();
		this.setStrike(firstroll);
		this.setSpare(this.getFramescore());
	}
	

	public Frame() {
		this.firstroll = new Roll();
		this.secondroll = new Roll();
		this.calcFramescore();
	}
	


	public int getFramescore() {
		// TODO Auto-generated method stub
		return framescore;
	}

	private void calcFramescore() {
		// TODO Auto-generated method stub
		this.framescore = this.firstroll.getRollscore() + this.secondroll.getRollscore();
	}
	
	public void setFramescore(int framescore) {
		this.framescore = framescore;
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

		public int getRollscore() {
			return rollscore;
		}

		public void setRollscore(int rollscore) {
			this.rollscore = rollscore;
		}
		
		
	}

}
