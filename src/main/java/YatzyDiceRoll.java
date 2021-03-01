import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.reducing;

public class YatzyDiceRoll {
	
	private static final List<Integer> SMALL_STRAIGHT_ORDERED_LIST = asList(1, 2, 3, 4, 5);
	private static final List<Integer> LARGE_STRAIGHT_ORDERED_LIST = asList(2, 3, 4, 5, 6);
	
	private static final Collector<Integer, ?, Integer> COUNTING_INTEGER = reducing(0, m -> 1, Integer::sum);

	private final List<Integer> dice;

	public YatzyDiceRoll(int d1, int d2, int d3, int d4, int d5) {
		this.dice = asList(d1, d2, d3, d4, d5);
	}

	public YatzyDiceRoll(List<Integer> dice) {
		this.dice = dice;
	}

	public Map<Integer, Integer> counts() {
		return dice.stream().collect(groupingBy(identity(), COUNTING_INTEGER));
	}

	private List<Integer> sort() {
		return dice.stream().sorted().collect(toList());
	}

	public int sum() {
		return dice.stream().mapToInt(Integer::intValue).sum();
	}

	public boolean isYatzy() {
		return counts().values().stream().anyMatch(count -> count == 5);
	}

	public boolean isNotYatzy() {
		return !isYatzy();
	}

	private Stream<Integer> filterNumberOfDiceGreaterThan(int givenNumber) {
		return counts().entrySet().stream().filter(entry -> entry.getValue() >= givenNumber).map(Entry::getKey);
	}

	public List<Integer> findPairs() {
		return filterNumberOfDiceGreaterThan(2).sorted(reverseOrder()).collect(toList());
	}

	public int getDiceWithCountGreaterThan(int givenNumber) {
		return filterNumberOfDiceGreaterThan(givenNumber).findFirst().orElse(0);
	}

	public int countDice(int dice) {
		return counts().getOrDefault(dice, 0);
	}

	public boolean isSmallStraight() {
		return sort().equals(SMALL_STRAIGHT_ORDERED_LIST);
	}

	public boolean isLargeStraight() {
		return sort().equals(LARGE_STRAIGHT_ORDERED_LIST);
	}

	public boolean isFullHouse() {
		boolean hasThreeOfAKind = getDiceWithCountGreaterThan(3) != 0;
		boolean hasPair = !findPairs().isEmpty();
		return hasThreeOfAKind && hasPair && isNotYatzy();
	}
}
