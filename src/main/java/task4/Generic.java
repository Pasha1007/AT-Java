package task4;

import java.util.ArrayList;
import java.util.List;

public class Generic<T> {
    private final List<T> elements;

    public Generic() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public void printElements() {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Generic<Integer> intList = new Generic<>();
        intList.addElement(1);
        intList.addElement(2);
        intList.addElement(3);
        System.out.println("Integer list:");
        intList.printElements();

        Generic<String> stringList = new Generic<>();
        stringList.addElement("Hello");
        stringList.addElement("World");
        System.out.println("String list:");
        stringList.printElements();
    }
}
