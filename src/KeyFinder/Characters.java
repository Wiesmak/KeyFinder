package KeyFinder;

import java.util.stream.Stream;

interface Characters {
    Stream<Character> characters = Stream.concat(
        Stream.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'),
        Stream.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    );
}
