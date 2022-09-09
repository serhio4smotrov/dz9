package Collections.MyLinkedList;

public class MyLinked<E> {
    int size = 0;//размер списка
    private Node<E> first;//первый узел списка
    private Node<E> last;//последний узел списка

    public static void main(String[] args) {
        MyLinked<String> linked = new MyLinked<>();
        linked.addFirst("зовут");
        linked.addFirst("меня");
        linked.addLast("счастливый");
        linked.addLast("я");
        linked.addOnIndex(1,"Сергей");
        linked.removeOnIndex(1);
        System.out.println(linked.getOnIndex(0));
        System.out.println(linked.getOnIndex(1));
        System.out.println(linked.getOnIndex(2));
      //  System.out.println(linked.getOnIndex(3));
        System.out.println(linked.getSize());
    }
    public int getSize(){return size;}
    public void removeOnIndex(int index){
        Node<E> r = first;
        for (int i=0;i<index;i++){
            r = r.nextElement;
        }
        Node<E> next = r.nextElement;//объявляем узел next и присваеваем ему ссылку на следующий узел от узла найденного по индексу
        Node<E> prev = r.prevElement;//объявляем узел prev и присваеваем ссылку на предыдущий узел
        if (prev == null) {//выясняем первый ли в списке нужный нам элемент, если да, то
            first = next;//первому узлу присваиваем узел следующий за найденным нами выше, так нужный нам узел выпадает из списка
        }
        else {             // иначе искомый узел находится в середине или в конце
            prev.nextElement = next;//присваиваем ссылке на следующий узел предыдущей ссылке искомого узла следующий узел искомого узла
            r.prevElement = null;   // искомому узлу стираем ссылку на предыдущий
        }
        if (next == null){ //проверяем, что наш узел находится в конце, если да то
            last = prev;   //последнему присваиваем предыдущий узел искомого
        }
        else {                //иначе
            next.prevElement = prev;//по аналогии с предыдущим условием
            r.nextElement = null;
        }
        r.element = null;//стираем сам элемент искомого узла
        size--;//дикрементируем размер
    }
    public void addOnIndex(int index,E e){
        Node<E> s = first;
        for (int i=0;i<index;i++){
            s = s.nextElement;
        }
        s.element = e;
    }
    public void addFirst(E e) {
        Node<E> g = first; //объявляем новый узел и присваиваем ему первый узел first
        Node<E> newNode = new Node<>(null,e,g);//создаем новый узел, ссылка на предыдущий узел null, сам элемент, ссылка на следующий узел указывает на g=first
        first = newNode; //первому узлу присваеваем новый узел, созданный выше
        if (g==null)     //условие если первый узел пустой, тогда последнему узлу присвоить newNode, иначе ссылке на предыдущий узел узла g присвоить новый узел с новоприбывшим элементом
            last = newNode;
        else
            g.prevElement = newNode;
        size++; //размер списка увеличивается на один в связи добавлением нового элемента
    }
    public void addLast(E e) {
        Node<E> f = last;
        Node<E> newNode = new Node<>(f,e,null);
        last = newNode;
        if (f==null)
            first = newNode;
        else
            f.nextElement = newNode;
        size++;
    }
    public E getOnIndex (int index){
        Node<E> s = first;
        for (int i=0;i<index;i++){
            s = s.nextElement;
        }
        return s.element;
    }
    private static class Node<E> {
        private E element;//значение элемента в списке
        private Node<E> nextElement;//ссылка на последующий элемент в списке
        private Node<E> prevElement;//ссылка на предыдущий элемент в списке

        private Node(Node<E> prevElement,E element,Node<E> nextElement) {//конструктор для узлов
            this.element = element;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }
    }
}
