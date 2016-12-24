package Tests;

import org.junit.Test;

import Back_End.Game;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class GameTests {

	public void run() {
		gameHas10Frames();
		gamescoreStartsAtZero();
		calculatesCorrectGamescore();
		calculatesCorrrectStrike();
		calculatesCorrectSpare();
	}

	Game game;

	@Test
	public void gameHas10Frames() {
		game = new Game();
		assertThat(game.getFrames().size(), is(10));
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
	
	@Test
	public void hasExtraRoll(){
		game = new Game();
		game.getFrames().get(9).insertRolls(10, 4);
		game.getFrames().get(9).insertExtraRoll(8);
		assertThat(game.getGamescore(),is(22));
	}
	
	@Test
	public void correctMaxScore(){
		game = new Game();
		game.getFrames().get(0).insertRolls(10, 0);
		game.getFrames().get(1).insertRolls(10, 0);
		game.getFrames().get(2).insertRolls(10, 0);
		game.getFrames().get(3).insertRolls(10, 0);
		game.getFrames().get(4).insertRolls(10, 0);
		game.getFrames().get(5).insertRolls(10, 0);
		game.getFrames().get(6).insertRolls(10, 0);
		game.getFrames().get(7).insertRolls(10, 0);
		game.getFrames().get(8).insertRolls(10, 0);
		game.getFrames().get(9).insertRolls(10, 10);
		game.getFrames().get(9).insertExtraRoll(10);
		assertThat(game.getGamescore(), is(300));
		
	}
}





