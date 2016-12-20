import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BowlingTests {
	
	Frame frame;
	Game game;
	
	@Test
	public void insertScoreToFrame(){
		frame = new Frame(4,0);
		assertThat(frame.getFramescore(), is(4));
	}
	

	@Test
	public void emptyFrameScoreIsNull(){
		frame = new Frame();
		assertThat(frame.getFramescore(), is(0));
	}
	
	@Test
	public void detectStrike(){
		frame = new Frame(10, 0);
		assertThat(frame.isStrike(), is(true));
	}

	@Test
	public void detectSpare(){
		frame = new Frame(3, 7);
		assertThat(frame.isSpare(), is(true));
	}
	
}
