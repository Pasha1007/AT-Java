package task2;

public class Task2 {

    public String concatenateUsingConcat(String firstWord, String secondWord) {
        return firstWord.concat(" ").concat(secondWord);
    }

    public String concatenateUsingPlus(String firstWord, String secondWord) {
        return firstWord + " " + secondWord;
    }

    public String concatenateUsingStringBuilder(String firstWord, String secondWord) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstWord).append(" ").append(secondWord);
        return sb.toString();
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        String result1 = task2.concatenateUsingConcat("Hello", "world");
        String result2 = task2.concatenateUsingPlus("Hello", "world");
        String result3 = task2.concatenateUsingStringBuilder("Hello", "world");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}

//V 6: String Concatenation
//Objective: To understand and use string concatenation in Java.
//Instructions:
//Declare two String variables.
//Concatenate the two Strings and store the result in a third String variable.
//Print the result to the console.
