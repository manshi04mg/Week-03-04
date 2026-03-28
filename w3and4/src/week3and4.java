import java.util.*;

public class week3and4 {

    static class Transaction {

        String id;
        double fee;
        String timestamp;

        Transaction(String id,double fee,String timestamp)
        {
            this.id=id;
            this.fee=fee;
            this.timestamp=timestamp;
        }

        public String toString()
        {
            return id+" : "+fee+" @ "+timestamp;
        }
    }

    // Bubble Sort (for small batches)
    static void bubbleSort(ArrayList<Transaction> list)
    {
        int n=list.size();
        int swaps=0;
        int passes=0;

        for(int i=0;i<n-1;i++)
        {
            boolean swapped=false;
            passes++;

            for(int j=0;j<n-i-1;j++)
            {
                if(list.get(j).fee > list.get(j+1).fee)
                {
                    Transaction temp=list.get(j);

                    list.set(j,list.get(j+1));

                    list.set(j+1,temp);

                    swaps++;
                    swapped=true;
                }
            }

            if(!swapped)
                break;
        }

        System.out.println("Bubble Sort Result:");
        System.out.println(list);

        System.out.println("Passes: "+passes);
        System.out.println("Swaps: "+swaps);
    }

    // Insertion Sort (fee + timestamp stable)
    static void insertionSort(ArrayList<Transaction> list)
    {
        for(int i=1;i<list.size();i++)
        {
            Transaction key=list.get(i);

            int j=i-1;

            while(j>=0 && list.get(j).fee > key.fee)
            {
                list.set(j+1,list.get(j));

                j--;
            }

            list.set(j+1,key);
        }

        System.out.println("\nInsertion Sort Result:");
        System.out.println(list);
    }

    // High fee detection
    static void highFee(ArrayList<Transaction> list)
    {
        System.out.println("\nHigh Fee Transactions (>50):");

        boolean found=false;

        for(Transaction t:list)
        {
            if(t.fee>50)
            {
                System.out.println(t);
                found=true;
            }
        }

        if(!found)
            System.out.println("None");
    }

    public static void main(String args[])
    {

        ArrayList<Transaction> list=new ArrayList<>();

        list.add(new Transaction("id1",10.5,"10:00"));
        list.add(new Transaction("id2",25.0,"09:30"));
        list.add(new Transaction("id3",5.0,"10:15"));

        bubbleSort(list);

        insertionSort(list);

        highFee(list);

    }
}