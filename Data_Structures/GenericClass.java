public class GenericClass <T extends Number, V> {
    T x;
    V y;

    GenericClass(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public T getValue() {return x;}
    public V getKey() {return y;}
}
