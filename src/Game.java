
import java.util.ArrayList;

public class Game {
	
	private int gamescore = 0;
	
	private ArrayList<Frame> frames = new ArrayList<>();
	
	
	public Game() {
		setup();
	}
	
	public void setup(){
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
		return gamescore;
	}

	private void calcGamescore() {
		for (int i = 0; i < frames.size(); i++) {
			this.gamescore += this.frames.get(i).getFramescore();
		}
	}
	
	
}
