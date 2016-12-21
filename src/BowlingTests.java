import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class BowlingTests {
	
	Frame frame;
	Game game;
	
	@Test
	public void insertScoreToFrame(){
		frame = new Frame();
		frame.insertRolls(4, 0);
		assertThat(frame.getFramescore(), is(4));
	}
	

	@Test
	public void emptyFrameScoreIsNull(){
		frame = new Frame();
		assertThat(frame.getFramescore(), is(0));
	}
	
	@Test
	public void detectStrike(){
		frame = new Frame();
		frame.insertRolls(10, 0);
		assertThat(frame.isStrike(), is(true));
	}

	@Test
	public void detectSpare(){
		frame = new Frame();
		frame.insertRolls(7, 3);
		assertThat(frame.isSpare(), is(true));
	}
	
	@Test
	public void gameHas9Frames(){
		game = new Game();
		assertThat(game.getFrames().size(), is(9));
	}
	

	@Test
	public void gamescoreStartsAtZero(){
		game = new Game();
		assertThat(game.getGamescore(), is(0));
	}


	@Test
	public void calculatesCorrectGamescore(){
		game = new Game();
		game.getFrames().get(0).insertRolls(4, 5);
		game.getFrames().get(1).insertRolls(10, 0);
		assertThat(game.getGamescore(), is(19));
	}
	
}
