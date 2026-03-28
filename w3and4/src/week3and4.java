import java.util.*;

public class week3and4 {

    static class Asset {

        String name;
        double returnRate;
        double volatility;

        Asset(String name,double returnRate,double volatility)
        {
            this.name=name;
            this.returnRate=returnRate;
            this.volatility=volatility;
        }

        public String toString()
        {
            return name+" Return:"+returnRate+
                    "% Volatility:"+volatility;
        }
    }

    // MERGE SORT (Ascending return rate - stable)
    static void mergeSort(Asset arr[],int left,int right)
    {
        if(left<right)
        {
            int mid=(left+right)/2;

            mergeSort(arr,left,mid);

            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }

    static void merge(Asset arr[],int left,int mid,int right)
    {
        int n1=mid-left+1;
        int n2=right-mid;

        Asset L[]=new Asset[n1];
        Asset R[]=new Asset[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[left+i];

        for(int j=0;j<n2;j++)
            R[j]=arr[mid+1+j];

        int i=0;
        int j=0;
        int k=left;

        while(i<n1 && j<n2)
        {
            // stable condition (<= keeps order)
            if(L[i].returnRate <= R[j].returnRate)
            {
                arr[k]=L[i];
                i++;
            }
            else
            {
                arr[k]=R[j];
                j++;
            }

            k++;
        }

        while(i<n1)
        {
            arr[k]=L[i];
            i++;
            k++;
        }

        while(j<n2)
        {
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    // QUICK SORT (Descending return + ascending volatility)
    static void quickSort(Asset arr[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);

            quickSort(arr,low,pi-1);

            quickSort(arr,pi+1,high);
        }
    }

    static int partition(Asset arr[],int low,int high)
    {
        Asset pivot=arr[high];

        int i=low-1;

        for(int j=low;j<high;j++)
        {
            if(arr[j].returnRate > pivot.returnRate ||
                    (arr[j].returnRate == pivot.returnRate &&
                            arr[j].volatility < pivot.volatility))
            {
                i++;

                Asset temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        Asset temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    public static void main(String args[])
    {

        Asset assets[] =
                {
                        new Asset("AAPL",12,5),
                        new Asset("TSLA",8,9),
                        new Asset("GOOG",15,4)
                };

        // Merge Sort
        mergeSort(assets,0,assets.length-1);

        System.out.println("Merge Sort (Ascending Return):");

        for(Asset a:assets)
            System.out.println(a);

        // Quick Sort
        quickSort(assets,0,assets.length-1);

        System.out.println("\nQuick Sort (Descending Return):");

        for(Asset a:assets)
            System.out.println(a);

    }
}