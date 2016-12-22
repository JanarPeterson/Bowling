package Tests;

import org.junit.Test;

import Back_End.Frame;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class FrameTests {
	Frame frame;

	public void run() {
		insertScoreToFrame();
		emptyFrameScoreIsNull();
		detectStrike();
		detectSpare();
	}

	@Test
	public void insertScoreToFrame() {
		frame = new Frame();
		frame.insertRolls(4, 0);
		assertThat(frame.getFramescore(), is(4));
	}

	@Test
	public void emptyFrameScoreIsNull() {
		frame = new Frame();
		assertThat(frame.getFramescore(), is(0));
	}

	@Test
	public void detectStrike() {
		frame = new Frame();
		frame.insertRolls(10, 0);
		assertThat(frame.isStrike(), is(true));
	}

	@Test
	public void detectSpare() {
		frame = new Frame();
		frame.insertRolls(7, 3);
		assertThat(frame.isSpare(), is(true));
	}

}
