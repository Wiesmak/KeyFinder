package KeyFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class AutoCompletingKey extends IncompleteKey {
    private List<String> possibleSegments;
    public AutoCompletingKey(String key) {
        super(key);
        if (!findIncompleteSegment()) throw new IllegalArgumentException("KeyFinder.Key is complete.");
    }

    public boolean findPossibleSegment() {
        possibleSegments = Characters.characters
            .flatMap(c -> insertCharacter(this.incompleteSegment, c))
            .collect(Collectors.toList());
        return !possibleSegments.isEmpty();
    }

    private Stream<String> insertCharacter(String s, char c) {
        return IntStream.rangeClosed(0, s.length())
            .mapToObj(i -> s.substring(0, i) + c + s.substring(i));
    }

    public List<String> getPossibleKeys() {
        List<String> possibleKeys = new ArrayList<>();
        for (String segment : possibleSegments) {
            possibleKeys.add(
                Arrays.stream(this.keyArray)
                    .map(k -> k.length() == 5 ? k : segment)
                    .collect(Collectors.joining("-"))
            );
        }
        return possibleKeys;
    }
}
