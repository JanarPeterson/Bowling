package Tests;

import org.junit.Test;

import Back_End.Game;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GameTests {

	public void run() {
		gameHas9Frames();
		gamescoreStartsAtZero();
		calculatesCorrectGamescore();
		calculatesCorrrectStrike();
		calculatesCorrectSpare();
	}

	Game game;

	@Test
	public void gameHas9Frames() {
		game = new Game();
		assertThat(game.getFrames().size(), is(9));
	}

	@Test
	public void gamescoreStartsAtZero() {
		game = new Game();
		assertThat(game.getGamescore(), is(0));
	}

	@Test
	public void calculatesCorrectGamescore() {
		game = new Game();
		game.getFrames().get(0).insertRolls(4, 5);
		game.getFrames().get(1).insertRolls(10, 0);
		assertThat(game.getGamescore(), is(19));
	}

	@Test
	public void calculatesCorrrectStrike() {
		game = new Game();
		game.getFrames().get(0).insertRolls(4, 5);
		game.getFrames().get(1).insertRolls(10, 0);
		game.getFrames().get(2).insertRolls(6, 2);
		game.getFrames().get(3).insertRolls(6, 4);
		assertThat(game.getGamescore(), is(55));
	}

	@Test
	public void calculatesCorrectSpare() {
		game = new Game();
		game.getFrames().get(0).insertRolls(4, 5);
		game.getFrames().get(1).insertRolls(1, 9);
		game.getFrames().get(2).insertRolls(8, 0);
		assertThat(game.getGamescore(), is(35));
	}

}
