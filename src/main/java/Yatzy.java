import static java.util.Arrays.asList;

import java.util.List;
import java.util.stream.IntStream;

public class Yatzy {

	private final List<Integer> dice;

	public Yatzy(int d1, int d2, int d3, int d4, int d5) {
		this.dice = asList(d1, d2, d3, d4, d5);
	}

	public static int chance(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).sum();
	}

	public static int yatzy(int... dice) {
		return IntStream.of(dice).allMatch(dieNumber -> dieNumber == dice[0]) ? 50 : 0;
	}

	public static int ones(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).countDice(1);
	}

	public static int twos(int d1, int d2, int d3, int d4, int d5) {
		return 2 * new YatzyDiceRoll(d1, d2, d3, d4, d5).countDice(2);
	}

	public static int threes(int d1, int d2, int d3, int d4, int d5) {
		return 3 * new YatzyDiceRoll(d1, d2, d3, d4, d5).countDice(3);
	}

	public int fours() {
		return 4 * new YatzyDiceRoll(dice).countDice(4);
	}

	public int fives() {
		return 5 * new YatzyDiceRoll(dice).countDice(5);
	}

	public int sixes() {
		return 6 * new YatzyDiceRoll(dice).countDice(6);
	}

	public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
		List<Integer> pairs = new YatzyDiceRoll(d1, d2, d3, d4, d5).findPairs();
		return pairs.isEmpty() ? 0 : pairs.get(0) * 2;
	}

	public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
		List<Integer> pairs = new YatzyDiceRoll(d1, d2, d3, d4, d5).findPairs();
		return pairs.size() > 1 ? pairs.stream().mapToInt(pair -> pair * 2).sum() : 0;
	}

	public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).getDiceWithCountGreaterThan(4) * 4;
	}

	public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).getDiceWithCountGreaterThan(3) * 3;
	}

	public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).isSmallStraight() ? 15 : 0;
	}

	public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
		return new YatzyDiceRoll(d1, d2, d3, d4, d5).isLargeStraight() ? 20 : 0;
	}

	public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
		YatzyDiceRoll roll = new YatzyDiceRoll(d1, d2, d3, d4, d5);
		return roll.isFullHouse() ? roll.sum() : 0;
	}
}
