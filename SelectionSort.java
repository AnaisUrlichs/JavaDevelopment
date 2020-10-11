/**
 * Selection Sort 
 *
 * @author Anais Urlichs
 * @version 1.0
 */
public class SelectionSort
{
    public static int[] selectionSort (int[] numbers) {
        int t;
        
        t = 0;
        do {
            int smallest = findSmallestNumberIndex(numbers, t);
            swap (numbers, t, smallest);
            t = t +1;
        } while (t != numbers.length);
        
        return numbers;
    }
    
    public static int findSmallestNumberIndex (int[] array, int start) {
        int smallest = start;
        
        for (int current = smallest; current < array.length; current +=1) {
            if (array[current] < array[smallest]) {
                smallest=current;
            }
        }
        
        return smallest;
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
        int[] result = selectionSort(numbers);
        int[] expected = {2, 3, 4, 5, 8};
        testEqualIntArrays(result, expected);
        System.out.println(arrayToString(result));
    }
}
