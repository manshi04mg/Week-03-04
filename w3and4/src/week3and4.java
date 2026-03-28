import java.util.*;

public class week3and4 {

    // Client class
    static class Client {

        String name;
        int riskScore;
        double accountBalance;

        Client(String name,int riskScore,double accountBalance)
        {
            this.name=name;
            this.riskScore=riskScore;
            this.accountBalance=accountBalance;
        }

        public String toString()
        {
            return name+" : Risk="+riskScore+
                    " Balance="+accountBalance;
        }
    }

    // Bubble Sort (Ascending risk score)
    static void bubbleSort(Client arr[])
    {
        int n=arr.length;
        int swaps=0;

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j].riskScore > arr[j+1].riskScore)
                {
                    Client temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                    swaps++;

                    // visualize swap
                    System.out.println("Swap: "+arr[j].name+
                            " with "+arr[j+1].name);
                }
            }
        }

        System.out.println("\nBubble Sort Result:");
        for(Client c:arr)
            System.out.println(c);

        System.out.println("Total swaps: "+swaps);
    }

    // Insertion Sort (Descending risk + balance)
    static void insertionSort(Client arr[])
    {
        int n=arr.length;

        for(int i=1;i<n;i++)
        {
            Client key=arr[i];

            int j=i-1;

            while(j>=0 && arr[j].riskScore < key.riskScore)
            {
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=key;
        }

        System.out.println("\nInsertion Sort (Descending Risk):");

        for(Client c:arr)
            System.out.println(c);
    }

    // Top risk clients
    static void topRisk(Client arr[])
    {
        System.out.println("\nTop Risk Clients:");

        int limit=Math.min(10,arr.length);

        for(int i=0;i<limit;i++)
        {
            System.out.println(arr[i]);
        }
    }

    public static void main(String args[])
    {

        Client clients[] =
                {
                        new Client("ClientC",80,50000),
                        new Client("ClientA",20,90000),
                        new Client("ClientB",50,70000)
                };

        bubbleSort(clients);

        insertionSort(clients);

        topRisk(clients);

    }
}