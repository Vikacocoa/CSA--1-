import java.io.* ;
import java.util.Scanner;

public class Sorts
{
    /**
     * Gets the first ten and last ten values after the array is sorted.
     */
    public static void getTen(int[] val)
    {
        //Get the ten lowest values of a sorted array
        System.out.println("The 10 lowest values: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(val[i]);
            System.out.print(", ");
        }
        //Get the ten highest values of a sorted array
        System.out.println("The 10 highest values: ");
        for (int i = 1; i < 11; i++)
        {
            System.out.print(val[val.length - i]);
            System.out.print(", ");
        }
    }

    /**
     * Insertion sort
     */
    public static void insertionSort(int arr[]) {
        //Start timer
        long startTime = System.currentTimeMillis();
        int temp, i, newValue, j;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                //Swaps the values, and then runs back through the list it already went through to move values more
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j-1] = temp;
                j--;
            }
            arr[j] = newValue;
        }
        //End timer and figure out the amount of time taken to execute
        long endTime = System.currentTimeMillis();
        long finalTime = (endTime - startTime);
        System.out.println(finalTime);
        System.out.println(arr);
    }

    /**
     * Selection sort
     */
    public static void selectionSort(int arr[]) {
        //Start timer
        long startTime = System.currentTimeMillis();
        int temp, i, j, minIndex;
        //loops through the entire array
        for ( i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swaps the values, making the smallest value get a lower index
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        //End timer and figure out the amount of time taken to execute
        long endTime = System.currentTimeMillis();
        long finalTime = (endTime - startTime);
        System.out.println(finalTime);
        System.out.println(arr);
    }

    /**
     * Merge sort
     */
    public static void mergeSort(int arr[]) {
        //Start timer
        long startTime = System.currentTimeMillis();
        int size, mid, leftSize, rightSize, i;
        int [] left, right;
        size = arr.length;
        //checks to see if the size of the input is one, because then there's nothing to sort
        if (size < 2) {
            return;
        }
        //divides array in 2, with two new arrays made from the two half-lengths created
        mid = size / 2;
        leftSize = mid;
        rightSize = size - mid;
        left = new int[leftSize];
        right = new int[rightSize];
        for (i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (i = mid; i < size; i++) {
            right[i - mid] = arr[i];
        }
        //sorts each half via recursion
        mergeSort(left);
        mergeSort(right);
        //brings both halves together to merge into one new sorted array
        merge(left, right, arr);
        System.out.println(arr);
        //End timer and figure out the amount of time taken to execute
        long endTime = System.currentTimeMillis();
        long finalTime = (endTime - startTime);
        System.out.println(finalTime);
    }

    /**
     * Merge sort helper
     */
    public static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;
        //actually sorts the halves of the original array
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                k++;
                j++;
            }
        }
        //Sorts left side in ascending order
        while (i < leftSize) {
            arr[k] = left[i];
            k++;
            i++;
        }
        //sorts right side in ascending order
        while (j < leftSize) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void algorithmSelection(int[] arr) {

    }

    /**
     * The file to run for sorted arrays
     */
    public static void main () {
        //welcomes user and asks for inputs for files and sort algorithms
        System.out.println("Hello, and welcome to Vikas' Sorting Algorithm.");
        System.out.println("Please input a value from 1 to 3 to choose your sorting algorithm.");
        System.out.println("1 is Insertion Sort, 2 is Selection Sort, and 3 is Merge Sort. Choose Wisely...");
        Scanner numSort = new Scanner(System.in);
        int numInput = numSort.nextInt();

        System.out.println("Please input a value from 1 to 4 to choose your file to sort");
        System.out.println("1 is input1.txt, 2 is input2.txt, 3 is input3.txt, and 4 is input4.txt. Choose Wisely...");
        Scanner fileNum = new Scanner(System.in);
        int fileInput = fileNum.nextInt();

        try {
            int i, j;
            i = 0;
            j=0;
            Scanner fileFind = new Scanner(new File("input" + fileInput + ".txt")).useDelimiter(", ");
            int [] fileScan = new int[j];
            while (fileFind.hasNextInt()) {
                fileScan[i++] = fileFind.nextInt();
            }
            if (numInput == 1) {
                insertionSort(fileScan);

            } else if (numInput == 2) { 
                selectionSort(fileScan);

            } else if (numInput == 3) { 
                mergeSort(fileScan);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
