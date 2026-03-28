import java.util.*;

public class week3and4 {

    // Linear Search (unsorted)
    static void linearSearch(int arr[], int target)
    {
        int comparisons=0;
        boolean found=false;

        for(int i=0;i<arr.length;i++)
        {
            comparisons++;

            if(arr[i]==target)
            {
                System.out.println("Linear Search: Found at index "+i);
                found=true;
                break;
            }
        }

        if(!found)
            System.out.println("Linear Search: Not found");

        System.out.println("Comparisons: "+comparisons);
    }

    // Binary Search insertion position
    static int binaryInsertion(int arr[], int target)
    {
        int low=0;
        int high=arr.length-1;

        int comparisons=0;

        while(low<=high)
        {
            int mid=(low+high)/2;

            comparisons++;

            if(arr[mid]==target)
            {
                System.out.println("\nBinary Search: Found at "+mid);
                System.out.println("Comparisons: "+comparisons);
                return mid;
            }

            else if(arr[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        System.out.println("\nInsertion position: "+low);
        System.out.println("Comparisons: "+comparisons);

        return low;
    }

    // Floor and Ceiling
    static void floorCeiling(int arr[], int target)
    {
        Integer floor=null;
        Integer ceiling=null;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=target)
                floor=arr[i];

            if(arr[i]>=target)
            {
                ceiling=arr[i];
                break;
            }
        }

        System.out.println("Floor value: "+floor);
        System.out.println("Ceiling value: "+ceiling);
    }

    public static void main(String args[])
    {

        int risks[]={50,10,100,25};

        // Linear search on unsorted
        linearSearch(risks,30);

        // Sort for binary
        Arrays.sort(risks);

        System.out.println("\nSorted Risks:");

        for(int r:risks)
            System.out.print(r+" ");

        // Binary insertion
        binaryInsertion(risks,30);

        // Floor ceiling
        floorCeiling(risks,30);

    }
}