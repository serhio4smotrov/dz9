package Collections.MyLinkedList;

public class MyLinked<E> {
    int size = 0;//������ ������
    private Node<E> first;//������ ���� ������
    private Node<E> last;//��������� ���� ������

    public static void main(String[] args) {
        MyLinked<String> linked = new MyLinked<>();
        linked.addFirst("�����");
        linked.addFirst("����");
        linked.addLast("����������");
        linked.addLast("�");
        linked.addOnIndex(1,"������");
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
        Node<E> next = r.nextElement;//��������� ���� next � ����������� ��� ������ �� ��������� ���� �� ���� ���������� �� �������
        Node<E> prev = r.prevElement;//��������� ���� prev � ����������� ������ �� ���������� ����
        if (prev == null) {//�������� ������ �� � ������ ������ ��� �������, ���� ��, ��
            first = next;//������� ���� ����������� ���� ��������� �� ��������� ���� ����, ��� ������ ��� ���� �������� �� ������
        }
        else {             // ����� ������� ���� ��������� � �������� ��� � �����
            prev.nextElement = next;//����������� ������ �� ��������� ���� ���������� ������ �������� ���� ��������� ���� �������� ����
            r.prevElement = null;   // �������� ���� ������� ������ �� ����������
        }
        if (next == null){ //���������, ��� ��� ���� ��������� � �����, ���� �� ��
            last = prev;   //���������� ����������� ���������� ���� ��������
        }
        else {                //�����
            next.prevElement = prev;//�� �������� � ���������� ��������
            r.nextElement = null;
        }
        r.element = null;//������� ��� ������� �������� ����
        size--;//�������������� ������
    }
    public void addOnIndex(int index,E e){
        Node<E> s = first;
        for (int i=0;i<index;i++){
            s = s.nextElement;
        }
        s.element = e;
    }
    public void addFirst(E e) {
        Node<E> g = first; //��������� ����� ���� � ����������� ��� ������ ���� first
        Node<E> newNode = new Node<>(null,e,g);//������� ����� ����, ������ �� ���������� ���� null, ��� �������, ������ �� ��������� ���� ��������� �� g=first
        first = newNode; //������� ���� ����������� ����� ����, ��������� ����
        if (g==null)     //������� ���� ������ ���� ������, ����� ���������� ���� ��������� newNode, ����� ������ �� ���������� ���� ���� g ��������� ����� ���� � ������������� ���������
            last = newNode;
        else
            g.prevElement = newNode;
        size++; //������ ������ ������������� �� ���� � ����� ����������� ������ ��������
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
        private E element;//�������� �������� � ������
        private Node<E> nextElement;//������ �� ����������� ������� � ������
        private Node<E> prevElement;//������ �� ���������� ������� � ������

        private Node(Node<E> prevElement,E element,Node<E> nextElement) {//����������� ��� �����
            this.element = element;
            this.prevElement = prevElement;
            this.nextElement = nextElement;
        }
    }
}
