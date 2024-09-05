//V6.
//Array Intersection: Write a Java program that takes two arrays of integers and finds their intersection.
// Your program should prompt the user to enter the size and the elements of both arrays and then output the common elements between them.

//Make HashSet of doubles from the result array and perform the following operations:
// a)Add an element to the end of the list;
// b)Remove an element from the list;
// c)Replace an element in the list;
// d)Sort the list in alphabetical order;
// e)Print the elements of the list;
//Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.
package task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of the second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }

        ArrayList<Integer> intersection = new ArrayList<>();
        for (int num : array2) {
            if (set1.contains(num)) {
                intersection.add(num);
                set1.remove(num);
            }
        }

        LinkedHashSet<Double> set2 = new LinkedHashSet<>();
        for (int num : intersection) {
            set2.add((double) num);
        }
        System.out.println("The common elements are: " + intersection);

        while (true) {
            System.out.println("\nChoose operation: 1-Add 2-Remove 3-Replace 4-Sort 5-Test exception");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be added: ");
                    Double elementAdd = scanner.nextDouble();
                    set2.add(elementAdd);
                    System.out.print("Updated set: " + set2);
                    break;
                case 2:
                    System.out.print("Enter the element to be removed: ");
                    Double elementRemove = scanner.nextDouble();
                    set2.remove(elementRemove);
                    System.out.print("Updated set: " + set2);
                    break;
                case 3:
                    System.out.print("Enter the element to be replaced: ");
                    Double elementToReplace = scanner.nextDouble();
                    if (set2.contains(elementToReplace)) {
                        set2.remove(elementToReplace);
                        System.out.print("Enter new element: ");
                        Double newElement = scanner.nextDouble();
                        set2.add(newElement);
                        System.out.print("Updated set: " + set2);
                    }else{
                        System.out.println("Element not found");
                        break;
                    }
                    break;
                case 4:
                    List<Double> sortedList = new ArrayList<>(set2);
                    Collections.sort(sortedList);
                    System.out.println("Sorted list: " + sortedList);
                    break;
                case 5:
                    String test = scanner.next();
                    double testElem = Double.parseDouble(test);
                    try {
                        System.out.println(testElem);
                    }catch (NumberFormatException e){
                        System.out.println("Please valid number");
                    }
                    break;
            }
        }
    }
}

