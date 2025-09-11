import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("bleh");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bin size:");
        int binSize = sc.nextInt();
        int[] array = {12, 4, 8, 15, 9, 3, 1, 10};
        Arrays.sort(array);
        ArrayList<Integer> sortedArray = fillArray(array);
        ArrayList<Integer> leftoverArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> binArrayList = new ArrayList<>(Arrays.asList(new ArrayList<Integer>(), new ArrayList<Integer>(), new ArrayList<Integer>()));
        int j = sortedArray.size() - 1;
        while(sortedArray.get(j) > binSize)
        {
            leftoverArray.add(sortedArray.get(j));
            sortedArray.remove(j);
            j--;
        }
        for(int i = 0; i < binArrayList.size(); i++)
        {
            Integer temp = sortedArray.get(j);
            binArrayList.get(i).add(temp);
            sortedArray.remove(j);
            j--;
            int k = 0;
            while((temp + sortedArray.get(k)) < binSize)
            {
                temp += sortedArray.get(k);
                binArrayList.get(i).add(sortedArray.get(k));
                sortedArray.remove(k);
            }
        }
        for(int i = 0; i < sortedArray.size(); i++)
        {
            leftoverArray.add(sortedArray.get(0));
            sortedArray.remove(0);
        }
        for(int i = 0; i < binArrayList.size(); i++)
        {
            printArrayList(binArrayList.get(i));
        }
        printArrayList(leftoverArray);


    }
    public static void printArray(int[] array)
    {
        for(int i : array)
        {
            System.out.println(i);
        }
    }
    public static ArrayList<Integer> fillArray(int[] array)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i : array)
        {
            arrayList.add(i);
        }
        return arrayList;
    }
    public static void printArrayList(ArrayList<Integer> array)
    {
        for(int i = 0; i < array.size(); i++)
        {
            System.out.println(array.get(i));
        }
    }
}
