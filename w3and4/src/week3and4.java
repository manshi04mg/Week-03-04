import java.util.*;

public class week3and4 {

    // Trade class
    static class Trade {

        String id;
        int volume;

        Trade(String id,int volume)
        {
            this.id=id;
            this.volume=volume;
        }

        public String toString()
        {
            return id+" : "+volume;
        }
    }

    // MERGE SORT (Ascending volume)
    static void mergeSort(Trade arr[],int left,int right)
    {
        if(left<right)
        {
            int mid=(left+right)/2;

            mergeSort(arr,left,mid);

            mergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }

    static void merge(Trade arr[],int left,int mid,int right)
    {
        int n1=mid-left+1;
        int n2=right-mid;

        Trade L[]=new Trade[n1];
        Trade R[]=new Trade[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[left+i];

        for(int j=0;j<n2;j++)
            R[j]=arr[mid+1+j];

        int i=0;
        int j=0;
        int k=left;

        while(i<n1 && j<n2)
        {
            if(L[i].volume <= R[j].volume)
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

    // QUICK SORT (Descending)
    static void quickSort(Trade arr[],int low,int high)
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);

            quickSort(arr,low,pi-1);

            quickSort(arr,pi+1,high);
        }
    }

    static int partition(Trade arr[],int low,int high)
    {
        int pivot=arr[high].volume;

        int i=low-1;

        for(int j=low;j<high;j++)
        {
            if(arr[j].volume > pivot)
            {
                i++;

                Trade temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }

        Trade temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }

    // Merge two sorted lists
    static Trade[] mergeLists(Trade a[],Trade b[])
    {
        Trade result[]=new Trade[a.length+b.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<a.length && j<b.length)
        {
            if(a[i].volume < b[j].volume)
            {
                result[k++]=a[i++];
            }
            else
            {
                result[k++]=b[j++];
            }
        }

        while(i<a.length)
            result[k++]=a[i++];

        while(j<b.length)
            result[k++]=b[j++];

        return result;
    }

    // Total volume
    static int totalVolume(Trade arr[])
    {
        int sum=0;

        for(Trade t:arr)
        {
            sum+=t.volume;
        }

        return sum;
    }

    public static void main(String args[])
    {

        Trade trades[] =
                {
                        new Trade("trade3",500),
                        new Trade("trade1",100),
                        new Trade("trade2",300)
                };

        // Merge sort
        mergeSort(trades,0,trades.length-1);

        System.out.println("Merge Sort (Ascending):");

        for(Trade t:trades)
            System.out.println(t);

        // Quick sort
        quickSort(trades,0,trades.length-1);

        System.out.println("\nQuick Sort (Descending):");

        for(Trade t:trades)
            System.out.println(t);

        // Example merge two lists
        Trade morning[] =
                {
                        new Trade("t1",100),
                        new Trade("t2",300)
                };

        Trade afternoon[] =
                {
                        new Trade("t3",500)
                };

        Trade merged[]=mergeLists(morning,afternoon);

        int total=totalVolume(merged);

        System.out.println("\nMerged Trades:");

        for(Trade t:merged)
            System.out.println(t);

        System.out.println("\nTotal Volume: "+total);

    }
}