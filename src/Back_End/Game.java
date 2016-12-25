package Back_End;

import java.util.ArrayList;

public class Game {

	private int gamescore = 0;

	private ArrayList<Frame> frames = new ArrayList<>();

	public Game() {
		setup();
	}

	public void setup() {
		for (int i = 0; i < 10; i++) {
			frames.add(new Frame());
		}
		this.calcGamescore();
	}

	public ArrayList<Frame> getFrames() {
		return frames;
	}

	private void setFrames(ArrayList<Frame> frames) {
		this.frames = frames;
	}

	public int getGamescore() {
		this.calcGamescore();
		return gamescore;
	}

	private void calcGamescore() {
		for (int i = 0; i < frames.size(); i++) {

			switch (i) {
			case 8:
				if (this.getFrames().get(i).isStrike()) {
					this.getFrames().get(i).setFramescore(calcNinthStrike());
				} else if (this.getFrames().get(i).isSpare()) {
					this.getFrames().get(i).setFramescore(calcSpare(i));
				}
				break;
			case 9:
				if (this.getFrames().get(i).isStrike()) {
					this.getFrames().get(i).setFramescore(calcExtraStrike());
				} else if (this.getFrames().get(i).isSpare()) {
					this.getFrames().get(i).setFramescore(calcExtraSpare());
				}
				break;
			default:
				if (this.getFrames().get(i).isStrike()) {
					this.getFrames().get(i).setFramescore(calcStrike(i));
				} else if (this.getFrames().get(i).isSpare()) {
					this.getFrames().get(i).setFramescore(calcSpare(i));
				}
				break;
			}
			this.gamescore += this.frames.get(i).getFramescore();
		}
	}

	private int calcExtraSpare() {
		// TODO Auto-generated method stub
		return this.getFrames().get(9).getFirstroll().getRollscore()
				+ this.getFrames().get(9).getSecondroll().getRollscore()
				+ this.getFrames().get(9).getExtraroll().getRollscore();
	}

	private int calcExtraStrike() {
		this.getFrames().get(9).setSpare(false);
		// TODO Auto-generated method stub
		return this.getFrames().get(9).getFirstroll().getRollscore()
				+ this.getFrames().get(9).getSecondroll().getRollscore()
				+ this.getFrames().get(9).getExtraroll().getRollscore();
	}

	private int calcNinthStrike() {
		// TODO Auto-generated method stub
		return this.getFrames().get(8).getFramescore() + this.getFrames().get(9).getFirstroll().getRollscore()
				+ this.getFrames().get(9).getSecondroll().getRollscore();
	}

	private int calcSpare(int i) {
		return this.getFrames().get(i).getFramescore() + this.getFrames().get(i + 1).getFramescore();
	}

	private int calcStrike(int i) {
		return this.getFrames().get(i).getFramescore() + this.getFrames().get(i + 1).getFramescore()
				+ this.getFrames().get(i + 2).getFramescore();
	}

}
