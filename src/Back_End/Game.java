package Back_End;

import java.util.ArrayList;

public class Game {

	private int gamescore = 0;

	private ArrayList<Frame> frames = new ArrayList<>();

	public Game() {
		setup();
	}

	public void setup() {
		for (int i = 0; i <= 8; i++) {
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

			if (i < frames.size() - 2) {
				if (this.getFrames().get(i).isStrike()) {
					this.getFrames().get(i).setFramescore(calcStrike(i));
				} else if (this.getFrames().get(i).isSpare()) {
					this.getFrames().get(i).setFramescore(calcSpare(i));
				}
			} else if (i < frames.size() - 1) {
				if (this.getFrames().get(i).isSpare()) {
					this.getFrames().get(i).setFramescore(calcSpare(i));
				}
			}
			this.gamescore += this.frames.get(i).getFramescore();
		}
	}

	private int calcSpare(int i) {
		return this.getFrames().get(i).getFramescore() + this.getFrames().get(i + 1).getFramescore();
	}

	private int calcStrike(int i) {
		return this.getFrames().get(i).getFramescore() + this.getFrames().get(i + 1).getFramescore()
				+ this.getFrames().get(i + 2).getFramescore();
	}

}
