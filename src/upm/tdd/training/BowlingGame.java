package upm.tdd.training;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	// a bowling game is made of (at least) 10 frames
	private static final int MAX_FRAMES_SIZE = 10;
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;

	public BowlingGame() {
	}

	public void addFrame(Frame frame) throws BowlingException {
		if (frames.size() == MAX_FRAMES_SIZE) {
			throw new BowlingException();
		} else {
			// add new frame to the game
			frames.add(new Frame(frame.getFirstThrow(), frame.getSecondThrow()));

			if (frames.size() > 1) {
				Frame previousFrame = frames.get(frames.size() - 2);

				/*
				 * if frame before the actual was a spare, add to the previous
				 * frame the point of the actual frame's first throw
				 */
				if (previousFrame.isSpare()) {
					previousFrame.addToScore(frame.getFirstThrow());
					
				}

				/*
				 * if frame before the actual was a strike, add to the previous
				 * frame the point of the actual frame's score
				 */
				if (previousFrame.isStrike()) {
					previousFrame.addToScore((frame.getFirstThrow() + frame.getSecondThrow()));
				}
				
				/*
				 * if next frame is bonus, add the point of bonus throw
				 */
				if (isNextFrameBonus()) {
					
				}

				/*
				 * add to the actual frame the current score
				 */
				frames.get(frames.size() - 1).addToScore(previousFrame.score());
			}

		}
	}

	public void setBonus(int firstThrow, int secondThrow) {
		// to be implemented
	}

	// the score of entire game
	public int score() throws BowlingException {
		if (frames.size() != MAX_FRAMES_SIZE) {
			throw new BowlingException();
		} else {
			return frames.get(MAX_FRAMES_SIZE - 1).score();
		}
	}

	public boolean isNextFrameBonus() {

		/* check if exists 9th frame */
		if (frames.size() == MAX_FRAMES_SIZE - 1) {
			Frame actualFrame = frames.get(frames.size() - 1);
			if (actualFrame.isSpare() || actualFrame.isStrike()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
