package Collections.MyArrayList;

public interface ArrayMethod<E> {
    void addFirst(E e);
    void remove(int index);
    int getSize();
    E getOnIndex(int index);
    void addOnIndex(int index,E e);
    void grow();
}
