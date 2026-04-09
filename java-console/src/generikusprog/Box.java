package generikusprog;

public class Box<T> {
    private T content;

    public void add(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }
}