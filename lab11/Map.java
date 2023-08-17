/**
 * Map class file.
 * Written by Hydreesia.
 */

public class Map<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int count;

    @SuppressWarnings("unchecked")
    public Map(int length) {
        if (length <= 0) {
            length = 1;
        }
        keys = (Key[]) new Object[length];
        values = (Value[]) new Object[length];
    }

    public boolean isEqual(Key leftKey, Key rightKey) {
        if (leftKey == null || rightKey == null) {
            return leftKey == rightKey;
        } else {
            return leftKey.equals(rightKey);
        }
    }

    private int getIndex(Key key) {
        if (key == null) {
            for (int i = 0; i < count; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < count; i++) {
                if (isEqual(keys[i], key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Value get(Key key) {
        for (int i = 0; i < keys.length; i++) {
            if (isEqual(keys[i], key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean containsKey(Key key) {
        if (getIndex(key) == -1) {
            return false;
        }
        return true;
    }

    /**
     * Replaces a value if its key is already in the array,
     * And adds a new key-value pair if it is not.
     * Additionally increases the array size if the array reaches its max length.
     */
    @SuppressWarnings("unchecked")
    public void put(Key key, Value value) {
        int index = getIndex(key);
        if (index >= 0) {
            values[index] = value;
        } else {
            if (count == keys.length) {
                int newLength = keys.length * 2;
                Key[] newKeys = (Key[]) new Object[newLength];
                Value[] newValues = (Value[]) new Object[newLength];
                for (int i = 0; i < keys.length; i++) {
                    newKeys[i] = keys[i];
                    newValues[i] = values[i];
                }
                keys = newKeys;
                values = newValues;
            }
            keys[count] = key;
            values[count] = value;
            count++;
        }
    }

    public int size() {
        return count;
    }
}
