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
		gamescore == 0;
		for (int i = 0; i < frames.size(); i++) {

			switch (i) {
			case 7:
				if (this.getFrames().get(i).isStrike()) {
					this.gamescore += calcEightStrke();
				} else if (this.getFrames().get(i).isSpare()) {
					this.gamescore += calcSpare(i);
				} else {
					this.gamescore += this.frames.get(i).getFramescore();
				}
				break;
			case 8:
				if (this.getFrames().get(i).isStrike()) {
					this.gamescore += calcNinthStrike();
				} else if (this.getFrames().get(i).isSpare()) {
					this.gamescore += calcNinthSpare();
				} else {
					this.gamescore += this.frames.get(i).getFramescore();
				}
				break;
			case 9:
				if (this.getFrames().get(i).isStrike()) {
					this.gamescore += calcExtraStrike();
				} else if (this.getFrames().get(i).isSpare()) {
					this.gamescore += calcExtraSpare();
				} else {
					this.gamescore += this.frames.get(i).getFramescore();
				}
				break;
			default:
				if (this.getFrames().get(i).isStrike()) {
					this.gamescore += calcStrike(i);
				} else if (this.getFrames().get(i).isSpare()) {
					this.gamescore += calcSpare(i);
				} else {
					this.gamescore += this.frames.get(i).getFramescore();
				}
				break;
			}

		}
	}

	private int calcEightStrke() {
		// TODO Auto-generated method stub
		if (this.getFrames().get(9).isSpare() || this.getFrames().get(9).isStrike()) {
			return this.getFrames().get(7).getFramescore() + this.getFrames().get(8).getFramescore()
					+ this.getFrames().get(9).getFirstroll().getRollscore();
		} else {
			return this.getFrames().get(7).getFramescore() + this.getFrames().get(8).getFramescore()
					+ this.getFrames().get(9).getFramescore();
		}
	}

	private int calcNinthSpare() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if (this.getFrames().get(9).isSpare() || this.getFrames().get(9).isStrike()) {
			return this.getFrames().get(8).getFramescore() + this.getFrames().get(9).getFirstroll().getRollscore()
					+ this.getFrames().get(9).getSecondroll().getRollscore();
		} else {
			return this.getFrames().get(8).getFramescore() + this.getFrames().get(9).getFramescore();
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
