import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("hello");
        linkedList.add("my name");
        linkedList.add("i want to become programmer");
        linkedList.add(2, "Serhio");
        System.out.println(linkedList);
        linkedList.remove(1);
        System.out.println(linkedList);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("hi");
        arrayList.add("i am");
        arrayList.add("Freeman");
        arrayList.add(2, "Gordon");
        System.out.println(arrayList);
        arrayList.remove(3);
        System.out.println(arrayList);
        String f = arrayList.get(2);
        System.out.println(f);
    }
}
