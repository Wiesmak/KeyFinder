package KeyFinder;

import java.util.Arrays;

class IncompleteKey extends Key {
    protected String incompleteSegment;
    public IncompleteKey(String key) {
        super(key);
    }

    public boolean findIncompleteSegment() {
        this.incompleteSegment = Arrays.stream(this.keyArray)
                .filter(k -> k.length() < 5)
                .findFirst()
                .orElse(null);
        return this.incompleteSegment != null;
    }
}
