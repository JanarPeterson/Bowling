
import java.util.ArrayList;

public class Game {
	
	ArrayList<Frame> frames = new ArrayList<>();
	
	
	public Game() {
		setup();
	}
	
	public void setup(){
		for (int i = 0; i <= 8; i++) {
			frames.add(new Frame());
		}
	}
	
	private ArrayList<Frame> getFrames() {
		return frames;
	}
	private void setFrames(ArrayList<Frame> frames) {
		this.frames = frames;
	}
}
