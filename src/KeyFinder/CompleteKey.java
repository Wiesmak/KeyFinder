package KeyFinder;

import java.util.Arrays;

class CompleteKey extends Key {
    public CompleteKey(String key) {
        super(key);
    }

    public boolean checkKey() {
        return
                this.keyArray.length == 5 &&
                Arrays.stream(this.keyArray).allMatch(k -> k.length() == 5);
    }
}
