package upm.tdd.training.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import upm.tdd.training.BowlingException;
import upm.tdd.training.BowlingGame;
import upm.tdd.training.Frame;

public class TestBowlingScoreKeeper {

	Frame[] frameWithoutSpareOrStrike = new Frame[10];
	BowlingGame gameWithoutSpareOrStrike;

	Frame[] frameWithSomeSpare = new Frame[10];
	BowlingGame gameWithSomeSpare;

	Frame[] frameWithSomeStrike = new Frame[10];
	BowlingGame gameWithSomeStrike;

	@Before
	public void initializeTestWithoutSpareOrStrike() throws BowlingException {
		gameWithoutSpareOrStrike = new BowlingGame();
		for (int i = 0; i < frameWithoutSpareOrStrike.length; i++) {
			frameWithoutSpareOrStrike[i] = new Frame(4, 5);
		}
		for (int i = 0; i < frameWithoutSpareOrStrike.length; i++) {
			gameWithoutSpareOrStrike.addFrame(frameWithoutSpareOrStrike[i]);
		}
	}

	@Test
	public void testTotalScoreWithoutSpareOrStrike() throws BowlingException {
		assertEquals(90, gameWithoutSpareOrStrike.score());
	}

	@Before
	public void initializeTestWithSomeSpare() throws BowlingException {
		gameWithSomeSpare = new BowlingGame();
		for (int i = 0; i < frameWithSomeSpare.length; i++) {
			frameWithSomeSpare[i] = new Frame(5, 4);
		}

		// set some random spare
		frameWithSomeSpare[2] = new Frame(5, 5);

		for (int i = 0; i < frameWithSomeSpare.length; i++) {
			gameWithSomeSpare.addFrame(frameWithSomeSpare[i]);
		}
	}

	@Test
	public void testTotalScoreWithSomeSpare() throws BowlingException {
		assertEquals(96, gameWithSomeSpare.score());
	}

	@Before
	public void initializeTestWithSomeStrike() throws BowlingException {
		gameWithSomeStrike = new BowlingGame();
		for (int i = 0; i < frameWithSomeStrike.length; i++) {
			frameWithSomeStrike[i] = new Frame(1, 0);
		}

		// set some random strike
		frameWithSomeStrike[2] = new Frame(10, 0);

		for (int i = 0; i < frameWithSomeStrike.length; i++) {
			gameWithSomeStrike.addFrame(frameWithSomeStrike[i]);
			
		}
	}

	@Test
	public void testTotalScoreWithSomeStrike() throws BowlingException {
		assertEquals(20, gameWithSomeStrike.score());
	}

	@Test(expected = BowlingException.class)
	public void testExceptionBowling() throws BowlingException {
		Frame frame = new Frame(1000, 0);
	}

}
