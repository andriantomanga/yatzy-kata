import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;

public class YatzyTest {

	@Test
	@DisplayName("Tests for Yatzy#chance")
	void chance() {
		assertAll(
				() -> assertEquals(14, Yatzy.chance(1, 1, 3, 3, 6)),
				() -> assertEquals(21, Yatzy.chance(4, 5, 5, 6, 1)),
				() -> assertEquals(15, Yatzy.chance(2, 3, 4, 5, 1)),
				() -> assertEquals(16, Yatzy.chance(3, 3, 4, 5, 1)));
	}

	@Test
	@DisplayName("Tests for Yatzy#yatzy")
	void yatzy() {
		assertAll(
				() -> assertEquals(50, Yatzy.yatzy(1, 1, 1, 1, 1)), 
				() -> assertEquals(0, Yatzy.yatzy(1, 1, 1, 2, 1)),
				() -> assertEquals(50, Yatzy.yatzy(4, 4, 4, 4, 4)), 
				() -> assertEquals(50, Yatzy.yatzy(6, 6, 6, 6, 6)),
				() -> assertEquals(0, Yatzy.yatzy(6, 6, 6, 6, 3)));
	}

	@Test
	@DisplayName("Tests for Yatzy#ones")
	void ones() {
		assertAll(
				() -> assertEquals(0, Yatzy.ones(3, 3, 3, 4, 5)), 
				() -> assertEquals(1, Yatzy.ones(1, 2, 3, 4, 5)),
				() -> assertEquals(2, Yatzy.ones(1, 2, 1, 4, 5)), 
				() -> assertEquals(0, Yatzy.ones(6, 2, 2, 4, 5)),
				() -> assertEquals(4, Yatzy.ones(1, 2, 1, 1, 1)));
	}

	@Test
	@DisplayName("Tests for Yatzy#twos")
	void twos() {
		assertAll(
				() -> assertEquals(4, Yatzy.twos(2, 3, 2, 5, 1)), 
				() -> assertEquals(4, Yatzy.twos(1, 2, 3, 2, 6)),
				() -> assertEquals(10, Yatzy.twos(2, 2, 2, 2, 2)));
	}

	@Test
	@DisplayName("Tests for Yatzy#threes")
	void threes() {
		assertAll(
				() -> assertEquals(6, Yatzy.threes(1, 2, 3, 2, 3)),
				() -> assertEquals(12, Yatzy.threes(2, 3, 3, 3, 3)));
	}

	@Test
	@DisplayName("Tests for Yatzy#fours")
	void fours() {
		assertAll(
				() -> assertEquals(8, new Yatzy(1, 1, 2, 4, 4).fours()),
				() -> assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours()),
				() -> assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours()),
				() -> assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours()));
	}

	@Test
	@DisplayName("Tests for Yatzy#fives")
	void fives() {
		assertAll(
				() -> assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives()),
				() -> assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives()),
				() -> assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives()));
	}

	@Test
	@DisplayName("Tests for Yatzy#sixes")
	void sixes() {
		assertAll(
				() -> assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes()),
				() -> assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes()),
				() -> assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes()));
	}

	@Test
	@DisplayName("Tests for Yatzy#score_pair")
	void scorePair() {
		assertAll(
				() -> assertEquals(8, Yatzy.score_pair(3, 3, 3, 4, 4)),
				() -> assertEquals(12, Yatzy.score_pair(1, 1, 6, 2, 6)),
				() -> assertEquals(6, Yatzy.score_pair(3, 3, 3, 4, 1)),
				() -> assertEquals(6, Yatzy.score_pair(3, 3, 3, 3, 1)),
				() -> assertEquals(6, Yatzy.score_pair(3, 4, 3, 5, 6)),
				() -> assertEquals(10, Yatzy.score_pair(5, 3, 3, 3, 5)),
				() -> assertEquals(12, Yatzy.score_pair(5, 3, 6, 6, 5)));
	}

	@Test
	@DisplayName("Tests for Yatzy#two_pair")
	void twoPair() {
		assertAll(
				() -> assertEquals(8, Yatzy.two_pair(1, 1, 2, 3, 3)),
				() -> assertEquals(0, Yatzy.two_pair(1, 1, 2, 3, 4)),
				() -> assertEquals(6, Yatzy.two_pair(1, 1, 2, 2, 2)),
				() -> assertEquals(16, Yatzy.two_pair(3, 3, 5, 4, 5)),
				() -> assertEquals(16, Yatzy.two_pair(3, 3, 5, 5, 5)));
	}

	@Test
	@DisplayName("Tests for Yatzy#three_of_a_kind")
	void threeOfAKind() {
		assertAll(
				() -> assertEquals(0, Yatzy.three_of_a_kind(3, 3, 4, 5, 6)),
				() -> assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 1)),
				() -> assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 4, 5)),
				() -> assertEquals(15, Yatzy.three_of_a_kind(5, 3, 5, 4, 5)),
				() -> assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 5)));
	}

	@Test
	@DisplayName("Tests for Yatzy#four_of_a_kind")
	void fourOfAKind() {
		assertAll(
				() -> assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 5)),
				() -> assertEquals(0, Yatzy.four_of_a_kind(2, 2, 2, 5, 5)),
				() -> assertEquals(8, Yatzy.four_of_a_kind(2, 2, 2, 2, 2)),
				() -> assertEquals(12, Yatzy.four_of_a_kind(3, 3, 3, 3, 5)),
				() -> assertEquals(20, Yatzy.four_of_a_kind(5, 5, 5, 4, 5)),
				() -> assertEquals(9, Yatzy.three_of_a_kind(3, 3, 3, 3, 3)));
	}

	@Test
	@DisplayName("Tests for Yatzy#smallStraight")
	void smallStraight() {
		assertAll(
				() -> assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5)),
				() -> assertEquals(15, Yatzy.smallStraight(1, 2, 3, 4, 5)),
				() -> assertEquals(15, Yatzy.smallStraight(2, 3, 4, 5, 1)),
				() -> assertEquals(0, Yatzy.smallStraight(1, 2, 2, 4, 5)));
	}

	@Test
	@DisplayName("Tests for Yatzy#largeStraight")
	void largeStraight() {
		assertAll(
				() -> assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6)),
				() -> assertEquals(20, Yatzy.largeStraight(6, 2, 3, 4, 5)),
				() -> assertEquals(20, Yatzy.largeStraight(2, 3, 4, 5, 6)),
				() -> assertEquals(0, Yatzy.largeStraight(1, 2, 2, 4, 5)));
	}

	@Test
	@DisplayName("Tests for Yatzy#fullHouse")
	void fullHouse() {
		assertAll(
				() -> assertEquals(8, Yatzy.fullHouse(1, 1, 2, 2, 2)),
				() -> assertEquals(0, Yatzy.fullHouse(2, 2, 3, 3, 4)),
				() -> assertEquals(0, Yatzy.fullHouse(4, 4, 4, 4, 4)),
				() -> assertEquals(18, Yatzy.fullHouse(6, 2, 2, 2, 6)),
				() -> assertEquals(0, Yatzy.fullHouse(2, 3, 4, 5, 6)));
	}
}
