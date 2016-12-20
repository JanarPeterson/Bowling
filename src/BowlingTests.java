import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BowlingTests {
	
	Frame frame = new Frame();
	
	@Test
	public void insertScoreToFrame(){
		frame.setFramescore(1, 6);
		assertThat(frame.getFramescore(), is(7));
	}
}
