package task2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Task2Test {

    @DataProvider(name = "stringConcatenationData")
    public Object[][] stringConcatenationData() {
        return new Object[][] {
                {"Hello", "World", "Hello World"},
                {"Goodbye", "World", "Goodbye World"},
                {"World", "Good", "World Good"}
        };
    }

    @Test(dataProvider = "stringConcatenationData")
    public void testConcatenateUsingConcat(String firstWord, String secondWord, String expectedConcat) {
        Task2 task2 = new Task2();
        String result = task2.concatenateUsingConcat(firstWord, secondWord);
        assertEquals(result, expectedConcat, "Concatenation using concat() failed");
    }

    @Test(dataProvider = "stringConcatenationData")
    public void testConcatenateUsingPlus(String firstWord, String secondWord, String expectedConcat) {
        Task2 task2 = new Task2();
        String result = task2.concatenateUsingPlus(firstWord, secondWord);
        assertEquals(result, expectedConcat, "Concatenation using '+' failed");
    }

    @Test(dataProvider = "stringConcatenationData")
    public void testConcatenateUsingStringBuilder(String firstWord, String secondWord, String expectedConcat) {
        Task2 task2 = new Task2();
        String result = task2.concatenateUsingStringBuilder(firstWord, secondWord);
        assertEquals(result, expectedConcat, "Concatenation using StringBuilder failed");
    }
}
