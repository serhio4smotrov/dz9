package Collections.MyArrayList;

import java.sql.Array;

public class MyArray<E> implements ArrayMethod<E> {
    private int size = 0;
    private int defaultCapacity = 10;
    Object[] elementData;

    public MyArray() {
        this.elementData = new Object[defaultCapacity];
    }

    public static void main(String[] args) {
        MyArray<String> array = new MyArray<>();
        array.addFirst("s");
        array.addFirst("w");
        array.addFirst("e");
        array.addFirst("t");
        array.addOnIndex(1,"q");
        array.remove(3);
        System.out.println(array.getSize());
        System.out.println(array.getOnIndex(0)+'\n'+array.getOnIndex(1)+'\n'+array.getOnIndex(2));
        System.out.println(array.getOnIndex(3)+'\n'+array.getOnIndex(4));
    }

    @Override
    public void addFirst(E e) {
        grow();
        if (size == 0) {
            elementData[0] = e;
        } else {
            for (int i = 0; i < size; i++) {
                elementData[size - i] = elementData[size - i-1];
            }
            elementData[0] = e;
        }
        size++;
    }

    @Override
    public void remove(int index) {
       for (;index<size;index++) {
           elementData[index] = elementData[index+1];
       }
       elementData[size] = null;
       size--;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public E getOnIndex(int index) {
        return (E) elementData[index];
    }
    @Override
    public void addOnIndex(int index, E e) {
        grow();
        for (int i=0;i<size-index;i++) {
            elementData[size-i] = elementData[size-i-1];
        }
        elementData[index] = e;
        size++;
    }

    @Override
    public void grow() {
        if (size + 1 > defaultCapacity) {
            defaultCapacity = defaultCapacity/2+defaultCapacity+1;
        }
    }
}
