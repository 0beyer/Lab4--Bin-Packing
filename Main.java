import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = {6, 5, 9, 11, 15, 14};
        printArray(array);
        int binSize = sizeInput();
        binPackApprox(array, binSize);
    }

    public static void binPackApprox(int[] array, int binSize) {
        Arrays.sort(array);
        ArrayList<Integer> arr = fillArray(array);
        ArrayList<Integer> trashBin = new ArrayList<Integer>();
        ArrayList<Integer> bin1 = new ArrayList<Integer>();
        ArrayList<Integer> bin2 = new ArrayList<Integer>();
        ArrayList<Integer> bin3 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> binArrayList = new ArrayList<>(Arrays.asList(bin1,bin2,bin3,trashBin));

        // checks that any elements larger than the bin size will fit in the bin
        while (arr.get(arrSizeMin1(arr)) > binSize) {
            elementTransfer(arrSizeMin1(arr), arr, binArrayList, 3);
        }

        for (int i = 0; i < binArrayList.size() - 1; i++) {
            Integer temp = arr.get(arrSizeMin1(arr));
            elementTransfer(arrSizeMin1(arr), arr, binArrayList, i);    

            // Checks if the sum of the last two arrays fit in the bin, 
            // then adds them to the bin
            while ((temp + arr.get(arrSizeMin1(arr))) < binSize) {
                temp += arr.get(arrSizeMin1(arr));
                elementTransfer(arrSizeMin1(arr), arr, binArrayList, i);
            }

            // Checks if the first and last elements of the array fit in the bin 
            // and then adds them
            
            while (!(arr.isEmpty())) {
                if((temp + arr.get(0)) <= (binSize))
                {
                    temp += arr.get(0);
                    elementTransfer(0, arr, binArrayList, i);
                }
                else
                {
                    break;
                }
                
            }
        }

        for (int i = 0; i < arr.size(); i++) {
            elementTransfer(i, arr, binArrayList, 3);
        }

        System.out.println(" ");
        for (int i = 0; i < binArrayList.size() - 1; i++) {
            System.out.print("Bin " + (i + 1) + ": ");
            printArrayList(binArrayList.get(i));
            System.out.print(" Empty Space: " + binSpaceEmpty(binArrayList, i, binSize));
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.print("Leftover Arr: ");
        printArrayList(binArrayList.get(3));
        System.out.println(" ");
        System.out.println("Leftovers Total: " + binSum(binArrayList,3));
        System.out.println(" ");
        return;
    }

    // a function that will transfer an element of one array to another
    public static void elementTransfer(int element, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> binArrayList, int binNumber) {
        binArrayList.get(binNumber).add(arr.get(element));
        arr.remove(element);  
    }

    public static int lastElement(ArrayList<Integer> arr) {
        int n = arr.get(arr.size() - 1);
        return n;
    }

    // helper function that returns the size of the array - 1
    public static int arrSizeMin1(ArrayList<Integer> arr) {
        int n = arr.size() - 1;
        return n;
    }

    public static void printArray(int[] array) {
        System.out.print("Given Array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    // will fill an array into an array list
    public static ArrayList<Integer> fillArray(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static int sizeInput() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Bin Size: ");
            return sc.nextInt();
        }
    }

    public static void printArrayList(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static int binSum(ArrayList<ArrayList<Integer>> arr, int binNumber) {
        int n = 0;
        for (int i = 0; i < arr.get(binNumber).size(); i++) {
            n = n + arr.get(binNumber).get(i);
        }
        return n;
    }

    public static int binSpaceEmpty(ArrayList<ArrayList<Integer>> arr, int binNumber, int binSpace) {
        int n = binSpace - binSum(arr, binNumber);
        return n;
    }
}
