package KeyFinder;

abstract class Key {
    protected String key;
    protected String[] keyArray;

    public Key(String key) {
        final String k = key.toUpperCase();
        this.key = k;
        this.keyArray = k.split("-");
    }

    @Override
    public String toString() {
        return this.key;
    }
}
