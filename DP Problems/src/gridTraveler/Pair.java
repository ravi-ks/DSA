package gridTraveler;

import java.util.Objects;

public class Pair<T, T1> {
    T item1;
    T1 item2;

    public Pair(T item1, T1 item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public Pair() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(item1, pair.item1) && Objects.equals(item2, pair.item2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item1, item2);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "item1=" + item1 +
                ", item2=" + item2 +
                '}';
    }
}
