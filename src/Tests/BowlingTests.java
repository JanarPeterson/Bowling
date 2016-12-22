package Tests;

import org.junit.Test;


public class BowlingTests {

	@Test
	public void frameFunctionality() {
		FrameTests frametests = new FrameTests();
		frametests.run();
	}

	@Test
	public void gameFunctionality() {
		GameTests gametests = new GameTests();
		gametests.run();
	}

}
