import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BowlingTests {
	
	Frame frame;
	
	@Test
	public void insertScoreToFrame(){
		frame = new Frame(4,0);
		assertThat(frame.getFramescore(), is(4));
	}
	
	
}
