import java.util.*;

public class week3and4 {

    // Linear Search (first occurrence)
    static void linearSearch(String arr[], String target)
    {
        int first=-1;
        int last=-1;
        int comparisons=0;

        for(int i=0;i<arr.length;i++)
        {
            comparisons++;

            if(arr[i].equals(target))
            {
                if(first==-1)
                    first=i;

                last=i;
            }
        }

        System.out.println("Linear Search:");

        if(first!=-1)
        {
            System.out.println("First occurrence index: "+first);
            System.out.println("Last occurrence index: "+last);
        }
        else
        {
            System.out.println("Not found");
        }

        System.out.println("Comparisons: "+comparisons);
    }

    // Binary Search
    static int binarySearch(String arr[],String target)
    {
        int low=0;
        int high=arr.length-1;

        int comparisons=0;

        while(low<=high)
        {
            int mid=(low+high)/2;

            comparisons++;

            if(arr[mid].equals(target))
            {
                System.out.println("\nBinary Search:");
                System.out.println("Found at index: "+mid);
                System.out.println("Comparisons: "+comparisons);

                return mid;
            }
            else if(arr[mid].compareTo(target)<0)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        System.out.println("Not found");
        return -1;
    }

    // Count duplicates after binary search
    static void countOccurrences(String arr[],String target,int index)
    {
        if(index==-1)
            return;

        int count=1;

        int left=index-1;

        while(left>=0 && arr[left].equals(target))
        {
            count++;
            left--;
        }

        int right=index+1;

        while(right<arr.length && arr[right].equals(target))
        {
            count++;
            right++;
        }

        System.out.println("Total occurrences: "+count);
    }

    public static void main(String args[])
    {

        String logs[]=
                {
                        "accB",
                        "accA",
                        "accB",
                        "accC"
                };

        // Linear search (unsorted)
        linearSearch(logs,"accB");

        // Sort for binary search
        Arrays.sort(logs);

        System.out.println("\nSorted Logs:");

        for(String s:logs)
            System.out.println(s);

        int index=binarySearch(logs,"accB");

        countOccurrences(logs,"accB",index);

    }
}