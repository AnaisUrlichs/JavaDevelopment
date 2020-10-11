
/**
 * This is a bubblesort algorithm
 *
 * @author Anais
 * @version 1.0
 */
public class BubbleSort
{    
    public static int[] bubbleSort (int[] numbers) {
        boolean madeSwaps;
        do {
            madeSwaps = false;
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    swap (numbers, i, i+1);
                    madeSwaps = true;
                }
            }
        }while (madeSwaps);
        
        return numbers;
    }
    
    public static void swap (int[] numbers, int i1, int i2) {
        int temp;
        
        temp = numbers[i1];
        numbers[i1] = numbers[i2];
        numbers[i2] = temp;
    }
    
    public static String arrayToString (int[] array) {
        String result = "";
    
        result += "[";
        for (int i=0; i<array.length; i+=1) {
            result += array[i] + ", ";
        }
        result += "]";
    
        return result;
    }
    
    public static void testEqualIntArrays (int[] result, int[] expected) {
        boolean equalArrays = true;
        
        if (result.length != expected.length) {
            equalArrays = false;
        } else {
            for (int i = 0; i< result.length; i++) 
            {
                if (result[i] != expected[i]) {
                    equalArrays = false;
                }
            }
        }
        
        
        if (!equalArrays) {
            System.out.println ("Error: the result " + arrayToString(result) +
                                " does not equal the expected " + arrayToString(expected));
        }
    }
    
    public static void main (String[] args) {
        int[] numbers = { 2, 5, 3, 8, 4};
        int[] result = bubbleSort(numbers);
        int[] expected = {2, 3, 4, 5, 8};
        testEqualIntArrays(result, expected);
        System.out.println(arrayToString(result));
    }
}
